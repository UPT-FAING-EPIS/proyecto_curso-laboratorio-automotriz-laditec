Feature: Inicio de sesion

  Scenario: Inicio de sesión exitoso
    Given Soy un usuario registrado en el sistema
    When ingreso con mis credenciales de inicio de sesion validas "diego12@gmail.com" y "123"
    Then se inicia sesión exitosamente