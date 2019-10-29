
Feature: Crear usuario paciente

  Scenario: Creacion de usuario paciente para eSalud
  
    
    Given Se registra un usuario paciente con los siguientes campos
      | Nombre	  	 | Apellidos      | Contraseña  | Rol        | numTelefono    | email               | localidad             | 
      | Francisco    | Crespo Ramos   | passw1234   | paciente   | 645612547      | ejemplo@ejemplo.com |	Ciudad real						|

    When el usuario paciente guarda sus datos 'con todos los campos requeridos'
    Then el resultado de guardar el usuario 'es correcto'