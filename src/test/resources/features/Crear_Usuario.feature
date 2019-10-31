Feature: Crear usuario

	Scenario: Se podrá crear un usuario e introducirlo al sistema
	
		Given se registra un usuario con los siguientes campos
		|	dni	    | nombre	  	| apellidos      | contraseña  | rol        | numTelefono    | email                 | localidad   | especialidad | medico			| centro  		|
    |111111111| Miguel      | Peco Gomez     | passw1288   | medico     | 645612514      | usuariopM@ejemplo.com |	Ciudad real	| cabecera     |Juan Sanchez| Miguelturra |
			
		
		When el usuario guarda sus datos con los campos requeridos
		Then el resultado de guardar el usuario es correcto