Feature: Crear Medico

  Scenario Outline: <testCase> <expectedResult>
  
    Given el usuario medico se da de alta en sistema con los siguientes datos
      | Nombre	  	 | Apellidos      | Contraseña  | Rol        | numTelefono    | email               | localidad             | especialidad             |
      | <Nombre>	   | <Apellidos>    | <Contraseña>| <Rol>      | <numTelefono>  | <email>             | <localidad>           | <especialidad>           |
      
    When el usuario medico se guarda con sus datos '<testCase>'
    Then se guarda el medico en la aplicación '<expectedResult>'

    Examples:
      | testCase                      | expectedResult | Nombre	  	  | Apellidos      | Contraseña  | Rol        | numTelefono    | email                 | localidad               | especialidad             |
      | SIN NOMBRE INTRODUCIDO        | FAILS          |              | Peco Gomez     | passw1288   | medico     | 645612514      | usuariopM@ejemplo.com |	Ciudad real						 | cabecera                 |
      | SIN APELLIDOS INTRODUCIDOS    | FAILS          | Miguel       |                | passw1288   | medico     | 645612514      | usuariopM@ejemplo.com |	Ciudad real						 | cabecera                 |
      | SIN CONTRASEÑA INTRODUCIDA    | FAILS          | Miguel       | Peco Gomez     | passw1288   | medico     | 645612514      | usuariopM@ejemplo.com |	Ciudad real						 | cabecera                 |
      | SIN EMAIL INTRODUCIDO         | FAILS          | Miguel       | Peco Gomez     | passw1288   | medico     | 645612514      |                       |	Ciudad real						 | cabecera                 |
      | SIN LOCALIDAD INTRODUCIDA     | IS SUCCESSFUL  | Miguel       | Peco Gomez     | passw1288   | medico     | 645612514      | usuariopM@ejemplo.com |	                       | cabecera                 |
      | SIN ESPECIALIDAD INTRODUCIDA  | IS SUCCESSFUL  | Miguel       | Peco Gomez     | passw1288   | medico     | 645612514      | usuariopM@ejemplo.com |	Ciudad real						 |                          |