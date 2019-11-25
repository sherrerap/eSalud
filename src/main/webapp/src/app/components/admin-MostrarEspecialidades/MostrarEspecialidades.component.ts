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
  
  especialidad: string;
  tiempoConsulta: string;
  horaInicio: string;
  horaFin: string
}
const ELEMENT_DATA: PeriodicElement[] = [];

@Component({
	selector: 'app-MostrarEspecialidades',
	templateUrl: './MostrarEspecialidades.component.html',
	styleUrls: ['./MostrarEspecialidades.component.css']
})

export class MostrarEspecialidadesComponent implements OnInit {
  displayedColumns: string[] = ['especialidad', 'horaInicio', 'horaFin','tiempoConsulta', 'action'];
  
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
	private formBuilder: FormBuilder,
    
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
