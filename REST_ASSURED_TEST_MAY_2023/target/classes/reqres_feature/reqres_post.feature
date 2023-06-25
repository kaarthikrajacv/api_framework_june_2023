@post_reqres @feature
Feature: To test out the REQRES POST example

  @scenario
  Scenario: Test the POST API with right input
    When The input details to POST API
    Then The API is executed
    Then Validate the POST response