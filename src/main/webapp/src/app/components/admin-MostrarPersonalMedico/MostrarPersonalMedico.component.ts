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

export interface PersonalMedico {
  value: string;
  display: string;
}
const ELEMENT_DATA: UsersData[] = [];


@Component({
  selector: 'app-MostrarPersonalMedico',
  templateUrl: './MostrarPersonalMedico.component.html',
  styleUrls: ['./MostrarPersonalMedico.component.css']
})
export class MostrarPersonalMedicoComponent{
displayedColumns: string[] = ['dni','nombre','apellidos','centro', 'email','numTelefono','especialidad'];
   dataSource = new MatTableDataSource<UsersData>();
  data: UsersData[];
  usuarioForm: FormGroup;
  selectDay: string ='';
     countrySelected: string;
selectedCountry: string; 
   PersonalMedicos: PersonalMedico[] = [
      {value: 'medicos', display: 'Médico'},
      {value: 'pacientes', display: 'Pacientes'},
   ];
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(
    private authService: AuthService,
    private usuariosService: UserService,
	public dialog: MatDialog,
	private formBuilder: FormBuilder,
  ) {

  }
 
   ngOnInit() {

  }
onRolSelectionChanged(changeEvent) {
    if (changeEvent && changeEvent.isUserInput && this.selectedCountry != changeEvent.source.value) {
      console.log(changeEvent.source.value)
      this.dataSource.paginator = this.paginator;
    this.usuariosService.getUsersByRole(changeEvent.source.value)
      .subscribe((data: UsersData[]) => {
        this.data = data;
        this.dataSource = new MatTableDataSource(data);
      });
    }
  }
}