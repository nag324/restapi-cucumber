Feature: Verifying the GET, POST, PUT, DELETE functionality in GoRest Api.

  Scenario Outline: Create a user with http POST
    Given Create User Payload for "GoRest" with "<first_name>" "<last_name>" "<gender>" "<status>"
    When user perform "POST" http request on "CreateUser"
    Then "_meta.success" in response body is "true"
    Examples:
     |first_name |last_name 	 | gender |status	 |
     | Sai       |Shyam       |male    |active|
     |Super      |Sam         |female  |inactive|

  Scenario: Verify if the user is being succesfully created using http GET
    Given I perform "GET" http request on "GetUser"
    Then firstname in the user created above should match to "result.first_name"

  Scenario: Update the user status details with http PUT
    Given I perform "PUT" http request on "UpdateUser" with the below details
    |last_name|
    |Test|
    Then user status should have latest details

   Scenario: Verify if the user is deleted successfully using http DELETE
     Given I perform "DELETE" request on user with "DeleteUser"
     Then "_meta.success" in response body is "true"