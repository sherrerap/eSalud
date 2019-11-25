import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class EspecialidadesService {
    currentCitasSubject: any;
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<any[]>(`${environment.apiUrl}/especialidades/all`);
    }

    getEspecialidad(nombre){
        return this.http.get<any[]>(`${environment.apiUrl}/especialidades/paciente/${nombre}`);
    }
    
    register(especialidad) {
        return this.http.post(`${environment.apiUrl}/especialidades`, especialidad);
    }

    update(cita,id) {
        return this.http.put(`${environment.apiUrl}/especialidades/${id}`, cita);
    }

    delete(idCita) {
        return this.http.delete(`${environment.apiUrl}/especialidades/${idCita}`);
    }
}