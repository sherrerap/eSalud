package es.e3corp.eSalud.Service;

import es.e3corp.eSalud.model.Cita;


import java.util.List;

public interface CitaService {

	
	  List<Cita> findAll();


	  Cita findByCitaId(String id);


	  void saveCita(Cita cita);


	  void updateCita(Cita cita);


	  void deleteCita(String citaId);
	  
	  Cita getCitaByPacienteMedicoFechaHora(String idPaciente, String idMedico, String fecha, String hora);
}
