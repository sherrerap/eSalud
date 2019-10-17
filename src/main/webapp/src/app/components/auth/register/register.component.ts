import { Component, OnInit } from '@angular/core';
import { ErrorStateMatcher } from '@angular/material/core';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{

  constructor() { }

  ngOnInit() {
  }
  registerUser(event){
    event.preventDefault()
    const target = event.target
    const dni = target.querySelector('#dni').value
    const password = target.querySelector('#password').value
    const password2 = target.querySelector('#password').value
    const nombre = target.querySelector('#nombre').value
    const apellidos = target.querySelector('#apellidos').value
    const tel = target.querySelector('#tel').value
    const email = target.querySelector('#email').value
    //this.Auth.getUserDetails(dni,password, password, nombre, apellidos, tel, email)
    console.log(dni,password, password, nombre, apellidos,
      tel, email)
  }

}
