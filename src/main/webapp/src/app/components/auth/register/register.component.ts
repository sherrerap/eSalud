import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { UserService, AuthService } from '../../../_services';

@Component({ selector: 'app-register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.css'] })
export class RegisterComponent implements OnInit {
    registerForm: FormGroup;
    loading = false;
    submitted = false;
    error: string;

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        private authService: AuthService,
        private userService: UserService
    ) {
        // redirige al home si el usuario ya está logueado
        if (this.authService.currentUserValue) {
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            dni: ['', Validators.required],
            password: ['', [Validators.required, Validators.minLength(6)]],
            password2: ['', [Validators.required, Validators.minLength(6)]],
            correo: ['', Validators.required],
            localidad: ['', Validators.required],
            nombre: ['', Validators.required],
            apellidos: ['', Validators.required],
            tel: ['', Validators.required]
        });
    }

    // getter para acceder a los controles del form
    get f() { return this.registerForm.controls; }

    onSubmit() {
        this.submitted = true;

        // para aquí si el form es inválido
        if (this.registerForm.invalid) {
            return;
        }

        this.loading = true;
        this.userService.register(this.registerForm.value)
            .pipe(first())
            .subscribe(
                data => {
                    this.router.navigate(['/auth/login'], { queryParams: { registered: true }});
                },
                error => {
                    this.error = error;
                    this.loading = false;
                });
    }
}