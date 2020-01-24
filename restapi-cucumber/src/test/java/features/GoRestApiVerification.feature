Feature: Verifying the GET, POST, PUT, DELETE functionality in GoRest Api.

  Scenario Outline: Verify if User is being Succesfully created using CreateUserAPI
    Given Create User Payload with "<first_name>" "<last_name>"  "<gender>"  "<email>" "<status>"
    When user calls "CreateUser" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And verify user created maps to "<first_name>" using "GetUser"

    Examples:
     |first_name |last_name 	 | gender |email|status	 |
     | Sai       |Shyam       |male    |sai@gmail.com|Active|
     |Super      |Sam         |female  |sup@gmail.com|Active|
