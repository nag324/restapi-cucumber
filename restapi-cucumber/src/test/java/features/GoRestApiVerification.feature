Feature: Verifying the GET, POST, PUT, DELETE functionality in GoRest Api.

  Scenario Outline: Verify if User is being Succesfully created using CreateUserAPI
    Given Create User Payload for "GoRest" with "<first_name>" "<last_name>" "<gender>" "<status>"
    When user calls "CreateUser" with "POST" http request
    And "_meta.success" in response body is "true"
    And verify user created maps to "result.first_name" using "GetUser"
    Examples:
     |first_name |last_name 	 | gender |status	 |
     | Sai       |Shyam       |male    |active|
     #|Super      |Sam         |female  |sup@gmail.com|Active|
