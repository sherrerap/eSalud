package es.e3corp.eSalud.repository;

import es.e3corp.eSalud.model.Cita;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;



/**
 * Interfaz de CitasRepository.
 * @author e3corp
 */
@Repository
public interface CitasRepository {
  /**
   * Devolver todas las citas.
   * @author e3corp
   */
  Optional<List<Cita>> findAll();

  /**
   * Guardar cita.
   * @author e3corp
   */
  void saveCita(Cita cita);

  /**
   * Actualizar cita.
   * @author e3corp
   */
  void updateCita(Cita cita);

  /**
   * Borrar cita.
   * @author e3corp
   */
  void deleteCita(String citaId);

  /**
   * Obtener una cita en funcion de su id.
   * @author e3corp
   */
  Optional<Cita> findOne(String citaId);

  /**
   * Obtener cita en función del paciente, medico, fecha y hora.
   * @author e3corp
   */
  Cita findByPacienteMedicoFechaHora(String idPaciente, String idMedico, String fecha, String hora);

  /**
   * Obtener un paciente en función de su dni.
   * @author e3corp
   */
  List<Cita> findPaciente(String dni);

  /**
   * Obtener un medico en función de su id.
   * @author e3corp
 * @throws ParseException 
   */
  List<Cita> findMedico(String id) throws ParseException;

}