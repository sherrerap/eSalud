Feature: Modificar cita paciente 

  Scenario: Modificacion de cita para eSalud
  Scenario Outline: <testCase> <expectedResult>
  
     Given el usuario se ha logueado y quiere cambiar los valores de los campos de la cita para actualizarlos
      
        | paciente	   | tipo		    | fecha          | hora        | centro        | médico     |
        | <paciente>	  | <tipo>		| <fecha>		     | <hora>       | <centro>		 | <médico>	  |

    When el usuario paciente modifica los datos de una cita 
    
    		| paciente      | tipo		  | fecha          | hora         | centro       | médico      |
    		| <paciente>	  | <tipo>		| <fecha>		     | <hora>       | <centro>		 | <médico>	   |
    		
    Then se modifica la cita y se sustituye en la base de datos '<expectedResult>'
    

      Examples:
		| testCase                      | expectedResult | paciente			| contraseña			|	tipo			    |	fecha			    |	hora	   |	centro						           | médico		|
    | No tipo presente              | FAILS          | 1234567      | 123							|               | 1/12/2019     | 12:50    | Hospital General Ciudad Real  | 1         |
    | No fecha presente             | FAILS          | 1234567      | 123             | Cabecera      |               | 12:50    | Hospital General Ciudad Real  | 1         |
    | No hora presente              | FAILS          | 1234567      | 123             | Cabecera      | 1/12/2019     |          | Hospital General Ciudad Real  | 1         |
    | No centro presente            | FAILS          | 1234567      | 123             | Cabecera      | 1/12/2019     | 12:50    |                               | 1         |
    | No medico presente            | FAILS          | 1234567      | 123             | Cabecera      | 1/12/2019     | 12:50    | Hospital General Ciudad Real  |           |
    | Fecha incorrecta              | FAILS          | 1234567      | 123             | Cabecera      | 32/12/2019    | 12:50    | Hospital General Ciudad Real  | 1         |
    | Hora incorrecta               | FAILS          | 1234567      | 123             | Cabecera      | 1/12/2019     | 25:50    | Hospital General Ciudad Real  | 1         |
    | Paciente inexistente          | FAILS          | 1234567OT    | 123             | Cabecera      | 1/12/2019     | 12:50    | Hospital General Ciudad Real  | 1         |
    | En el resto de casos          | IS SUCCESFUL   | 1234567      | 123             | Cabecera      | 1/12/2019     | 12:50    | Hospital General Ciudad Real  | 1         |
    