Feature: Como usuario podré acceder al sistema

Scenario Outline: <testCase> <resultadoEsperado>
  Given abrimos el navegador e iniciamos la aplicacion
  When introducimos los datos de acceso a la aplicación
  	|	dni	| contraseña  | 
    |<dni>| <contraseña>|
			
  Then accedemos a la aplicacion
  
  Examples: 
  	|testCase	| resultadoEsperado 	|	dni 	  				| contraseña |
    |CASO 1		|	LOGIN CORRECTO		| admin						|  root  		 |
    |CASO 2		|	LOGIN CORRECTO		| pruebasPaciente	|  123  		 |
    |CASO 3		|	LOGIN CORRECTO		| pruebasMedico		|  123  		 |
    |CASO 4		|	DNI INCORRECTO		  | pruebasPacienteE|  123       |
    |CASO 5		|	SIN DNI			 			  | 								|  123       |
    |CASO 6		|	SIN CONTRASEÑA		  | pruebasPaciente	|   				 |
    