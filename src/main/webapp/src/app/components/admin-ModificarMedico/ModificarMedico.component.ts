import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable, MatDialog, MatTableDataSource, MatPaginator } from '@angular/material';
import { DialogBoxMedicoComponent } from '../dialog-box-medico/dialog-box-medico.component';
import { AuthService, UserService } from 'src/app/_services';
import { FormBuilder, FormGroup } from '@angular/forms';
import { first } from 'rxjs/operators';

export interface UsersData {
  dni: string;
  id: string;
  nombre: string;
  apellidos: string;
  numTelefono: string;
  centro: string;
  email: string;
  especialidad: string;
  rol:string;
  contrasena: string;
  localidad: string;
}
const ELEMENT_DATA: UsersData[] = [];

@Component({
  selector: 'app-ModificarMedico',
  templateUrl: './ModificarMedico.component.html',
  styleUrls: ['./ModificarMedico.component.css']
})
export class ModificarMedicoComponent{
displayedColumns: string[] = ['dni','nombre','apellidos','centro', 'email','numTelefono','especialidad','action'];
   dataSource = new MatTableDataSource<UsersData>();
  data: UsersData[];
  submitted = false;
  error: string;
  success: string;
  loading = false;
  usuarioForm: FormGroup;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(
    private authService: AuthService,
    private usuariosService: UserService,
	public dialog: MatDialog,
	private formBuilder: FormBuilder,
  ) {

  }
 
   ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.usuariosService.getUsersByRole('medicos')
      .subscribe((data: UsersData[]) => {
        this.data = data;
        this.dataSource = new MatTableDataSource(data);
      });

  }
	openDialog(action, obj) {
		obj.action = action;
		const dialogRef = this.dialog.open(DialogBoxMedicoComponent, {
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
			if (value.dni == row_obj.dni) {
				value.nombre = row_obj.nombre;
				value.apellidos = row_obj.apellidos;
				value.numTelefono = row_obj.numTelefono;
				value.centro = row_obj.centro;
				value.email = row_obj.email;
				value.especialidad=row_obj.especialidad;
				value.rol=row_obj.rol;
				value.contrasena=row_obj.contrasena;
				value.localidad=row_obj.localidad;
			}
			return true;
		});
		this.submitted = true;
		this.success = null;
		this.usuarioForm = this.formBuilder.group({
			id: row_obj.id,
			dni: row_obj.dni,
			nombre: row_obj.nombre,
			apellidos: row_obj.apellidos,
			numTelefono: row_obj.numTelefono,
			centro: row_obj.centro,
			email: row_obj.email,
			especialidad: row_obj.especialidad,
			rol:row_obj.rol,
			contrasena: row_obj.contrasena,
			localidad: row_obj.localidad
		});
		this.usuariosService.update(this.usuarioForm.value,this.usuarioForm.controls.dni.value)
			.pipe(first())
			.subscribe(
				data => {
					console.log("[CLIENTE] Medico actualizado.")
					this.success = "Medico actualizado correctamente."
					this.dataSource.paginator = this.paginator;
    				this.usuariosService.getUsersByRole('medicos')
      				.subscribe((data: UsersData[]) => {
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
			return value.dni != row_obj.dni;
		});
		this.usuarioForm = this.formBuilder.group({
			id: row_obj.id,
			dni: row_obj.dni,
			nombre: row_obj.nombre,
			apellidos: row_obj.apellidos,
			numTelefono: row_obj.numTelefono,
			centro: row_obj.centro,
			email: row_obj.email,
			especialidad: row_obj.especialidad,
			rol:row_obj.rol,
			contrasena: row_obj.contrasena,
			localidad: row_obj.localidad
		});
		this.usuariosService.delete(this.usuarioForm.controls.id.value)
			.pipe(first())
			.subscribe(
				data => {
					console.log("[CLIENTE] Medico borrado.")
					this.success = "Medico borrado correctamente."
					this.dataSource.paginator = this.paginator;
					this.usuariosService.getUsersByRole('medicos')
						.subscribe((data: UsersData[]) => {
							this.data = data;
							this.dataSource = new MatTableDataSource(data);
						});
				},
				error => {
					this.error = 'Ha ocurrido un error al eliminar el usuario.';
					this.loading = false;
				});
	}
 
}