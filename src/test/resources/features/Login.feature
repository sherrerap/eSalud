Feature: Datos de Login validos
  Queremos ver si accedemos correctamente a la aplicacion

  Scenario Outline: Today is or is not Friday
    Given Accediendo a la aplicacion por Firefox
    When introduciomos "<email>" y "<password>" correctos
    Then Accedemos a la aplicacion

  Examples:
    | email            					  | password     |
    | ejemplo@ejemplo.com         | password12   |