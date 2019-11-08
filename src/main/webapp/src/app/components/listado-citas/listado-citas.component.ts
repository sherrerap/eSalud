import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource } from '@angular/material';
import { CitasService } from 'src/app/_services';
import { first } from 'rxjs/operators';
import { AuthService } from 'src/app/_services/auth.service';


export interface PeriodicElement {
  tipo: string;
  centro: string;
  fecha: string;
  hora: string;
}
const ELEMENT_DATA: PeriodicElement[] = [
  { tipo: 'Enfermería', centro: 'Ciudad Real III', fecha: '22/11/2019', hora: '11:54' },
  { tipo: 'Pediatría', centro: 'Ciudad Real III', fecha: '23/11/2019', hora: '12:00' }

];

@Component({
  selector: 'app-listado-citas',
  templateUrl: './listado-citas.component.html',
  styleUrls: ['./listado-citas.component.css']
})
export class ListadoCitasComponent implements OnInit {
  displayedColumns: string[] = ['tipo', 'centro', 'fecha', 'hora'];
  dataSource = new MatTableDataSource<PeriodicElement>();
  data: PeriodicElement[];
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(
    private citasService: CitasService,
    private authService: AuthService
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

}
