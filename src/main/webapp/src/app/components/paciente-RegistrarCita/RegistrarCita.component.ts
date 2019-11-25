import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { CitasService, AuthService } from '../../_services';
import { TooltipComponent } from '@angular/material';
import { BehaviorSubject, Observable } from 'rxjs';

export interface Especialidad {
    id: string;
    especialidad: string;
    horaInicio: string;
    horaFin: string;
    tiempoConsulta: string;
}

export interface Cita{
    id: string;
    paciente: string;
    tipo: string;
    fecha: string;
    centro: string;
    medico: string;
    hora: string;
}

export interface Medico {
    dni: string;
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
    horasLibres: Cita[];
    fechaSeleccionada: string='';
    medicoSeleccionado: string='';

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


        this.especialidades = [];
        this.medicos = [];
        this.horasLibres = [];
        this.getEspecialidades();
        this.getMedicos();
    }

    get f() { return this.registerForm.controls; }

    onSubmit() {
        console.log(this.registerForm.value.especialidad);
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

    getHorasLibres(){
        this.citasService.getHorasLibres(this.medicoSeleccionado, this.fechaSeleccionada)
        .subscribe((data: Cita[]) => {
            this.horasLibres = data;
        },
            error => {
                this.error = "Ha ocurrido un error recogiendo las especialidades disponibles.";
            });;
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
    capturarFecha(){
       this.getHorasLibres();
    }

    getMedicos() {
        //this.medicos.push(this.citasService.getMedicos(this.registerForm.controls.especialidad));
    }
}