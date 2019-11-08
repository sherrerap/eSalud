import { Component, Inject, Optional } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

export interface UsersData {
  dni: string;
  id: number;
  nombre: string;
  apellidos: string;
  centro: string;
  correo: string;
  telefono: string;
}


@Component({
  selector: 'app-dialog-box-medico',
  templateUrl: './dialog-box-medico.component.html',
  styleUrls: ['./dialog-box-medico.component.css']
})
export class DialogBoxMedicoComponent {

  action: string;
  local_data: any;

  constructor(
    public dialogRef: MatDialogRef<DialogBoxMedicoComponent>,
    //@Optional() is used to prevent error if no data is passed
    @Optional() @Inject(MAT_DIALOG_DATA) public data: UsersData) {
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
