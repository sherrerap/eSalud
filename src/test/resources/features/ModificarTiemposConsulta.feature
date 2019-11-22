Feature: Modificar tiempo de consulta
	
	Scenario: El gestor podrá modificar el tiempo de consulta en función de la especialidad
  Scenario Outline: <testCase> <expectedResult>

		Given un usuario logueado como gestor
		| gestor		|	contraseña		|
		| <gestor>	| <contraseña>	|
  		
		When el usuario seleccione una especialidad
		| especialidad 		| tiempo	 |
		| <especialidad>  | <tiempo> |
		
		Then se mostrarán sus características y se podrá editar su tiempo de consulta '<expectedResult>'
		
		Examples:
		| testCase                      		| expectedResult | gestor 			| contraseña | especialidad | tiempo	|
    | SIN DNI INTRODUCIDO	O INVÁLIDO  	| FAILS          | 							|	root			 | enfermería		|	10m			|
    | SIN PASS INTRODUCIDA	O INVÁLIDO  | FAILS          | admin				|						 | enfermería		|	10m			|
    | SIN TIEMPO INTRODUCIDO						| FAILS          | admin				|	root			 | enfermería		| 				|
    | SIN ESPECIALIDAD SELECCIONADA			| FAILS          | admin				|	root			 | 							| 10m			|
    | EN OTRO CASO							 				| IS SUCCESFUL   | admin 				|	root 			 | enfermería		|	10m			|