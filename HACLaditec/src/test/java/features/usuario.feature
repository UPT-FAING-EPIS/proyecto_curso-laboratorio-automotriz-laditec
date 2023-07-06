Feature: Manejo de usuarios

  Scenario: Agregar usuario
    Given un usuario con idusuario 23
    When se agrega un usuario con idusuario 23
    Then debo ver un mensaje de exito que indica que el usuario ha sido creado

  Scenario: Listar usuario
    Given se ha agregado un usuario
    When se lista los usuarios
    Then se muestra la lista de usuarios


  Scenario: Editar usuario
    Given un usuario con idusuario 23
    When se edita el usuario con idusuario 23, nueva clave "s12345" y nuevo estado "A"
    Then el usuario se edita correctamente