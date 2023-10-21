Feature: Testing ReqRes API

  Scenario: Verify ReqRes API DELETE request
    Given I send a DELETE request to "https://reqres.in/api/users/2"
    When delete response code is 204
    Then delete response should be empty
