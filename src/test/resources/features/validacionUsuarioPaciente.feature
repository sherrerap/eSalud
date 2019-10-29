Feature: Crear Paciente

  Scenario Outline: <testCase> <expectedResult>
  
    Given el usuario paciente quiere darse de alta en sistema con los siguientes datos
      | Nombre	  	 | Apellidos      | Contraseña  | Rol        | numTelefono    | email               | localidad             |
      | <Nombre>	   | <Apellidos>    | <Contraseña>| <Rol>      | <numTelefono>  | <email>             | <localidad>           |
      
    When el usuario paciente guarda sus datos '<testCase>'
    Then se guarda en la aplicación '<expectedResult>'

    Examples:
      | testCase                   | expectedResult | Nombre	  	 | Apellidos      | Contraseña  | Rol        | numTelefono    | email                | localidad              |
      | SIN NOMBRE INTRODUCIDO     | FAILS          |              | Perez Nieto    | passw1233   | paciente   | 645612545      | ejemplo2@ejemplo.com | Ciudad real						|
      | SIN APELLIDOS INTRODUCIDOS | FAILS          | Enrique      |                | passw1233   | paciente   | 645612545      | ejemplo2@ejemplo.com | Ciudad real						|
      | SIN CONTRASEÑA INTRODUCIDA | FAILS          | Enrique      | Perez Nieto    |             | paciente   | 645612545      | ejemplo2@ejemplo.com | Ciudad real						|
      | SIN EMAIL INTRODUCIDO      | FAILS          | Enrique      | Perez Nieto    | passw1233   | paciente   | 645612545      | 	                   | Ciudad real						|
      | SIN LOCALIDAD INTRODUCIDA  | IS SUCCESSFUL  | Enrique      | Perez Nieto    | passw1233   | paciente   | 645612545      | ejemplo2@ejemplo.com | Ciudad real						|