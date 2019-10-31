Feature: Crear usuario

	Scenario: Se podrá crear un usuario e introducirlo al sistema
	
		Given se registra un usuario con los siguientes campos
		When el usuario guarda sus datos con los campos requeridos
		Then el resultado de guardar el usuario es correcto