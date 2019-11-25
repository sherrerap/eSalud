import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource, MatDialog } from '@angular/material';
import { CitasService } from 'src/app/_services';
import { first } from 'rxjs/operators';
import { AuthService } from 'src/app/_services/auth.service';
import { DialogBoxModificarCita } from '../dialog-box-modificarCita/dialog-box-modificarCita.component';
import { FormBuilder, FormGroup } from '@angular/forms';


export interface PeriodicElement {
	id: string;
	tipo: string;
	centro: string;
	fecha: string;
	hora: string;
	medico: string;
}

@Component({
	selector: 'app-listado-citas',
	templateUrl: './listado-citas.component.html',
	styleUrls: ['./listado-citas.component.css']
})
export class ListadoCitasComponent implements OnInit {
	displayedColumns: string[] = ['tipo', 'centro', 'fecha', 'hora', 'action'];
	dataSource = new MatTableDataSource<PeriodicElement>();
	data: PeriodicElement[];
	submitted = false;
	error: string;
	success: string;
	loading = false;
	citaForm: FormGroup;
	especialidades: string[];
	medicos: string[];
	@ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

	constructor(
		private citasService: CitasService,
		private authService: AuthService,
		public dialog: MatDialog,
		private formBuilder: FormBuilder,
	) {

	}

	ngOnInit() {
		this.dataSource.paginator = this.paginator;
		this.citasService.getCitasPaciente(this.authService.currentUserValue.dni)
			.subscribe((data: PeriodicElement[]) => {
				this.data = data;
				this.dataSource = new MatTableDataSource(data);
			});

	}
	openDialog(action, obj) {
		obj.action = action;
		const dialogRef = this.dialog.open(DialogBoxModificarCita, {
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
				value.tipo = row_obj.tipo;
				value.centro = row_obj.centro;
				value.fecha = row_obj.fecha;
				value.hora = row_obj.hora;
				value.medico = row_obj.medico;
			}
			return true;
		});
		this.submitted = true;
		this.success = null;
		this.citaForm = this.formBuilder.group({
			id: row_obj.id,
			tipo: row_obj.tipo,
			centro: row_obj.centro,
			fecha: row_obj.fecha,
			hora: row_obj.hora,
			paciente: row_obj.paciente,
			medico: row_obj.medico
		});
		this.citasService.update(this.citaForm.value, this.citaForm.controls.id.value)
			.pipe(first())
			.subscribe(
				data => {
					console.log("[CLIENTE] Cita actualizada.")
					this.success = "Cita actualizada correctamente."
				},
				error => {
					this.error = error;
					this.loading = false;
				});
	}
	deleteRowData(row_obj) {
		this.data = this.data.filter((value, key) => {
			return value.id != row_obj.id;
		});
		this.citaForm = this.formBuilder.group({
			id: row_obj.id,
			tipo: row_obj.tipo,
			centro: row_obj.centro,
			fecha: row_obj.fecha,
			hora: row_obj.hora,
			paciente: row_obj.paciente,
			medico: row_obj.medico
		});
		this.citasService.delete(this.citaForm.controls.id.value)
			.pipe(first())
			.subscribe(
				data => {
					console.log("[CLIENTE] Cita borrada.")
					this.success = "Cita borrada correctamente."
					this.dataSource.paginator = this.paginator;
					this.citasService.getCitasPaciente(this.authService.currentUserValue.dni)
						.subscribe((data: PeriodicElement[]) => {
							this.data = data;
							this.dataSource = new MatTableDataSource(data);
						});
				},
				error => {
					this.error = 'Ha ocurrido un error al eliminar la cita.';
					this.loading = false;
				});
	}

	getEspecialidades() {
		
	}

	getMedicos() {

	}

}