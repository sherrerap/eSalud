Feature: Crear usuario medico

  Scenario: Creacion de usuario medico para eSalud
  
    
    Given Se registra un usuario medico con los siguientes campos
      | Nombre	  	 | Apellidos      | Contraseña  | Rol        | numTelefono    | email                 | localidad             | especialidad             |  
      | Miguel       | Peco Gomez     | passw1288   | medico     | 645612514      | usuariopM@ejemplo.com |	Ciudad real						| cabecera                 |

    When el usuario medico guarda sus datos 'con todos los campos requeridos'
    Then el resultado de guardar el usuario medico 'es correcto'