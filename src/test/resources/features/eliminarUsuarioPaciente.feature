Feature: Eliminar usuario paciente


  Scenario: eliminar por campo email

    When cuando se quiere eliminar el usuario paciente con el email 'email'
    Then el resultado de eliminarlo es 'correcto'