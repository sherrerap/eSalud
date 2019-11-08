import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable, MatDialog } from '@angular/material';
import { DialogBoxMedicoComponent } from '../dialog-box-medico/dialog-box-medico.component';

export interface UsersData {
  dni: string;
  id: number;
  nombre: string;
  apellidos: string;
  centro: string;
  correo: string;
  telefono: string;
}
 
const ELEMENT_DATA: UsersData[] = [
  {id: 1, dni: '05345275T', nombre:'Lucia', apellidos: 'Garcia Garcia', centro:'Hospital General Ciudad Real', correo:'luc@xyz.com', telefono:'956743567'},
  {id: 2, dni: '04369275G', nombre:'Maria', apellidos: 'Ruiz Garcia',   centro:'Hospital General Ciudad Real', correo:'luc@xyz.com', telefono:'956743567'},
  {id: 3, dni: '09345275T', nombre:'Jose',  apellidos: 'López Garcia',  centro:'Hospital Puertollano',         correo:'luc@xyz.com', telefono:'956743567'},
  {id: 4, dni: '05347799H', nombre:'Angel', apellidos: 'Garcia Ruíz',   centro:'Hospital General Ciudad Real', correo:'luc@xyz.com', telefono:'956743567'},
  {id: 5, dni: '05345275T', nombre:'Lucia', apellidos: 'Garcia Garcia', centro:'Hospital General Ciudad Real', correo:'luc@xyz.com', telefono:'956743567'},
  {id: 6, dni: '04369275G', nombre:'Maria', apellidos: 'Ruiz Garcia',   centro:'Hospital General Ciudad Real', correo:'luc@xyz.com', telefono:'956743567'},
  {id: 7, dni: '09345275T', nombre:'Jose',  apellidos: 'López Garcia',  centro:'Hospital Puertollano',         correo:'luc@xyz.com', telefono:'956743567'},
  {id: 8, dni: '05347799H', nombre:'Angel', apellidos: 'Garcia Ruíz',   centro:'Hospital General Ciudad Real', correo:'luc@xyz.com', telefono:'956743567'},
  {id: 9, dni: '05345275T', nombre:'Lucia', apellidos: 'Garcia Garcia', centro:'Hospital General Ciudad Real', correo:'luc@xyz.com', telefono:'956743567'},
  {id: 10, dni: '04369275G', nombre:'Maria', apellidos: 'Ruiz Garcia',   centro:'Hospital General Ciudad Real',correo:'luc@xyz.com', telefono:'956743567'},
  {id: 11, dni: '09345275T', nombre:'Jose',  apellidos: 'López Garcia',  centro:'Hospital Puertollano',        correo:'luc@xyz.com', telefono:'956743567'},
  {id: 12, dni: '05347799H', nombre:'Angel', apellidos: 'Garcia Ruíz',   centro:'Hospital General Ciudad Real',correo:'luc@xyz.com', telefono:'956743567'}
];

@Component({
  selector: 'app-ModificarMedico',
  templateUrl: './ModificarMedico.component.html',
  styleUrls: ['./ModificarMedico.component.css']
})
export class ModificarMedicoComponent{
displayedColumns: string[] = ['id', 'dni','nombre','apellidos','centro', 'correo','telefono','action'];
  dataSource = ELEMENT_DATA;
 
  @ViewChild(MatTable,{static:true}) table: MatTable<any>;
 
  constructor(public dialog: MatDialog) {}
 
  openDialog(action,obj) {
    obj.action = action;
    const dialogRef = this.dialog.open(DialogBoxMedicoComponent, {
      width: '400px',
      data:obj
    });
 
    dialogRef.afterClosed().subscribe(result => {
       if(result.event == 'Update'){
        this.updateRowData(result.data);
      }else if(result.event == 'Delete'){
        this.deleteRowData(result.data);
      }
    });
  }
 
  addRowData(row_obj){
    var d = new Date();
    this.dataSource.push({
      id:d.getTime(),
      dni:row_obj.dni,
      nombre:row_obj.nombre,
	  apellidos:row_obj.apellidos,
      centro:row_obj.centro,
      correo:row_obj.correo,
      telefono:row_obj.telefono
    });
    this.table.renderRows();
    
  }
  updateRowData(row_obj){
    this.dataSource = this.dataSource.filter((value,key)=>{
      if(value.id == row_obj.id){
        value.dni = row_obj.dni;
        value.apellidos =row_obj.apellidos;
		value.nombre =row_obj.nombre;
		value.centro= row_obj.centro;
		value.correo= row_obj.correo;
		value.telefono=row_obj.telefono;
      }
      return true;
    });
  }
  deleteRowData(row_obj){
    this.dataSource = this.dataSource.filter((value,key)=>{
      return value.id != row_obj.id;
    });
  }
 
 

}
