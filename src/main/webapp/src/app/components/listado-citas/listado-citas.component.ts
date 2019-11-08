import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource, MatDialog } from '@angular/material';
import { CitasService } from 'src/app/_services';
import { first } from 'rxjs/operators';
import { AuthService } from 'src/app/_services/auth.service';
import { DialogBoxModificarCita } from '../dialog-box-modificarCita/dialog-box-modificarCita.component';


export interface PeriodicElement {
  id: string;
  tipo: string;
  centro: string;
  fecha: string;
  hora: string;
}

@Component({
  selector: 'app-listado-citas',
  templateUrl: './listado-citas.component.html',
  styleUrls: ['./listado-citas.component.css']
})
export class ListadoCitasComponent implements OnInit {
  displayedColumns: string[] = ['tipo', 'centro', 'fecha', 'hora','action'];
  dataSource = new MatTableDataSource<PeriodicElement>();
  data: PeriodicElement[];
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(
    private citasService: CitasService,
    private authService: AuthService,
	public dialog: MatDialog
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
 openDialog(action,obj) {
    obj.action = action;
    const dialogRef = this.dialog.open(DialogBoxModificarCita, {
      width: '400px',
      data:obj
    });
 
    dialogRef.afterClosed().subscribe(result => {
      if(result.event == 'Update'){
        this.updateRowData(result.data);
      }else if(result.event == 'Delete'){
        this.deleteRowData(result.data);
      }
    });
  }
  updateRowData(row_obj){
    this.data = this.data.filter((value,key)=>{
      if(value.id == row_obj.id){
        value.tipo = row_obj.tipo;
        value.centro =row_obj.centro;
		value.fecha =row_obj.fecha;
		value.hora= row_obj.hora;
      }
      return true;
    });
  }
  deleteRowData(row_obj){
    this.data = this.data.filter((value,key)=>{
      return value.id != row_obj.id;
    });
  }

}
