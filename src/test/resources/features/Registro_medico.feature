Feature: Registrar medico


 Scenario Outline: <testCase> <resultadoEsperado>
  Given iniciamos la aplicación y nos dirigimos a registrar medico
  When introducimos los datos de registro del medico
  	|	dni	| nombre  | apellidos   | contraseña  | contraseña2  | numTelefono  | email  | localidad  |  
    |<dni>| <nombre>| <apellidos> | <contraseña>| <contraseña2>| <numTelefono>| <email>|	<localidad>| 
			
  Then registramos un medico en la aplicacion
  
  Examples: 
  	|testCase	| resultadoEsperado 			 			 |	 dni	    | nombre	| apellidos  | contraseña | contraseña2  | numTelefono    | email                 | centro	    |  especialidad |
    |CASO 1		|	REGISTRO CORRECTO				 			 | 111111111	| Dr      | medico     | passw1288  | passw1288    | 645612514      | usuariopM@ejemplo.com |	Ciudad real	| traumatologia |
    |CASO 2		|	FALLO, CONTRASEÑAS DISTINTAS	 | 111111111	| Dr      | medico     | passw1288  | passw   		 | 645612514      | usuariopM@ejemplo.com |	Ciudad real	| traumatologia |
    |CASO 3		|	FALLO, SIN DNI					 			 | 						| Dr      | medico     | passw1288  | passw1288    | 645612514      | usuariopM@ejemplo.com |	Ciudad real	| traumatologia |
    |CASO 4		|	FALLO, SIN NOMBRE Y APELLIDOS  | 111111111	|       	|   				 | passw1288  | passw1288    | 645612514  		| usuariopM@ejemplo.com |	Ciudad real	| traumatologia |