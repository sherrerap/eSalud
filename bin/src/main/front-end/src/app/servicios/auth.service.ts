import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { JwtUser } from '../models/jwt-user';
import { JwtResponse } from '../models/jwt-response';
import {tap} from 'rxjs/operators';
import {Observable, BehaviorSubject} from 'rxjs';

@Injectable()
export class AuthService {
  //AUTH_sERVER: string = 'http://localhost:3000
  //authSubject = new BehaviorSubject(false)
  //private token: string;
  constructor(private httpClient: HttpClient) { }


 /* register(user: JwtUser): Observable<JwtResponse>{
    return this.httpClient.post<JwtResponse>(`${this.AUTH_SERVER}/register`, user)
    .pipe(tap(
      (res: JwtResponse) => {
        if(res){
          this.saveToken(res.datauser.accessToken, res.datauser.expiresIn)
        }
      })
    )
  }
  */
/*
 login(user: JwtUser): Observable<JwtResponse>{
  return this.httpClient.post<JwtResponse>(`${this.AUTH_SERVER}/login`, user)
  .pipe(tap(
    (res: JwtResponse) => {
      if(res){
this.saveToken(res.datauser.accessToken, res.datauser.expiresIn)
      }
    })
  )
}
*/
 /* logout(){
    this.token = '';
    localStorage.removeItem("ACESS_TOKEN");
    localStorage.removeItem("EXPIRES_IN");
  }
  */

 /* private saveToken(token: string, expiresIn : string):void{
    localStorage.setItem("ACCESS_TOKEN", token);
    localStorage.setItem("EXPIRES_IN", expiresIn);
    this.token = token;
  }
  */

 /* private getToken():string{
    if(!this.getToken){
      this.token = localStorage.getItem("ACCESS_TOKEN");
    }
  }
  */
}
