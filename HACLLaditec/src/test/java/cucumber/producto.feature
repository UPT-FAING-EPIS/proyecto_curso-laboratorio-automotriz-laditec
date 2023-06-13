Feature: Operaciones con Repuestos

  Background:
    Given se ha establecido una conexión con la base de datos

  Scenario: Listar repuestos
    When obtengo la lista de repuestos
    Then debería recibir una lista de repuestos válida

  Scenario: Obtener un repuesto específico
    When obtengo el repuesto con ID 1
    Then debería recibir los detalles del repuesto

