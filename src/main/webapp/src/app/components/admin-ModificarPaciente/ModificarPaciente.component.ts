import { Component, ViewChild } from '@angular/core';
import { MatDialog, MatTableDataSource, MatPaginator } from '@angular/material';
import { DialogBoxPacienteComponent } from '../dialog-box-paciente/dialog-box-paciente.component';
import { AuthService, UserService } from 'src/app/_services';
import { FormGroup, FormBuilder } from '@angular/forms';
import { first } from 'rxjs/operators';

export interface UsersData {
  id:string;  
  dni: string;
  nombre: string;
  apellidos: string;
  numTelefono: string;
  localidad:string;
  centro: string;
  email: string;
  rol:string;
  contrasena:string;
  especialidad:string;
}
 
const ELEMENT_DATA: UsersData[] = [];

@Component({
  selector: 'app-ModificarPaciente',
  templateUrl: './ModificarPaciente.component.html',
  styleUrls: ['./ModificarPaciente.component.css']
})
export class ModificarPacienteComponent{
displayedColumns: string[] = ['nombre','apellidos','numTelefono','localidad','centro','email','action'];
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
    this.usuariosService.getUsersByRole('pacientes')
      .subscribe((data: UsersData[]) => {
        this.data = data;
        this.dataSource = new MatTableDataSource(data);
      });

  }
	openDialog(action, obj) {
		obj.action = action;
		const dialogRef = this.dialog.open(DialogBoxPacienteComponent, {
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
				value.localidad = row_obj.localidad;
				value.centro = row_obj.centro;
				value.email=row_obj.email;
				value.rol=row_obj.rol;
				value.contrasena=row_obj.contrasena;
				value.especialidad=row_obj.especialidad;
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
			localidad: row_obj.localidad,
			centro: row_obj.centro,
			email: row_obj.email,
			rol:row_obj.rol,
			contrasena: row_obj.contrasena,
			especialidad: row_obj.especialidad,
		});
		this.usuariosService.update(this.usuarioForm.value,this.usuarioForm.controls.dni.value)
			.pipe(first())
			.subscribe(
				data => {
					console.log("[CLIENTE] Cliente actualizada.")
					this.success = "Cliente actualizado correctamente."
					this.dataSource.paginator = this.paginator;
    				this.usuariosService.getUsersByRole('pacientes')
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
			localidad: row_obj.localidad,
			centro: row_obj.centro,
			email: row_obj.email,
			rol:row_obj.rol,
			contrasena: row_obj.contrasena,
			especialidad: row_obj.especialidad,
		});
		this.usuariosService.delete(this.usuarioForm.controls.id.value)
			.pipe(first())
			.subscribe(
				data => {
					console.log("[CLIENTE] Usuario borrado.")
					this.success = "Usuario borrado correctamente."
					this.dataSource.paginator = this.paginator;
					this.usuariosService.getUsersByRole('pacientes')
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