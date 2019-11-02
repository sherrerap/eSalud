Feature: Listar cita

	Scenario: Al paciente se le mostrará su lista de citas
  Scenario Outline: <testCase> <expectedResult>

		Given un usuario logueado como paciente
  		
		When el usuario pulsa en lista de citas
		| paciente			|
		| <dniPaciente>	|
		
		Then se muestra la lista de citas del paciente '<expectedResult>'
		
		Examples:
		| testCase  								| expectedResult | paciente  |
		|	SIN DNI INTRODUCIDO				| FAILS					 | 				 	 |
		| CON PACIENTE INEXISTENTE	| FAILS					 | 00000000	 |
		| EN OTRO CASO							| IS SUCCESFUL	 | 12345678	 |