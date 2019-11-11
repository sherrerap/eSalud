import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable, MatDialog, MatTableDataSource, MatPaginator } from '@angular/material';
import { DialogBoxPacienteComponent } from '../dialog-box-paciente/dialog-box-paciente.component';
import { CitasService, AuthService, UserService } from 'src/app/_services';

export interface UsersData {
  dni: string;
  nombre: string;
  apellidos: string;
  numTelefono: string;
  localidad:string;
  centro: string;
  email: string;
  
}
 
const ELEMENT_DATA: UsersData[] = [];

@Component({
  selector: 'app-ModificarPaciente',
  templateUrl: './ModificarPaciente.component.html',
  styleUrls: ['./ModificarPaciente.component.css']
})
export class ModificarPacienteComponent{
displayedColumns: string[] = ['dni','nombre','apellidos','numTelefono','localidad','centro','email'];
   dataSource = new MatTableDataSource<UsersData>();
  data: UsersData[];
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(
    private citasService: CitasService,
    private authService: AuthService,
    private usuariosService: UserService
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
 
 

}