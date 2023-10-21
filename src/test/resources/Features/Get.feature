Feature: Testing ReqRes API

  Scenario: Verify ReqRes API response
    Given I send a GET request to "https://reqres.in/api/users/1"
    When response code is 200
    Then response should contain "first_name"

