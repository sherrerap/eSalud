Feature: Listar cita médicos

	Scenario: Al médico se le mostrará su lista de citas
  Scenario Outline: <testCase> <expectedResult>

		Given un usuario que se loguea como médico
		| medico		|	contraseña		|
		| <medico>	| <contraseña>	|
		
		When el medico pulsa en lista de citas
		
		
		Then se muestra la lista de citas del medico '<expectedResult>'
		
		Examples:
		| testCase  									        | expectedResult | medico    | contraseña |
		|	Dni y contraseña no introducido 		| FAILS					 |         	 |       			|
		|	Dni no introducido				          | FAILS					 |         	 | 123456			|
		|	Contraseña no introducida 	        | FAILS					 | 77538212	 |  					|
		|	Contraseña incorrecta 			        | FAILS					 | 77538212	 | 2134uhg42	|
		| Medico incorrecto     		          | FAILS					 | 00070000	 | 753954			|
		| Resto de casos							        | IS SUCCESFUL	 | 77538212	 | 123456			|