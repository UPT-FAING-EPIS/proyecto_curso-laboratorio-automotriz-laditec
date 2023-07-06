Feature: Operaciones con Repuestos

  Scenario: Listar los repuestos
    Given se ha establecido una conexión con la base de datos
    When obtengo la lista de repuestos
    Then debería recibir una lista de repuestos válida

  Scenario: Obtener un repuesto específico
    Given se ha establecido una conexión con la base de datos
    When obtengo el repuesto con id de 1
    Then debería recibir los detalles del repuesto

  Scenario: Agregar un nuevo repuesto
    Given tengo agregar un nuevo repuesto con los siguientes detalles <ID>, <Almacén>, <Estado>, "<Nombre>", <Categoría>, "<Imagen>", <Precio Unitario>, <Cantidad>
    When agrego el nuevo repuesto
    Then el repuesto debería ser agregado correctamente
    Examples:
    | ID  | Almacén | Estado | Nombre                                                                      | Categoría | Imagen | Precio Unitario | Cantidad |
    | 10  | 1               | 1          | Juego de 4 piezas de inyectores - Nissan               | 1                | png        | 180                   |          9       |
    | 11  | 1               | 1          | Bobina Byd F3 - Mitsubishi                                        | 2                | png        | 150                    |         16     |
    | 12  | 1               | 1          | TEX-11-103 / BOBINA NISSAN VERSA X-TRAIL              | 1                | png        | 70                      |       15       |
    | 13  | 1               | 1          | válvula Para Inyector Mitsubishi L200 4d56 4m41  | 2                | png        | 100                    |        17       |

  Scenario: Editar un repuesto existente
    Given tengo un repuesto existente con el <ID>
    When actualizo los detalles del repuesto <Almacén>, <Estado>, "<Nombre>", <Categoría>, "<Imagen>", <Precio Unitario>, <Cantidad>
    Then el repuesto debería ser actualizado correctamente
    Examples:
    | ID  | Almacén | Estado | Nombre                                                                          | Categoría | Imagen | Precio Unitario | Cantidad |
    | 1  | 1               | 1          | válvula Inyector Mitsubishi L200 updated  | 1                | png        | 180                   |          9       |