import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { UserService } from '../../_services';

@Component({
    selector: 'app-RegistrarMedico',
    templateUrl: './RegistrarMedico.component.html',
    styleUrls: ['./RegistrarMedico.component.css']
})
export class RegistrarMedicoComponent implements OnInit {
    registerForm: FormGroup;
    loading = false;
    submitted = false;
    error: string;
    success: string;

    constructor(
        private formBuilder: FormBuilder,
        private userService: UserService
    ) { }

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            dni: ['', Validators.required],
            nombre: ['', Validators.required],
            apellidos: ['', Validators.required],
            centro: ['', Validators.required],
            tel: ['', Validators.required],
            correo: ['', Validators.required],
            password: ['', Validators.required],
            rol: "médico",
            medico: "",
            especialidad: ['', Validators.required]
        });
    }

    get f() { return this.registerForm.controls; }

    onSubmit() {
        this.submitted = true;
        this.success = null;

        if (this.registerForm.invalid) {
            return;
        }

        this.loading = true;
        this.userService.register(this.registerForm.value)
            .pipe(first())
            .subscribe(
                data => {
                    console.log("[CLIENTE] Médico registrado.")
                    this.success = "Médico registrado correctamente."
                },
                error => {
                    this.error = error;
                    this.loading = false;
                });
    }
}