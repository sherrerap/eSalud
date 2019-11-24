Feature: Modificar tiempo de consulta
	
	Scenario: El gestor podrá modificar el tiempo de consulta en función de la especialidad
  Scenario Outline: <testCase> <expectedResult>

		Given un usuario logueado como gestor
		| gestor		|	contraseña		|
		| <gestor>	| <contraseña>	|
  		
		When el usuario seleccione una especialidad
		| especialidad 		| tiempoConsulta	 | horaInicio   | horaFin 	|
		| <especialidad>  | <tiempoConsulta> | <horaInicio> | <horaFin> |
		
		Then se mostrarán sus características y se podrá editar su tiempo de consulta '<expectedResult>'
		
		Examples:
		| testCase                      		| expectedResult | gestor 			| contraseña | especialidad | tiempoConsulta	| horaInicio | horaFin	|
    | SIN DNI INTRODUCIDO	O INVÁLIDO  	| FAILS          | 							|	root			 | enfermería		|	00:10						|	09:00			 | 14:30		|				
    | SIN PASS INTRODUCIDA	O INVÁLIDO  | FAILS          | admin				|						 | enfermería		|	00:10						| 09:00			 | 14:30		|	
    | SIN TIEMPO INTRODUCIDO						| FAILS          | admin				|	root			 | enfermería		| 								| 09:00			 | 14:30		|	
    | SIN HORA INICIO INTRODUCIDA				| FAILS          | admin				|	root			 | enfermería		| 00:10						|     			 | 14:30		|	
    | SIN HORA FIN INTRODUCIDA					| FAILS          | admin				|	root			 | enfermería		| 00:10						| 09:00			 | 					|	
    | SIN ESPECIALIDAD SELECCIONADA			| FAILS          | admin				|	root			 | 							| 00:10						| 09:00			 | 14:30		|	
    | EN OTRO CASO							 				| IS SUCCESFUL   | admin 				|	root 			 | enfermería		|	00:10						| 09:00			 | 14:30		|	