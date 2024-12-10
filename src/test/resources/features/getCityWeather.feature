#language: en

Feature: Search Weather By City Name

  @GetWeather

  Scenario Outline: Successfully find Weather

    When I send a Get request to the endpoint '<endpoint>' with city name '<name>'
    Then I validate the response code is '<code>' and the structure '<keys>' is valid

    Examples:
      | endpoint | name     | code | keys                |
##@externaldata@parameters/Datos.xlsx@EndpointInfo
      | /weather | Aberdeen | 200  | name,weather,status |