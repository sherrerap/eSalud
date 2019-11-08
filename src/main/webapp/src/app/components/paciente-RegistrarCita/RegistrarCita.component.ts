import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { CitasService, AuthService } from '../../_services';

@Component({
    selector: 'app-RegistrarCita',
    templateUrl: './RegistrarCita.component.html',
    styleUrls: ['./RegistrarCita.component.css']
})
export class RegistrarCitaComponent implements OnInit {
    registerForm: FormGroup;
    loading = false;
    submitted = false;
    error: string;
    success: string;

    constructor(
        private formBuilder: FormBuilder,
        private citasService: CitasService,
        private authService: AuthService
    ) { }

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            tipo: ['', Validators.required],
            especialidad: ['', Validators.required],
            medico: ['', Validators.required],
            fecha: ['', Validators.required],
            hora: ['', Validators.required],
            paciente: this.authService.currentUserValue.dni,
            centro: this.authService.currentUserValue.centro
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
        this.citasService.register(this.registerForm.value)
            .pipe(first())
            .subscribe(
                data => {
                    console.log("[CLIENTE] Cita registrada.")
                    this.success = "Cita registrada correctamente."
                },
                error => {
                    this.error = error;
                    this.loading = false;
                });
    }
}