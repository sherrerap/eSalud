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

@Repository
public class CitasRepositoryImpl implements CitasRepository {

  private final MongoOperations mongoOperations;

  @Autowired
  public CitasRepositoryImpl(MongoOperations mongoOperations) {
    Assert.notNull(mongoOperations, "notNull");
    this.mongoOperations = mongoOperations;
  }

  public Optional<List<Cita>> findAll() {
    List<Cita> citas = this.mongoOperations.find(new Query(), Cita.class);
    Optional<List<Cita>> optionalCitas = Optional.ofNullable(citas);
    return optionalCitas;
  }

  public void saveCita(Cita cita) {
    this.mongoOperations.save(cita);
  }

  public void updateCita(Cita cita) {
    this.mongoOperations.save(cita);
  }

  public void deleteCita(String citaId) {
    this.mongoOperations.findAndRemove(new Query(Criteria.where("id").is(citaId)), Cita.class);
  }

  public Optional<Cita> findOne(String id) {
    Cita c = this.mongoOperations.findOne(new Query(Criteria.where("id").is(id)), Cita.class);
    Optional<Cita> cita = Optional.ofNullable(c);
    Optional <Cita> citaDesencriptada = Utilidades.desencriptarOptionalCita(cita);
    return citaDesencriptada;
  }

  public Cita findByPacienteMedicoFechaHora(String idPaciente, String idMedico, String fecha, String hora) {
	  
	  
	    Cita cita = this.mongoOperations.findOne(new Query(Criteria.where("paciente").is(idPaciente).and("médico")
	        .is(idMedico).and("fecha").is(fecha).and("hora").is(hora)), Cita.class);
	    
	    Cita citaDesencriptada = Utilidades.desencriptarCita(cita);
	    return cita;
  }

	@Override
	public List<Cita> findPaciente(String dni) {
		String pacienteEncriptado=Utilidades.encriptar(dni);
		System.out.println("El dni encriptado es: "+pacienteEncriptado);
		List<Cita> citas = this.mongoOperations.find(new Query(Criteria.where("paciente").is(pacienteEncriptado)), Cita.class);
		
		List<Cita> citasDesencriptadas = Utilidades.desencriptarListaCitas(citas);
		return citasDesencriptadas;
	}

	@Override
	public List<Cita> findMedico(String id) {
		String medicoEncriptado=Utilidades.encriptar(id);
		List<Cita> citas = this.mongoOperations.find(new Query(Criteria.where("medico").is(medicoEncriptado)), Cita.class);
		
		List<Cita> citasDesencriptadas = Utilidades.desencriptarListaCitas(citas);
		return citasDesencriptadas;
	}

}
