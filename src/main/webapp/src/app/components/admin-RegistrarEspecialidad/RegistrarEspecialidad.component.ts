import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { EspecialidadesService } from '../../_services';

@Component({
    selector: 'app-RegistrarEspecialidad',
    templateUrl: './RegistrarEspecialidad.component.html',
    styleUrls: ['./RegistrarEspecialidad.component.css']
})

export class RegistrarEspecialidadComponent implements OnInit {
    registerForm: FormGroup;
    loading = false;
    submitted = false;
    error: string;
    success: string;

    constructor(
        private formBuilder: FormBuilder,
        private EspecialidadesService: EspecialidadesService,
    ) { }

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            especialidad: ['', Validators.required],
            horaInicio: ['', Validators.required],
			horaFin: ['', Validators.required],
			tiempoConsulta: ['', Validators.required],

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
        this.EspecialidadesService.register(this.registerForm.value)
            .pipe(first())
            .subscribe(
                data => {
                    console.log("[CLIENTE] Especialidad registrada.")
                    this.success = "Especialidad registrada correctamente."
                },
                error => {
                    this.error = "Error: Ya existe una especialidad con esos datos.";
                    this.loading = false;
                });
    }
}