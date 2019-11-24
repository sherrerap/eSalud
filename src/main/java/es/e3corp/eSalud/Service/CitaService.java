package es.e3corp.eSalud.Service;

import es.e3corp.eSalud.model.Cita;

import java.text.ParseException;
import java.util.List;


/**
 * Declaracion de la interfaz.
 * 
 * @author e3corp
 */

public interface CitaService {
  /**
   * Método para obtener toda la lista de citas.
   * 
   * @author e3corp
   */
  List<Cita> findAll();

  /**
   * Método para encontrar cita por id.
   * 
   * @author e3corp
   */

  Cita findByCitaId(String id);

  /**
   * Método para guardar citas en la base de datos.
   * 
   * @author e3corp
   */

  void saveCita(Cita cita);

  /**
   * Método para actualizar cita.
   * 
   * @author e3corp
   */

  void updateCita(Cita cita);

  /**
   * Método para eliminar cita.
   * 
   * @author e3corp
   */

  void deleteCita(String citaId);

  /**
   * Método para buscar cita por id de paciente, fecha y hora.
   * 
   * @author e3corp
   */

  Cita findCitaByPacienteMedicoFechaHora(String idPaciente, String idMedico, String fecha, String hora);

  /**
   * Método para obtener las citas de un paciente en función de su id.
   * 
   * @author e3corp
   */

  List<Cita> getCitasByPaciente(String dni);

  /**
   * Método para obtener las citas de un médico en función de su id.
   * 
   * @author e3corp
 * @throws ParseException 
   */

  List<Cita> getCitasByMedico(String id) throws ParseException;
}
