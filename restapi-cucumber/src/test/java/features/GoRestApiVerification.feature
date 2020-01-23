Feature: Verifying the GET, POST, PUT, DELETE functionality in GoRest Api.

  Scenario: Verify GET users functionality
    Given I perform GET operation on "/public-api/users" with params
    Then the response status code should be "200"
    And the response should have first_name