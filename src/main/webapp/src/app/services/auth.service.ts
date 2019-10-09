import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http"

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }

  /* getUserDetails(dni, password) {
    return this.http.post('/api/auth', {
      dni,
      password
    }).subscribe(data => {
      console.log(data, " is what we got from the server.")
    })
  } */

  
}
