Feature: Listar cita

	Scenario: Al paciente se le mostrará su lista de citas
  Scenario Outline: <testCase> <expectedResult>

		Given un usuario que se loguea como paciente
		| paciente		|	contraseña		|
		| <paciente>	| <contraseña>	|
		
		When el usuario pulsa en lista de citas
		
		Then se muestra la lista de citas del paciente '<expectedResult>'
		
		Examples:
		| testCase  									| expectedResult | paciente  | contraseña |
		|	SIN DNI INTRODUCIDO					| FAILS					 | 77538212	 | 123456			|
		|	SIN CONTRASEÑA INTRODUCIDA	| FAILS					 | 77538212	 |  					|
		|	CON CONTRASEÑA ERRÓNEA			| FAILS					 | 77538212	 | 2134uhg42	|
		| CON PACIENTE INEXISTENTE		| FAILS					 | 00000000	 | 753954			|
		| EN OTRO CASO								| IS SUCCESFUL	 | 77538212	 | 123456			|