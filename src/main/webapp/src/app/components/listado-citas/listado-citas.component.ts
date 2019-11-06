import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-listado-citas',
  templateUrl: './listado-citas.component.html',
  styleUrls: ['./listado-citas.component.css']
})
export class ListadoCitasComponent implements OnInit {
  citasService: any;
  success: string;
  error: any;
  loading: boolean;

  constructor() {

  }

  ngOnInit() {

    /*
    this.citasService.getAll()
      .subscribe(
        data => {
          console.log("[CLIENTE] Cargando lista de citas...")
        },
        error => {
          this.error = error;
          this.loading = false;
        });
    */
  }

}
