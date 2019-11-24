package es.e3corp.eSalud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.e3corp.eSalud.model.Especialidad;

/**
 * Interfaz de EspecialidadRepository.
 * 
 * @author e3corp
 */
@Repository
public interface EspecialidadRepository {
  /**
   * Método que te devuelve todas las especialidades.
   * 
   * @author e3corp
   */
  List<Especialidad> findAll();

  /**
   * Método para guardar una especialidad.
   * 
   * @author e3corp
   */
  void saveEspecialidad(Especialidad especialidad);

  /**
   * Método para actualizar una especialidad.
   * 
   * @author e3corp
   */
  void updateEspecialidad(Especialidad especialidad);

  /**
   * Método para borrar una especialidad.
   * 
   * @author e3corp
   */
  void deleteEspecialidad(String especialidadId);

  /**
   * Método para obtener una especialidad por su id.
   * 
   * @author e3corp
   */
  Optional<Especialidad> findOne(String especialidadId);

}
