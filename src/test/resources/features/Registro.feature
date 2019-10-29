Feature: Como usuario podré registrarme al sistema
Se podrá introducir datos de registro a la base de datos

	Scenario: Registro de usuarios
		Given tenemos un usuario vacio
		When llamo al recurso "\registro" con los "datos" de registro
		Then introducimos los "datos" a la base de datos
		And recibimos el codigo 200
		



