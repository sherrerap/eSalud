Feature: Eliminar citas

	Scenario: Eliminacion de citas para eSalud
		Scenario Outline: <testCase> <expectedResult>
  
     Given el usuario de ha logueado y elegirá la cita que quiera eliminar
      
        | paciente	   |tipo		    | fecha          | hora        | centro  | médico     |


    When el usuario eliminará el usuario seleccionado
    
    		| DNI	  	        |Tipo		    | Fecha          | Hora         | Centro       | ID_Medico      |
    		| <dniPaciente>	  | <tipo>		| <fecha>		     | <hora>       | <centro>		 | <médico>	      |
    		
    Then se elimina la cita de la base de datos. '<expectedResult>'
    

      Examples:
		| testCase                      | expectedResult | paciente			|	tipo					|	fecha					|	hora			|	centro						            |	médico		|
    | No tipo presente              | FAILS          | 11111111     |               | 1/12/2019     | 12:50     | Hospital General Ciudad Real  | 1         |
    