#language: en

Feature: Search Weather By City

  @GetWeather

  Scenario Outline: Successfully find Weather

    When I send a Get request to the endpoint '<endpoint>' with parameter '<param>' and value '<value>'
    Then I validate the response code is '<code>' and the structure '<keys>' is valid

    Examples:
      | endpoint | param | value    | code | keys        |
##@externaldata@parameters/Datos.xlsx@EndpointInfo
      | /weather | name  | Aberdeen | 200  | data,status |