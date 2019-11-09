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

@Transactional
public class CitaServiceImpl implements CitaService {

  private static final Log log = LogFactory.getLog(CitaServiceImpl.class);
  private CitasRepository citaRepository;

  @Autowired
  public CitaServiceImpl(CitasRepository citaRepository) {
    this.citaRepository = citaRepository;
  }

  public List<Cita> findAll() {
    Optional<List<Cita>> cita = citaRepository.findAll();
    return cita.get();
  }

  public Cita findByCitaId(String citaId) {
    Optional<Cita> cita = citaRepository.findOne(citaId);
    if (cita.isPresent()) {
      log.debug(String.format("Read citaId '{}'", citaId));
      return cita.get();
    } else
      throw new CitaNotFoundException(citaId);
  }

  public void saveCita(Cita cita) {
    citaRepository.saveCita(cita);
  }

  public void updateCita(Cita cita) {
    citaRepository.updateCita(cita);
  }

  public void deleteCita(String citaId) {
    citaRepository.deleteCita(citaId);
  }

  public Cita findCitaByPacienteMedicoFechaHora(String idPaciente, String idMedico, String fecha, String hora) {
    System.out.println("[SERVER] Id paciente recibido: " + idPaciente);
    System.out.println("[SERVER] Id medico recibido: " + idMedico);
    System.out.println("[SERVER] Fecha recibida: " + fecha);
    System.out.println("[SERVER] Hora recibida: " + hora);
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
