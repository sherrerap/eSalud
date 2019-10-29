Feature: Actualizar usuario medico

  Scenario Outline: <testCase> <expectedResult>

    Given se quieren cambiar los valores de los campos del usuario para actualizarlos
      | Nombre	  	 | Apellidos      | Contraseña  | Rol        | numTelefono    | email               | localidad             |
      | <Nombre>	   | <Apellidos>    | <Contraseña>| <Rol>      | <numTelefono>  | <email>             | <localidad>           |

    
    When cuando se salves los cambios del usuario medico en sus datos '<testCase>'
    Then se realzia el cambio al usuario medico correctamente '<expectedResult>'

    Examples:
      | testCase                   | expectedResult | Nombre	  	 | Apellidos      | Contraseña  | Rol        | numTelefono    | email                | localidad              |
      | SIN NOMBRE INTRODUCIDO     | FAILS          |              | Perez Nieto    | passw1233   | paciente   | 645612545      | ejemplo2@ejemplo.com | Ciudad real						|
      | SIN APELLIDOS INTRODUCIDOS | FAILS          | Enrique      |                | passw1233   | paciente   | 645612545      | ejemplo2@ejemplo.com | Ciudad real						|
      | SIN CONTRASEÑA INTRODUCIDA | FAILS          | Enrique      | Perez Nieto    |             | paciente   | 645612545      | ejemplo2@ejemplo.com | Ciudad real						|
      | SIN EMAIL INTRODUCIDO      | FAILS          | Enrique      | Perez Nieto    | passw1233   | paciente   | 645612545      | 	                   | Ciudad real						|
      | SIN LOCALIDAD INTRODUCIDA  | IS SUCCESSFUL  | Enrique      | Perez Nieto    | passw1233   | paciente   | 645612545      | ejemplo2@ejemplo.com | Ciudad real						|

