import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class CitasService {
    currentCitasSubject: any;
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<any[]>(`${environment.apiUrl}/citas`);
    }

    getCitasPaciente(dni){
        return this.http.get<any[]>(`${environment.apiUrl}/citas/paciente/${dni}`);
    }

    getCitasMedico(dni){
        return this.http.get<any[]>(`${environment.apiUrl}/citas/medico/${dni}`);
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