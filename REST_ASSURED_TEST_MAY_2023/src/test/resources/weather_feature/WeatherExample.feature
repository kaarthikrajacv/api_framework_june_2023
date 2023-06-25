Feature: Test Weather Example from OpenWeatherMap

  @cities
  Scenario: Test the weather API for given city
    Given The inputs to weather API for testing city
    When The Weather API is executed
    Then Validate the response of the weather API


#  @weather_outline_example
#  Scenario Outline: Test the weather API for different cities
#    Given The inputs to weather API for testing "<city>" city
#    When The Weather API is executed <test>
#    Then Validate the response of the weather API
#    Examples:
#      | city | test |
#      |Mumbai| 3.5 |
#      |Chennai| 4.7 |

