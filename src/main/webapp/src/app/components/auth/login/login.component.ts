import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AuthService } from '../../../_services'

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    error: string;
    success: string;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authService: AuthService
    ) {
        // redirige al inicio si ya estás logueado
        if (this.authService.currentUserValue) {
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            dni: ['', Validators.required],
            password: ['', Validators.required]
        });

        // obtiene la url devuelta de los parámetros de ruta o lleva al inicio '/' (TODO: elegir ruta dependiendo del tipo de usuario)
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/citas';

        // muestra mensaje de éxito al registrarse
        if (this.route.snapshot.queryParams['registered']) {
            this.success = 'Registro completado';
        }
    }

    // getter para obtener los controles del form
    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        // resetea las alarmas al acceder
        this.error = null;
        this.success = null;

        // para si el form es inválido
        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        this.authService.login(this.f.dni.value, this.f.password.value)
            .pipe(first())
            .subscribe(
                data => {
                    this.router.navigate(['/citas']);
                },
                error => {
                    this.error = error;
                    this.loading = false;
                });
    }

    logout() {
        this.authService.logout();
        this.router.navigate(['/auth/login']);
    }
}