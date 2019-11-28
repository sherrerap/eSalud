package es.e3corp.eSalud.Service;

import es.e3corp.eSalud.model.Especialidad;
import java.util.List;



/**
 * Clase EspecialidadService.
 * @author e3corp
 */
public interface EspecialidadService {
  /**
   * Método findAll.
   * @author e3corp
   */
  List<Especialidad> findAll();

  /**
   * Método para encontrar especialidad por el nombre.
   * @author e3corp
   */
  Especialidad findByName(String name);

  /**
   * Método para guardar especialidad.
   * @author e3corp
   */
  void saveEspecialidad(Especialidad especialidad);

  /**
   * Método para actualizar especialidad.
   * @author e3corp
   */
  void updateEspecialidad(Especialidad especialidad);

  /**
   * Método para eliminar especialidad.
   * @author e3corp
   */
  void deleteEspecialidad(String nombre);

}
