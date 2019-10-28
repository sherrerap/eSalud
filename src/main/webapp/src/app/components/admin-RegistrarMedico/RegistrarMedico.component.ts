import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { UserService, AuthService } from '../../_services';

@Component({ selector: 'app-RegistrarMedico',
    templateUrl: './RegistrarMedico.component.html',
    styleUrls: ['./RegistrarMedico.component.css'] })
export class RegistrarMedicoComponent implements OnInit {
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
        
        if (this.authService.currentUserValue) {
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            dni: ['', Validators.required],
            nombre: ['', Validators.required],
            apellidos: ['', Validators.required],
            centro: ['', Validators.required],
            telefono: ['', Validators.required],
            correo: ['', Validators.required],
            contrasena: ['', Validators.required]
        });
    }

    get f() { return this.registerForm.controls; }

    onSubmit() {
        this.submitted = true;

        if (this.registerForm.invalid) {
            return;
        }

        this.loading = true;
        this.userService.registerMedico(this.f.dni.value,this.f.nombre.value,this.f.apellidos.value,this.f.centro.value,
									this.f.telefono.value,this.f.correo.value,this.f.contrasena.value,) 
            .pipe(first())
            .subscribe(
                data => {
                    
                },
                error => {
                    this.error = error;
                    this.loading = false;
                });
    }
}