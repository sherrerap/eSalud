import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from '../../environments/environment';


@Injectable({ providedIn: 'root' })
export class AuthService {
    private currentUserSubject: BehaviorSubject<any>;
    public currentUser: Observable<any>;

    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<any>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue() {
        return this.currentUserSubject.value;
    }

    login(dni, password) {
        return this.http.post<any>(`${environment.apiUrl}/auth/login`, { dni, password })
            .pipe(map(user => {
                // almacena detalles del usuario y el token jwt en el almacenamiento local para mantener al usuario logueado entre refrescos de página
                localStorage.setItem('currentUser', JSON.stringify(user));
                this.currentUserSubject.next(user);
                return user;
            }));
    }

    logout() {
        // elimina al usuario del almacenamiento local y marca el usuario actual como nulo
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }
}