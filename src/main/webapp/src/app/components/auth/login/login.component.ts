import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

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
        //this.checkLogin();
    }

    ngOnInit() {
        //esto desloguea el usuario antes de empezar el proceso
        this.authService.logout();

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
            .subscribe(
                data => {
                    switch (this.authService.currentUserValue.rol) {
                        case "paciente": {
                            this.router.navigate([this.returnUrl]);
                            break;
                        }
                        case "médico": {
                            console.log("[CLIENTE] La vista médico aún no ha sido implementada. Redirigiendo a citas.")
                            this.router.navigate([this.returnUrl]);
                            break;
                        }
                        case "admin": {
                            this.router.navigate(['/admin']);
                            break;
                        }
                    }
                },
                error => {
                    this.error = "Error: No se ha encontrado ningún usuario con esos datos.";
                    this.loading = false;
                });
    }

    checkLogin() {
        if (this.authService.currentUserValue) {
            switch (this.authService.currentUserValue.rol) {
                case "paciente": {
                    this.router.navigate(['/citas']);
                    break;
                }
                case "médico": {
                    console.log("[CLIENTE] La vista médico aún no ha sido implementada. Redirigiendo a citas.")
                    this.router.navigate(['/citas']);
                    break;
                }
                case "admin": {
                    this.router.navigate(['/admin']);
                    break;
                }
            }
        }

    }

    logout() {
        this.authService.logout();
        this.router.navigate(['/auth/login']);
    }
}