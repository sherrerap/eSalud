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
  id:string;
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
		dialogRef.afterClosed().subscribe(result => {
			if (result.event == 'Update') {
				this.updateRowData(result.data);
			} else if (result.event == 'Delete') {
				this.deleteRowData(result.data);
			}
		});
	}
	updateRowData(row_obj) {
		this.data = this.data.filter((value, key) => {
			if (value.id == row_obj.id) {
				value.especialidad = row_obj.especialidad;
				value.tiempoConsulta = row_obj.tiempoConsulta;
				value.horaInicio = row_obj.horaInicio;
				value.horaFin = row_obj.horaFin;
			}
			return true;
		});
		this.submitted = true;
		this.success = null;
		this.usuarioForm = this.formBuilder.group({
			id: row_obj.id,
			especialidad: row_obj.especialidad,
			tiempoConsulta: row_obj.tiempoConsulta,
			horaInicio: row_obj.horaInicio,
			horaFin: row_obj.horaFin,
		});
		this.especialidadesService.update(this.usuarioForm.value,this.usuarioForm.controls.dni.value)
			.pipe(first())
			.subscribe(
				data => {
					console.log("[CLIENTE] Especialidad actualizada.")
					this.success = "Especialidad actualizada correctamente."
					this.dataSource.paginator = this.paginator;
    				this.especialidadesService.getAll()
      				.subscribe((data: PeriodicElement[]) => {
        			this.data = data;
        			this.dataSource = new MatTableDataSource(data);
      });
				},
				error => {
					this.error = error;
					this.loading = false;
				});
	}
	deleteRowData(row_obj) {
		this.data = this.data.filter((value, key) => {
			return value.especialidad != row_obj.especilidad;
		});
		this.usuarioForm = this.formBuilder.group({
			id: row_obj.id,
			especialidad: row_obj.especialidad,
			tiempoConsulta: row_obj.tiempoConsulta,
			horaInicio: row_obj.horaInicio,
			horaFin: row_obj.horaFin,
		});
		this.especialidadesService.delete(this.usuarioForm.controls.especialidad.value)
			.pipe(first())
			.subscribe(
				data => {
					console.log("[CLIENTE] Especialidad borrada.")
					this.success = "Especialidad borrado correctamente."
					this.dataSource.paginator = this.paginator;
					this.especialidadesService.getAll()
						.subscribe((data: PeriodicElement[]) => {
							this.data = data;
							this.dataSource = new MatTableDataSource(data);
						});
				},
				error => {
					this.error = 'Ha ocurrido un error al eliminar la especialidad.';
					this.loading = false;
				});
	}
 
		
	
}
