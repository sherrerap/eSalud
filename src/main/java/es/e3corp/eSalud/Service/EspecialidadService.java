package es.e3corp.eSalud.Service;

import java.util.List;

import es.e3corp.eSalud.model.Especialidad;

/**
 * @author e3corp
 */
public interface EspecialidadService {
  /**
   * @author e3corp
   */
  List<Especialidad> findAll();

  /**
   * @author e3corp
   */
  Especialidad findByName(String name);

  /**
   * @author e3corp
   */
  void saveEspecialidad(Especialidad especialidad);

  /**
   * @author e3corp
   */
  void updateEspecialidad(Especialidad especialidad);

  /**
   * @author e3corp
   */
  void deleteEspecialidad(String nombre);

}
