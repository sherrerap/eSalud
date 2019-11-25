import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource } from '@angular/material';
import { CitasService } from 'src/app/_services';
import { first } from 'rxjs/operators';
import { AuthService } from 'src/app/_services/auth.service';
import {UserService} from 'src/app/_services/user.service';

export interface PeriodicElement {
  nombre: string;
  apellidos: string;
  especialidad: string;
  centro: string;
}
const ELEMENT_DATA: PeriodicElement[] = [];

@Component({
	selector: 'app-RegistrarEspecialidad',
	templateUrl: './RegistrarEspecialidad.component.html',
	styleUrls: ['./RegistrarEspecialidad.component.css']
})
export class RegistrarEspecialidadComponent implements OnInit {
  displayedColumns: string[] = ['nombre', 'apellidos', 'especialidad', 'centro'];
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
