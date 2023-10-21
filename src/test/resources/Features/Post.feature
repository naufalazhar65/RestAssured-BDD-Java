Feature: Testing ReqRes API

  Scenario: Verify ReqRes API POST request
    Given I send a POST request to "https://reqres.in/api/users"
    And the request body is:
      """
      {
        "name": "Naufal",
        "job": "QA Engineer"
      }
      """
    When the response code is 201
    Then the response should contain "Naufal"
    And the response should contain "QA Engineer"
    And the response should have a JSON property "id" of type "int"
    
