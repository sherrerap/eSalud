package es.e3corp.eSalud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import es.e3corp.eSalud.model.Cita;
import es.e3corp.eSalud.utilidades.Utilidades;
/**
* @author e3corp
*/
@Repository
public class CitasRepositoryImpl implements CitasRepository {
  /**
  * @author e3corp
  */
  private final MongoOperations mongoOperations;
  /**
  * @author e3corp
  */
  @Autowired
  public CitasRepositoryImpl(MongoOperations mongoOperations) {
    Assert.notNull(mongoOperations, "notNull");
    this.mongoOperations = mongoOperations;
  }
  /**
  * @author e3corp
  */
  public Optional<List<Cita>> findAll() {
    final List<Cita> citas = this.mongoOperations.find(new Query(), Cita.class);
    final Optional<List<Cita>> optionalCitas = Optional.ofNullable(citas);
    return optionalCitas;
  }
  /**
  * @author e3corp
  */
  public void saveCita(Cita cita) {
    this.mongoOperations.save(cita);
  }
  /**
  * @author e3corp
  */
  public void updateCita(Cita cita) {
    this.mongoOperations.save(cita);
  }
  /**
  * @author e3corp
  */
  public void deleteCita(String citaId) {
    this.mongoOperations.findAndRemove(new Query(Criteria.where("id").is(citaId)), Cita.class);
  }
  /**
  * @author e3corp
  */
  public Optional<Cita> findOne(String id) {
    final Cita c = this.mongoOperations.findOne(new Query(Criteria.where("id").is(id)), Cita.class);
    final Optional<Cita> cita = Optional.ofNullable(c);
    final Optional <Cita> citaDesencriptada = Utilidades.desencriptarOptionalCita(cita);
    return citaDesencriptada;
  }
  /**
  * @author e3corp
  */
  public Cita findByPacienteMedicoFechaHora(final String idPaciente,final String idMedico,final String fecha,final String hora) {
	  
	  
	    final Cita cita = this.mongoOperations.findOne(new Query(Criteria.where("paciente").is(idPaciente).and("médico")
	        .is(idMedico).and("fecha").is(fecha).and("hora").is(hora)), Cita.class);
	    
	    final Cita citaDesencriptada = Utilidades.desencriptarCita(cita);
	    return cita;
  }

	@Override
	public List<Cita> findPaciente(final String dni) {
		final String pacienteEncriptado=Utilidades.encriptar(dni);
		System.out.println("El dni encriptado es: "+pacienteEncriptado);
		final List<Cita> citas = this.mongoOperations.find(new Query(Criteria.where("paciente").is(pacienteEncriptado)), Cita.class);
		
		final List<Cita> citasDesencriptadas = Utilidades.desencriptarListaCitas(citas);
		return citasDesencriptadas;
	}

	@Override
	public List<Cita> findMedico(final String id) {
		final String medicoEncriptado=Utilidades.encriptar(id);
		final List<Cita> citas = this.mongoOperations.find(new Query(Criteria.where("médico").is(medicoEncriptado)), Cita.class);
		
		final List<Cita> citasDesencriptadas = Utilidades.desencriptarListaCitas(citas);
		return citasDesencriptadas;
	}

}
