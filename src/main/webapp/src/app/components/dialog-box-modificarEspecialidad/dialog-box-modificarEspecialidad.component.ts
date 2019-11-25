import { Component, Inject, Optional } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

export interface UsersData {
  especialidad: string;
  horaInicio: string;
  horaFinal: string;
  tiempoConsulta: string;
}


@Component({
  selector: 'app-dialog-box-modificarEspecialidad',
  templateUrl: './dialog-box-modificarEspecialidad.component.html',
  styleUrls: ['./dialog-box-modificarEspecialidad.component.css']
})
export class DialogBoxModificarEspecialidadComponent {

  action: string;
  local_data: any;
  especialidad: string;
  public modeselect;

  constructor(
    public dialogRef: MatDialogRef<DialogBoxModificarEspecialidadComponent>,
    //@Optional() is used to prevent error if no data is passed
    @Optional() @Inject(MAT_DIALOG_DATA) public data: UsersData) {
    console.log(data);
    this.local_data = { ...data };
    this.action = this.local_data.action;
    this.especialidad = this.local_data.especialidad;
    console.log(this.especialidad)
    this.modeselect = this.especialidad;
  }

  doAction() {
    this.dialogRef.close({ event: this.action, data: this.local_data });
  }

  closeDialog() {
    this.dialogRef.close({ event: 'Cancel' });
  }


}
