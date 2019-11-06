import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator,MatTableDataSource} from '@angular/material';

export interface PeriodicElement {
  position: number;
  tipo: string;
  centro: string;
  fecha: string;
  hora: string;
}
const ELEMENT_DATA: PeriodicElement[] = [
  { position: 1, tipo: 'Enfermería', centro: 'Ciudad Real III', fecha: '22/11/2019', hora: '11:54' },
  { position: 2, tipo: 'Pediatría', centro: 'Ciudad Real III', fecha: '23/11/2019', hora: '12:00' }
  
];

@Component({
  selector: 'app-listado-citas',
  templateUrl: './listado-citas.component.html',
  styleUrls: ['./listado-citas.component.css']
})
export class ListadoCitasComponent implements OnInit {
  displayedColumns: string[] = ['position','tipo','centro','fecha','hora'];
  dataSource= new MatTableDataSource <PeriodicElement>(ELEMENT_DATA);  
  @ViewChild(MatPaginator,{static:true}) paginator: MatPaginator;

  constructor() {
  }

  ngOnInit() {
    this.dataSource.paginator=this.paginator;
    }

}
