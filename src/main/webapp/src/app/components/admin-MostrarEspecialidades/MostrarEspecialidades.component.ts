import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource, MatDialog} from '@angular/material';
import { CitasService } from 'src/app/_services';
import { first } from 'rxjs/operators';
import { AuthService } from 'src/app/_services/auth.service';
import {UserService} from 'src/app/_services/user.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import {DialogBoxModificarEspecialidadComponent} from '../dialog-box-modificarEspecialidad/dialog-box-modificarEspecialidad.component'
import { EspecialidadesService } from 'src/app/_services/especialidades.service';

export interface PeriodicElement {
  
  Especialidad: string;
  TiempoConsulta: string;
  HoraInicio: string;
  HoraFin: string
}
const ELEMENT_DATA: PeriodicElement[] = [
  {Especialidad: 'Traumatología', HoraInicio: '08:45',TiempoConsulta: '15', HoraFin: '10:30' }

];

@Component({
	selector: 'app-MostrarEspecialidades',
	templateUrl: './MostrarEspecialidades.component.html',
	styleUrls: ['./MostrarEspecialidades.component.css']
})

export class MostrarEspecialidadesComponent {
  displayedColumns: string[] = ['Especialidad', 'HoraInicio', 'HoraFin','TiempoConsulta', 'action'];
  
  dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);
  data: PeriodicElement[];
  submitted = false;
  error: string;
  success: string;
  loading = false;
  usuarioForm: FormGroup;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(
    private especialidadesService: EspecialidadesService,
    public dialog: MatDialog,

    
  ) {

  }
  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.especialidadesService.getAll()
      .subscribe((data: PeriodicElement[]) => {
        this.data = data;
        this.dataSource = new MatTableDataSource(data);
      });

  }
	openDialog(action, obj) {
		obj.action = action;
		const dialogRef = this.dialog.open(DialogBoxModificarEspecialidadComponent, {
			width: '400px',
			data: obj
		});

		
	}


}
