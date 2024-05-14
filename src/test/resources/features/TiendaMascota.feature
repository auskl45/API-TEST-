Feature: Tienda de Mascotas

  @testiendamascota
  Scenario Outline: Consulta de mascotas

    Given la url de la tienda es "https://petstore.swagger.io/v2/pet"
    When consulta de la mascota id <idMascota>
    Then valido el codoigo de respuesta sea <codigoRespuesta>
    And valido el nombre de la mascota sea "<nombreMascota>"
    And valido el parametro "category.name" tenga el contenido "<categoria>"
      And valido el parametro "name" tenga el contenido "<nombreMascota>"
    And valido el parametro "status" tenga el contenido "<status>"

    Examples:
    |idMascota|codigoRespuesta|nombreMascota| categoria| status|
    | 5    | 200           |    doggie    | string   | string|
    | 3    | 200           |    doggie    | string   | string|