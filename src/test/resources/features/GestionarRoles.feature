Feature: Registrar personal medico con rol


 Scenario Outline: <testCase> <resultadoEsperado>
  Given iniciamos la aplicación y nos dirigimos a registrar personal medico
  
  When introducimos los datos de registro del personal medico 
  	|	dni	| nombre  | apellidos   | contraseña  | contraseña2  | rol    | numTelefono  | email   | centro   | localidad  |  
    |<dni>| <nombre>| <apellidos> | <contraseña>| <contraseña2>| <rol>  | <numTelefono>| <email> | <centro> |	<localidad>| 
			
  Then registramos un tipo de personal medico en la aplicacion
  
  Examples: 
  	|testCase	| resultadoEsperado 			 			 |	 dni	    | nombre	| apellidos  | contraseña | contraseña2  | rol         |  numTelefono    | email                 | centro	      |  especialidad | localidad    |          
    |CASO 1		|	REGISTRO MEDICO CORRECTO 			 | 111111111	| Dr      | medico     | passw1288  | passw1288    |  medico     |  645612514      | usuariopM@ejemplo.com |	Ciudad real	| traumatologia | Ciudad Real  |
    |CASO 2		|	FALLO, CONTRASEÑAS DISTINTAS	 | 111111111	| Dr      | medico     | passw1288  | passw   		 |             |  645612514      | usuariopM@ejemplo.com |	Ciudad real	| traumatologia | Ciudad Real  |
    |CASO 3		|	FALLO, SIN DNI					 			 | 						| Dr      | medico     | passw1288  | passw1288    |             |  645612514      | usuariopM@ejemplo.com |	Ciudad real	| traumatologia | Ciudad Real  |
    |CASO 4		|	FALLO, SIN NOMBRE Y APELLIDOS  | 111111111	|       	|   				 | passw1288  | passw1288    |             |  645612514  		 | usuariopM@ejemplo.com |	Ciudad real	| traumatologia | Ciudad Real  |
    |CASO 5		|	REGISTRO ENFERMERO CORRECTO    | 222222222	| Juan   	| Lopez 		 | 123456     | 123456       | enfermero   |  645612514  		 | usuariopM@ejemplo.com |	Ciudad real	| enfermeria    | Ciudad Real  |
    |CASO 6		|	REGISTRO INCORRECTO            | 222222222	| Juan   	| Lopez 		 | 123456     | 123456       | bombero     |  628617518  		 | usuariopM@ejemplo.com |	Ciudad real	|               | Ciudad Real  |
    |CASO 7		|	REGISTRO CELADOR CORRECTO      | 222222222	| Ana   	| Lopez 		 | 123456     | 123456       | celador     |  628117911  		 | usuariopM@ejemplo.com |	Ciudad real	| celador       | Ciudad Real  |
    |CASO 8		|	REGISTRO CELADOR INCORRECTO    | 222222222	| Maria  	| Sanchez 	 | 123456     | 123456       | celador     |  628117911  		 | usuariopM@ejemplo.com |	          	|               | Ciudad Real  |
    |CASO 9 	|	REGISTRO SIN ROL               | 222222222	| Maria  	| Sanchez 	 | 123456     | 123456       |             |  628117911  		 | usuariopM@ejemplo.com |	          	|               | Ciudad Real  |