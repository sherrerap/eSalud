package es.e3corp.eSalud.Service;

import java.util.List;

import es.e3corp.eSalud.model.Cita;

public interface CitaService {

  List<Cita> findAll();

  Cita findByCitaId(String id);

  void saveCita(Cita cita);

  void updateCita(Cita cita);

  void deleteCita(String citaId);

  Cita findCitaByPacienteMedicoFechaHora(String idPaciente, String idMedico, String fecha, String hora);

  List<Cita> getCitasByPaciente(String dni);

  List<Cita> getCitasByMedico(String id);
}
