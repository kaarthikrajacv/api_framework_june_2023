Feature: To test out the REQRES PUT example

  @put_reqres
  Scenario: Test the PUT API with right input
    When The input details to PUT API
    Then The API is executed
    Then Validate the PUT response