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
const ELEMENT_DATA: PeriodicElement[] = [
  { nombre: 'position', apellidos: 'Ciudad Real III', especialidad: '22/11/2019', centro: '11:54' },
  { nombre: 'Pediatría', apellidos: 'Ciudad Real III', especialidad: '23/11/2019', centro: '12:00' }

];

@Component({
	selector: 'app-MostrarMedico',
	templateUrl: './MostrarMedico.component.html',
	styleUrls: ['./MostrarMedico.component.css']
})
export class MostrarMedicoComponent implements OnInit {
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
    this.usuariosService.getUsersByRole('médico')
      .subscribe((data: PeriodicElement[]) => {
        this.data = data;
        this.dataSource = new MatTableDataSource(data);
      });

  }

}
