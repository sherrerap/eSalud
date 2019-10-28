import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/_services';
import { Router } from '@angular/router';


@Component({
  selector: 'app-listado-citas',
  templateUrl: './listado-citas.component.html',
  styleUrls: ['./listado-citas.component.css']
})
export class ListadoCitasComponent implements OnInit {

  constructor(private authService: AuthService, router: Router) {
    if (localStorage.getItem('currentUser') == undefined) {
      this.authService.logout();
      router.navigate(['/']);
    }
  }

  ngOnInit() {
  }

}
