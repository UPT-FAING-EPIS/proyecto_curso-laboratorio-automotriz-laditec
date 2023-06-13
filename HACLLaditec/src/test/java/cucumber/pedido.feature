Feature: Manejo de pedidos de venta

  Scenario: Agregar pedido
    Given un usuario con ID de usuario 1
    When se agrega un pedido con fecha "2023-06-13" y estado "Pendiente"
    Then el pedido se agrega correctamente

  Scenario: Listar pedidos
    Given se ha agregado un pedido
    When se lista los pedidos
    Then se muestra la lista de pedidos

  Scenario: Ver pedidos de una boleta
    Given un usuario con ID de usuario 1
    When se visualizan los pedidos de la boleta
    Then se muestra la lista de pedidos de la boleta

  Scenario: Editar pedido
    Given un usuario con ID de usuario 1
    When se edita el pedido con ID de pedido 1, nueva fecha "2023-06-14" y nuevo estado "En progreso"
    Then el pedido se edita correctamente


