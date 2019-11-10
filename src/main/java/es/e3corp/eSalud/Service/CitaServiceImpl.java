package es.e3corp.eSalud.Service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.e3corp.eSalud.exception.CitaNotFoundException;
import es.e3corp.eSalud.model.Cita;
import es.e3corp.eSalud.repository.CitasRepository;
import es.e3corp.eSalud.utilidades.Utilidades;

@Service("CitaService")
/**
* @author e3corp
*/
@Transactional
public class CitaServiceImpl implements CitaService {
  /**
  * @author e3corp
  */
  private static final Log LOG = LogFactory.getLog(CitaServiceImpl.class);
  /**
  * @author e3corp
  */
  private CitasRepository citaRepository;
  /**
  * @author e3corp
  */
  @Autowired
  public CitaServiceImpl(CitasRepository citaRepository) {
    this.citaRepository = citaRepository;
  }
  /**
  * @author e3corp
  */
  public List<Cita> findAll() {
    Optional<List<Cita>> cita = citaRepository.findAll();
    return cita.get();
  }
  /**
  * @author e3corp
  */
  public Cita findByCitaId(String citaId) {
    Optional<Cita> cita = citaRepository.findOne(citaId);
    if (cita.isPresent()) {
      LOG.debug(String.format("Read citaId '{}'", citaId));
      return cita.get();
    } else
      throw new CitaNotFoundException(citaId);
  }
  /**
  * @author e3corp
  */
  public void saveCita(Cita cita) {
    citaRepository.saveCita(cita);
  }
  /**
  * @author e3corp
  */
  public void updateCita(Cita cita) {
    citaRepository.updateCita(cita);
  }
  /**
  * @author e3corp
  */
  public void deleteCita(String citaId) {
    citaRepository.deleteCita(citaId);
  }
  /**
  * @author e3corp
  */
  public Cita findCitaByPacienteMedicoFechaHora(String idPaciente, String idMedico, String fecha, String hora) {
    LOG.info("[SERVER] Id paciente recibido: " + idPaciente);
    LOG.info("[SERVER] Id medico recibido: " + idMedico);
    LOG.info("[SERVER] Fecha recibida: " + fecha);
    LOG.info("[SERVER] Hora recibida: " + hora);
    Cita cita = citaRepository.findByPacienteMedicoFechaHora(idPaciente, idMedico, fecha, hora);
    return cita;
  }

  @Override
  public List<Cita> getCitasByPaciente(String dni) {
	
    List<Cita> citas = citaRepository.findPaciente(dni);
    return citas;
  }

  @Override
  public List<Cita> getCitasByMedico(String id) {
	
    List<Cita> citas = citaRepository.findMedico(id);
    return citas;
  }

}
