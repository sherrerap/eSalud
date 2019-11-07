import { Component, Inject, Optional, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { CitasService } from '../../_services';

export interface CitaData {
  especialidad: string;
  medico: string;
  centro: string;
  horacita: string;
  fechacita: string;
}

@Component({
  selector: 'app-dialog-box-modificarCita',
  templateUrl: './dialog-box-modificarCita.component.html',
  styleUrls: ['./dialog-box-modificarCita.component.css']
})
export class DialogBoxModificarCita{
  action: string;
  local_data: any;

  constructor(
    public dialogRef: MatDialogRef<DialogBoxModificarCita>,
    //@Optional() is used to prevent error if no data is passed
    @Optional() @Inject(MAT_DIALOG_DATA) public data: CitaData) {
    console.log(data);
    this.local_data = { ...data };
    this.action = this.local_data.action;
  }

  doAction() {
    this.dialogRef.close({ event: this.action, data: this.local_data });
  }

  closeDialog() {
    this.dialogRef.close({ event: 'Cancel' });
  }

}