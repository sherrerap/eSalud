import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { CitasService, AuthService, UserService } from '../../_services';

export interface Especialidad {
    id: string;
    especialidad: string;
    horaInicio: string;
    horaFin: string;
    tiempoConsulta: string;
}

export interface Medico {
    dni: string;
    nombre: string;
    apellidos: string;
}

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
    especialidades: Especialidad[];
    medicos: Medico[];
    especialidadSeleccionada: string = '';

    constructor(
        private formBuilder: FormBuilder,
        private citasService: CitasService,
        private authService: AuthService,
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
        this.especialidades = [];
        this.medicos = [];
        this.getEspecialidades();
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
                    this.error = "Error: Ya existe una cita con esos datos.";
                    this.loading = false;
                });
    }


    getEspecialidades() {
        this.citasService.getEspecialidades()
            .subscribe((data: Especialidad[]) => {
                this.especialidades = data;
            },
                error => {
                    this.error = "Ha ocurrido un error recogiendo las especialidades disponibles.";
                });;
    }

    capturarEspecialidad(){
        this.getMedicos(this.especialidadSeleccionada);
    }

    getMedicos(esp) {
        this.citasService.getMedicos(esp)
            .subscribe((data: Medico[]) => {
                this.medicos = data;
            },
                error => {
                    this.error = "Ha ocurrido un error recogiendo las especialidades disponibles.";
                });;
    }
}