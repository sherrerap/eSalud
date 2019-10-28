import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { map } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class UserService {
	currentUserSubject: any;
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<any[]>(`${environment.apiUrl}/usuarios`);
    }

    register(user) {
        return this.http.post(`${environment.apiUrl}/usuarios`, user);
    }

    registerMedico(dni,nombre,apellidos,centro,telefono,correo,contraseña)  
     {
		
        return this.http.post('http://localhost:8080/usuarios', { 
			dni : dni,
			nombre : nombre,
			apellidos : apellidos,
			centro : centro,
			telefono : telefono,
			correo : correo,
			password: contraseña} )
            .pipe(map(user => {
                localStorage.setItem('currentUser', JSON.stringify(user));
                this.currentUserSubject.next(user);
                return user;
            }));
    }

    delete(id) {
        return this.http.delete(`${environment.apiUrl}/usuarios/${id}`);
    }
}