import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource } from '@angular/material';
import { CitasService } from 'src/app/_services';
import { first } from 'rxjs/operators';
import { AuthService } from 'src/app/_services/auth.service';
import {UserService} from 'src/app/_services/user.service';

export interface PeriodicElement {
  nombre: string;
  apellidos: string;
  fecha: string;
  hora: string;
}
const ELEMENT_DATA: PeriodicElement[] = [
  { nombre: 'position', apellidos: 'Ciudad Real III', fecha: '22/11/2019', hora: '11:54' },
  { nombre: 'Pediatría', apellidos: 'Ciudad Real III', fecha: '23/11/2019', hora: '12:00' }

];

@Component({
	selector: 'app-MostrarCitas',
	templateUrl: './MostrarCitas.component.html',
	styleUrls: ['./MostrarCitas.component.css']
})
export class MostrarCitasComponent implements OnInit {
  displayedColumns: string[] = ['nombre', 'apellidos', 'fecha', 'hora'];
  dataSource = new MatTableDataSource<PeriodicElement>();
  data: PeriodicElement[];
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(
    private citasService: CitasService,
    private authService: AuthService,
    private usuariosService: UserService
  ) {

  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.usuariosService.getUsersByRole('medicos')
      .subscribe((data: PeriodicElement[]) => {
        this.data = data;
        this.dataSource = new MatTableDataSource(data);
      });

  }

}
