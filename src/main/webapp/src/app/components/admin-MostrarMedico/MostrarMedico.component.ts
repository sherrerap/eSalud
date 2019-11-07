import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource } from '@angular/material';
import { UserService } from 'src/app/_services';
export interface PeriodicElement {
	nombre: string;
	apellido: string;
	especialidad: string;
	centro: string;
}
const ELEMENT_DATA: PeriodicElement[] = [
	{ nombre: 'Enfermería', apellido: 'Ciudad Real III', especialidad: '22/11/2019', centro: '11:54' }
  
  ];
@Component({
	selector: 'app-MostrarMedico',
	templateUrl: './MostrarMedico.component.html',
	styleUrls: ['./MostrarMedico.component.css']
})
export class MostrarMedicoComponent implements OnInit {
	displayedColumns: string[] = ['nombre', 'apellido', 'especialidad', 'centro'];
	dataSource = new MatTableDataSource<PeriodicElement>();
	data: PeriodicElement[];
	@ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
	constructor(
		private usersService: UserService
	) { }

	ngOnInit() {
		this.dataSource.paginator = this.paginator;
		const medico = 'medico';
		this.usersService.getUsersByRole(medico)
			.subscribe((data: PeriodicElement[]) => {
				this.data = data;
				this.dataSource = new MatTableDataSource(data);
			});

	}

}
