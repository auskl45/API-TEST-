Feature: Order Pet Store

  @orderPetStore
  Scenario Outline: Creacion de nueva orden
    When creo la orden con id <idOrder>, petId <petId> y cantidad <quantity>
    Then el código de respuesta es <codigoRespuesta>
    And valido el id de la mascota sea <petId>


    Examples:
      |idOrder|petId|quantity| codigoRespuesta|
      | 5    | 4    |    23  |  200           |

  @orderPetStore
  Scenario Outline: Consulta de orden esxistente
    Given la url de las ordenes de la tienda es "https://petstore.swagger.io/v2/store/order"
    When consulta de la orden id <idOrder>
    Then valido el codigo de respuesta sea <codigoRespueta>
    And valido el id de la orden sea <idOrder>


    Examples:
      |idOrder|codigoRespueta|
      | 5    | 200           |
