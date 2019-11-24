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

    getEspecialidad(dni){
        return this.http.get<any[]>(`${environment.apiUrl}/citas/paciente/${dni}`);
    }
    
    register(cita) {
        return this.http.post(`${environment.apiUrl}/citas`, cita);
    }

    update(cita,id) {
        return this.http.put(`${environment.apiUrl}/citas/${id}`, cita);
    }

    delete(idCita) {
        return this.http.delete(`${environment.apiUrl}/citas/${idCita}`);
    }
}