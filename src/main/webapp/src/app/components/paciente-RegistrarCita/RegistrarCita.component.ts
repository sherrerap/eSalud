import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { UserService } from '../../_services';

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
        /* private userService: UserService */
    ) { }

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            tipocita: ['', Validators.required],
            especialidadcita: ['', Validators.required],
            medicocita: ['', Validators.required],
            fechacita: ['', Validators.required],
            horacita: ['', Validators.required],
        });
    }

    get f() { return this.registerForm.controls; } 

    /* onSubmit() {
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
                    console.log("[CITA] Cita registrada.")
                    this.success = "Cita registrada correctamente."
                },
                error => {
                    this.error = error;
                    this.loading = false;
                });
    } */
    //**************************************FALTA CITA SERVICE**********************************************************
}