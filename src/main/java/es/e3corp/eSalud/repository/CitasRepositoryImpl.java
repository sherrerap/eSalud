package es.e3corp.eSalud.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import es.e3corp.eSalud.model.Cita;
import es.e3corp.eSalud.model.Especialidad;
import es.e3corp.eSalud.model.Usuario;
import es.e3corp.eSalud.utilidades.Utilidades;

/**
 * Clase que se encarga de implementar los métodos de la interfaz
 * CitasRepository.
 * 
 * @author e3corp
 */
@Repository
public class CitasRepositoryImpl implements CitasRepository {
  /**
   * Invocación de la interfaz MongoOperations.
   * 
   * @author e3corp
   */
  private final MongoOperations mongoOperations;

  /**
   * Constructor de CitasRepositoryImpl.
   * 
   * @author e3corp
   */
  @Autowired
  public CitasRepositoryImpl(final MongoOperations mongoOperations) {
    Assert.notNull(mongoOperations, "notNull");
    this.mongoOperations = mongoOperations;
  }

  /**
   * Método que devuelve todas las citas.
   * 
   * @author e3corp
   */
  @Override
  public Optional<List<Cita>> findAll() {
    final List<Cita> citas = this.mongoOperations.find(new Query(), Cita.class);
    final Optional<List<Cita>> optionalCitas = Optional.ofNullable(citas);
    return optionalCitas;
  }

  /**
   * Método que guarda las citas en la base de datos.
   * 
   * @author e3corp
   */
  @Override
  public void saveCita(final Cita cita) {
    this.mongoOperations.save(cita);
  }

  /**
   * Método que actualiza las citas.
   * 
   * @author e3corp
   */
  @Override
  public void updateCita(final Cita cita) {
    this.mongoOperations.save(cita);
  }

  /**
   * Método para borrar una cita de la base de datos.
   * 
   * @author e3corp
   */
  @Override
  public void deleteCita(final String citaId) {
    System.out.println("ID DE LA CITA QUE LLEGA");
    this.mongoOperations.findAndRemove(new Query(Criteria.where("_id").is(citaId)), Cita.class);
  }

  /**
   * Método que devuelve un cita mediante su id.
   * 
   * @author e3corp
   */
  @Override
  public Optional<Cita> findOne(final String id) {
    final Cita c = this.mongoOperations.findOne(new Query(Criteria.where("id").is(id)), Cita.class);
    final Optional<Cita> cita = Optional.ofNullable(c);
    final Optional<Cita> citaDesencriptada = Utilidades.desencriptarOptionalCita(cita);
    return citaDesencriptada;
  }

  /**
   * Método que devuelve citas en función del paciente, medico, fecha y hora.
   * 
   * @author e3corp
   */
  @Override
  public Cita findByPacienteMedicoFechaHora(final String idPaciente, final String idMedico, final String fecha,
      final String hora) {

    final Cita cita = this.mongoOperations.findOne(new Query(Criteria.where("paciente").is(idPaciente).and("medico")
        .is(idMedico).and("fecha").is(fecha).and("hora").is(hora)), Cita.class);

    
    return cita;
  }

  @Override
  public List<Cita> findPaciente(final String dni) {
    final List<Cita> citas = this.mongoOperations
        .find(new Query(Criteria.where("paciente").is(Utilidades.encriptar(dni))), Cita.class);
    System.out.println("CITAS ENCONTRADAS: " + citas);
    final List<Cita> citasDesenc = Utilidades.desencriptarListaCitas(citas);
    System.out.println("CITAS ENCRIIPTADA: " + citasDesenc);
    return citasDesenc;
  }

  @Override
  public List<Cita> findMedico(final String id) throws ParseException {
    final String medicoEncriptado = Utilidades.encriptar(id);
    final List<Cita> citas = this.mongoOperations.find(new Query(Criteria.where("medico").is(medicoEncriptado)),
        Cita.class);
    System.out.println("TAMAÑO DE CITAS ENCONTRADAS " + citas.size());
    System.out.println("PACIENTE CON LA CITA ENCONTRADA " + citas.get(citas.size() - 1).getPaciente());

    final List<Cita> citasDesenc = Utilidades.desencriptarListaCitas(citas);
    final List<Cita> citasPaciente = new ArrayList<>();
    for (final Cita cita : citasDesenc) {
      final Usuario u = this.mongoOperations
          .findOne(new Query(Criteria.where("dni").is(Utilidades.encriptar(cita.getPaciente()))), Usuario.class);
      final Usuario usuarioDesenc = Utilidades.desencriptarUsuario(u);
      cita.setPaciente(usuarioDesenc.getNombre() + " " + usuarioDesenc.getApellidos());
      final Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(cita.getFecha());

      if (fecha.after(new java.util.Date()) || fecha.equals(new java.util.Date())) {
        citasPaciente.add(cita);
      }
    }

    return citasPaciente;
  }

  @Override
  public List<Cita> getCitasDisponibles(final String idmedico,final String dia) {
    final String idmedicoEncrip = Utilidades.encriptar(idmedico);
    final String diaEncriptado = Utilidades.encriptar(dia);

    final Usuario usuario = this.mongoOperations.findOne(new Query(Criteria.where("dni").is(idmedicoEncrip)),
        Usuario.class);
    final Especialidad especialidad = this.mongoOperations
        .findOne(new Query(Criteria.where("especialidad").is(usuario.getEspecialidad())), Especialidad.class);
    final List<Cita> citas = this.mongoOperations
        .find(new Query(Criteria.where("fecha").is(diaEncriptado).and("medico").is(idmedicoEncrip)), Cita.class);
    final Especialidad especialidadDesenc = Utilidades.desencriptarEspecialidad(especialidad);
    final List<Cita> citasDisponibles = new ArrayList<>();
    final List<Cita> citasTotalesDia = new ArrayList<>();

    final LocalTime tiempoConsult = LocalTime.parse(especialidadDesenc.getTiempoConsulta());
    final long tiempoConsultaMinutes = tiempoConsult.getMinute();
    LocalTime horaInicio = LocalTime.parse(especialidadDesenc.getHoraInicio());
    final LocalTime horaFin = LocalTime.parse(especialidadDesenc.getHoraFin());
    while (horaInicio.isBefore(horaFin.minusMinutes(tiempoConsultaMinutes))) {
      citasTotalesDia.add(new Cita("", "", "", "", "", "", horaInicio.toString()));
      horaInicio = horaInicio.plusMinutes(tiempoConsultaMinutes);
    }
    if (citas.isEmpty()) {
      citasDisponibles.addAll(citasTotalesDia);
    } else {
      for (final Cita citaPosible : citasTotalesDia) {
        for (final Cita citaRealizada : citas) {
          if (!(citaRealizada.getHora().equals(citaPosible.getHora()))) {
            citasDisponibles.add(citaPosible);
          }
        }
      }
    }
    final List<Cita> citasFinales = new ArrayList<>();
    citasFinales.addAll(citasDisponibles);
    System.out.println(Utilidades.desencriptarListaCitas(citasFinales));

    return citasFinales;
  }

}
