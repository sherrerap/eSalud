import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { UserService, AuthService} from '../../../_services';
import { AlertService } from 'src/app/_services/alert.service';

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
    registerForm: FormGroup;
    loading = false;
    submitted = false;

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        private authService: AuthService,
        private userService: UserService,
        private alertService : AlertService
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
            tel: ['', Validators.required],
            rol: 'paciente'
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
        if (this.f.password.value == this.f.password2.value) {
            this.userService.register(this.registerForm.value)
                .pipe(first())
                .subscribe(
                    data => {
                        this.alertService.success('Registration successful', true);
                        this.router.navigate(['/auth/login'], { queryParams: { registered: true } });
                    },
                    error => {
                        this.alertService.error(error);
                        this.loading = false;
                    });
        } else{
            this.alertService.error("Las contraseñas no coinciden", false);
        }

    }
}