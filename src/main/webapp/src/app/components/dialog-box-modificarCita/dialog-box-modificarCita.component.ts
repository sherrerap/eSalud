import { Component, Inject, Optional, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { CitasService } from '../../_services';

@Component({
  selector: 'app-dialog-box-modificarCita',
  templateUrl: './dialog-box-modificarCita.component.html',
  styleUrls: ['./dialog-box-modificarCita.component.css']
})
export class DialogBoxModificarCita implements OnInit {
    registerForm: FormGroup;
    loading = false;
    submitted = false;
    error: string;
    success: string;

    constructor(
        private formBuilder: FormBuilder,
        private citaService: CitasService
    ) { }

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            idCita: ['', Validators.required],
            idPaciente: ['', Validators.required],
            fecha: ['', Validators.required],
            tipo: ['', Validators.required],
            centro: ['', Validators.required],
            id_medico: ['', Validators.required],
            hora: ['', Validators.required]
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
        this.citaService.update(this.registerForm.value)
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