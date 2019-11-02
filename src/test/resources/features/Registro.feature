Feature: Como usuario podré registrarme al sistema


 Scenario Outline: <testCase> <resultadoEsperado>
  Given abrimos el navegador e iniciamos la pantalla de registro
  When introducimos los datos de registro
  	|	dni	| nombre  | apellidos   | contraseña  | contraseña2  | numTelefono  | email  | localidad  |  
    |<dni>| <nombre>| <apellidos> | <contraseña>| <contraseña2>| <numTelefono>| <email>|	<localidad>| 
			
  Then nos registramos en la aplicacion
  
  Examples: 
  	|testCase	| resultadoEsperado 			 			 |	 dni	    | nombre	  	| apellidos      | contraseña | contraseña2  | numTelefono    | email                 | localidad   |  
    |CASO 1		|	REGISTRO CORRECTO				 			 | 111111111	| Miguel      | Peco Gomez     | passw1288  | passw1288    | 645612514      | usuariopM@ejemplo.com |	Ciudad real	|
    |CASO 2		|	FALLO, CONTRASEÑAS DISTINTAS	 | 111111111	| Miguel      | Peco Gomez     | passw1288  | passw   		 | 645612514      | usuariopM@ejemplo.com |	Ciudad real	| 
    |CASO 3		|	FALLO, SIN DNI					 			 | 						| Miguel      | Peco Gomez     | passw1288  | passw1288    | 645612514      | usuariopM@ejemplo.com |	Ciudad real	| 
    |CASO 4		|	FALLO, SIN NOMBRE Y APELLIDOS  | 111111111	|       			|   				     | passw1288  | passw1288    | 645612514  		| usuariopM@ejemplo.com |	Ciudad real	| 