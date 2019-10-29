Feature: Actualizar usuario paciente

  Scenario Outline: <testCase> <expectedResult>

    Given se quieren cambiar los valores de los campos del usuario para actualizarlos
      | Nombre	  	 | Apellidos      | Contraseña  | Rol        | numTelefono    | email               | localidad             | especialidad             |
      | <Nombre>	   | <Apellidos>    | <Contraseña>| <Rol>      | <numTelefono>  | <email>             | <localidad>           | <especialidad>           |

    
    When cuando se salves los cambios del usuario paciente en sus datos '<testCase>'
    Then se realiza el cambio correctamente '<expectedResult>'

    Examples:
      | testCase                      | expectedResult | Nombre	  	  | Apellidos      | Contraseña  | Rol        | numTelefono    | email                 | localidad               | especialidad             |
      | SIN NOMBRE INTRODUCIDO        | FAILS          |              | Peco Gomez     | passw1288   | medico     | 645612514      | usuariopM@ejemplo.com |	Ciudad real						 | cabecera                 |
      | SIN APELLIDOS INTRODUCIDOS    | FAILS          | Miguel       |                | passw1288   | medico     | 645612514      | usuariopM@ejemplo.com |	Ciudad real						 | cabecera                 |
      | SIN CONTRASEÑA INTRODUCIDA    | FAILS          | Miguel       | Peco Gomez     | passw1288   | medico     | 645612514      | usuariopM@ejemplo.com |	Ciudad real						 | cabecera                 |
      | SIN EMAIL INTRODUCIDO         | FAILS          | Miguel       | Peco Gomez     | passw1288   | medico     | 645612514      |                       |	Ciudad real						 | cabecera                 |
      | SIN LOCALIDAD INTRODUCIDA     | IS SUCCESSFUL  | Miguel       | Peco Gomez     | passw1288   | medico     | 645612514      | usuariopM@ejemplo.com |	                       | cabecera                 |
      | SIN ESPECIALIDAD INTRODUCIDA  | IS SUCCESSFUL  | Miguel       | Peco Gomez     | passw1288   | medico     | 645612514      | usuariopM@ejemplo.com |	Ciudad real						 |                          |

