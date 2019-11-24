import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource } from '@angular/material';
import { CitasService } from 'src/app/_services';
import { first } from 'rxjs/operators';
import { AuthService } from 'src/app/_services/auth.service';
import {UserService} from 'src/app/_services/user.service';

export interface PeriodicElement {
  
  Especialidad: string;
  TiempoConsulta: string;
}
const ELEMENT_DATA: PeriodicElement[] = [
  {Especialidad: 'Traumatología', TiempoConsulta: '15' }

];

@Component({
	selector: 'app-MostrarEspecialidades',
	templateUrl: './MostrarEspecialidades.component.html',
	styleUrls: ['./MostrarEspecialidades.component.css']
})

export class MostrarEspecialidadesComponent {
  displayedColumns: string[] = ['Especialidad', 'TiempoConsulta'];
  dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);
  data: PeriodicElement[];
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(
    private citasService: CitasService,
    private authService: AuthService,
    private usuariosService: UserService
  ) {

  }



}
