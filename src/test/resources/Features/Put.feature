Feature: Testing ReqRes API

  Scenario: Verify ReqRes API PUT request
    Given I send a PUT request to "https://reqres.in/api/users/2"
    And put request body is:
      """
      {
        "name": "morpheus",
        "job": "zion resident"
      }
      """
    When I send the PUT request
    Then put response code is 200
    And put response should contain "morpheus"
    And put response should contain "zion resident"
