import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator,MatTableDataSource} from '@angular/material';

export interface PeriodicElement {
  nombre: string;
  apellido: string;
  rol: string;
  centro: string;
  position: number;
}

const ELEMENT_DATA: PeriodicElement[] = [
	{ position: 1, nombre: 'Juan', apellido: 'Gonzalez Garcia', rol: 'Enfermero', centro: 'Hospital General de Ciudad Real' },
	{ position: 2, nombre: 'Alba', apellido: 'Sanchez López', rol: 'Cabecera', centro: 'Centro Salud Miguelturra' },
	{ position: 3, nombre: 'Jose', apellido: 'Garcia Martinez', rol: 'Enfermero', centro: 'Hospital General de Ciudad Real' },
	{ position: 4, nombre: 'Juan', apellido: 'Garcia Moreno', rol: 'Oftalmología', centro: 'Hospital Santa Bárbara' },
	{ position: 5, nombre: 'Francisco', apellido: 'Sanchez Garcia', rol: 'Enfermero', centro: 'Centro Salud Miguelturra' },
	{ position: 6, nombre: 'Ana', apellido: 'Gonzalez Garcia', rol: 'Cabecera', centro: 'Hospital General de Ciudad Real' },
	{ position: 7, nombre: 'Elena', apellido: 'Garcia Cortés', rol: 'Enfermero', centro: 'Centro Salud Ciudad Real 3' },
	{ position: 8, nombre: 'Juan', apellido: 'Garcia López', rol: 'Cardíología', centro: 'Hospital General de Ciudad Real' },
	{ position: 9, nombre: 'Manuel', apellido: 'Garcia Garcia', rol: 'Enfermero', centro: 'Hospital Santa Bárbara' },
	{ position: 10, nombre: 'Alba', apellido: 'Gonzalez Garcia', rol: 'Cabecera', centro: 'Hospital Santa Bárbara' },
	{ position: 11, nombre: 'Laura', apellido: 'López Sanchez', rol: 'Enfermero', centro: 'Hospital General de Ciudad Real' },
	{ position: 12, nombre: 'Luis', apellido: 'Martinez Cortés', rol: 'Pediatría', centro: 'Centro Salud Miguelturra' },
	{ position: 13, nombre: 'Juan', apellido: 'Martinez Martinez', rol: 'Oftalmología', centro: 'Hospital General de Ciudad Real' },
	{ position: 14, nombre: 'María', apellido: 'Cortés López', rol: 'Enfermero', centro: 'Hospital General de Ciudad Real' },
	{ position: 15, nombre: 'Juan', apellido: 'Moreno Gonzalez', rol: 'Enfermero', centro: 'Centro Salud Almagro' },
	{ position: 16, nombre: 'Lucía', apellido: 'López Garcia', rol: 'Cabecera', centro: 'Hospital General de Ciudad Real' },
	{ position: 17, nombre: 'Juan', apellido: 'Garcia Cortés', rol: 'Pediatría', centro: 'Hospital Santa Bárbara' },
	{ position: 18, nombre: 'Mario', apellido: 'Garcia Garcia', rol: 'Cardíología', centro: 'Hospital General de Ciudad Real' },
	{ position: 19, nombre: 'Patricia', apellido: 'López Garcia', rol: 'Oftalmología', centro: 'Centro Salud Almagro' },
	{ position: 20, nombre: 'Juan', apellido: 'Martinez Garcia', rol: 'Enfermero', centro: 'Hospital General de Ciudad Real' }
];

@Component({
  selector: 'app-MostrarMedico',
  templateUrl: './MostrarMedico.component.html',
  styleUrls: ['./MostrarMedico.component.css']
})
export class MostrarMedicoComponent implements OnInit {
  displayedColumns: string[] = ['position','nombre','apellido','rol','centro'];
  dataSource= new MatTableDataSource <PeriodicElement>(ELEMENT_DATA);  
  @ViewChild(MatPaginator,{static:true}) paginator: MatPaginator;
  constructor() { }

  ngOnInit() {
	this.dataSource.paginator=this.paginator;
  }

}
