Feature: Pedir cita

	Scenario: El paciente podrá pedir una cita
  Scenario Outline: <testCase> <expectedResult>

		Given un usuario logueado como paciente
		| paciente		|	contraseña		|
		| <paciente>	| <contraseña>	|
  		
		When el usuario rellena los campos de la cita
		| paciente		|	tipo			|	fecha			|	centro			|	médico		|
		| <paciente>	| <tipo>		| <fecha>		|	<centro>		| <médico>	|
		
		Then la cita se guarda en la base de datos y se asocia con el paciente '<expectedResult>'
		
		Examples:
		| testCase                      | expectedResult | paciente			| contraseña    |	tipo					|	fecha					|	hora			|	centro						|	médico		|
    | SIN DNI INTRODUCIDO		        | FAILS          | 							|	123456				|	Enfermería		|	11/11/2019		|	11:30			| Ciudad Real III		|	05986372 	|
    | SIN CONTRASEÑA INTRODUCIDA    | FAILS          | 77538212			|								|	Enfermería		|	11/11/2019		|	11:30			| Ciudad Real III		|	05986372 	|				
    | SIN TIPO INTRODUCIDO			    | FAILS          | 77538212			|	123456				|								|	11/11/2019		|	11:30			|	Ciudad Real III		|	05986372 	|
    | SIN FECHA INTRODUCIDA					| FAILS          | 77538212			|	123456				|	Enfermería		|								|	11:30			|	Ciudad Real III		|	05986372 	|
    | SIN HORA INTRODUCIDA					| FAILS					 | 77538212			|	123456				|	Enfermería		|	11/11/2019		|	 					|	Ciudad Real III		|	05986372 	|
    | SIN CENTRO INTRODUCIDO        | FAILS          | 77538212			|	123456				|	Enfermería		|	11/11/2019		|	11:30			|										|	05986372 	|
    | SIN MÉDICO INTRODUCIDO		    | FAILS				   | 77538212			|	123456				|	Enfermería		|	11/11/2019		| 11:30			| Ciudad Real III		|					 	|
    | CON FECHA ERRÓNEA						  | FAILS          | 77538212			|	123456				|	Enfermería		|	54/21/2019		|	11:30			|	Ciudad Real III		|	05986372 	|	
    | CON HORA ERRÓNEA						  | FAILS          | 77538212			|	123456				|	Enfermería		|	11/11/2019		|	27:30			|	Ciudad Real III		|	05986372 	|			
    | CON PACIENTE INEXISTENTE		  | FAILS          | 12345678			|	123456				|	Enfermería		|	11/11/2019		|	11:30			|	Ciudad Real III		|	05986372 	|
    | CON MÉDICO INEXISTENTE		 		| FAILS          | 77538212			|	123456				|	Enfermería		|	11/11/2019		|	11:30			|	Ciudad Real III		|	00000000 	|
    | EN OTRO CASO							 		| IS SUCCESFUL   | 77538212			|	123456				|	Enfermería		|	11/11/2019		|	11:30			|	Ciudad Real III		|	05986372 	|