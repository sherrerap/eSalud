import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

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

    delete(id) {
        return this.http.delete(`${environment.apiUrl}/usuarios/${id}`);
    }
}