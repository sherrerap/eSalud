package es.e3corp.eSalud.Service;

import java.util.List;

import es.e3corp.eSalud.model.Cita;
/**
* @author e3corp
*/
public interface CitaService {
  /**
  * @author e3corp
  */
  List<Cita> findAll();
  /**
  * @author e3corp
  */
  Cita findByCitaId(String id);
  /**
  * @author e3corp
  */
  void saveCita(Cita cita);
  /**
  * @author e3corp
  */
  void updateCita(Cita cita);
  /**
  * @author e3corp
  */
  void deleteCita(String citaId);
  /**
  * @author e3corp
  */
  Cita findCitaByPacienteMedicoFechaHora(String idPaciente, String idMedico, String fecha, String hora);
  /**
  * @author e3corp
  */
  List<Cita> getCitasByPaciente(String dni);
  /**
  * @author e3corp
  */
  List<Cita> getCitasByMedico(String id);
}
