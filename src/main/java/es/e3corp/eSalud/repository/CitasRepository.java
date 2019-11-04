package es.e3corp.eSalud.repository;

import es.e3corp.eSalud.model.Cita;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface CitasRepository {
    Optional<List<Cita>> findAll();

    public void saveCita(Cita cita);

    public void updateCita(Cita cita);

    public void deleteCita(String citaId);

    Optional<Cita> findOne(String citaId);

    Cita findByPacienteMedicoFechaHora(String idPaciente, String idMedico, String fecha, String hora);

}