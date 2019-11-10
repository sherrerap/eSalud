package es.e3corp.eSalud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.e3corp.eSalud.model.Cita;
/**
* @author e3corp
*/
@Repository
public interface CitasRepository {
  /**
  * @author e3corp
  */  
  Optional<List<Cita>> findAll();
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
    Optional<Cita> findOne(String citaId);
    /**
    * @author e3corp
    */
    Cita findByPacienteMedicoFechaHora(String idPaciente, String idMedico, String fecha, String hora);
    /**
    * @author e3corp
    */
	List<Cita> findPaciente(String dni);
	/**
	* @author e3corp
	*/
	List<Cita> findMedico(String id);

}