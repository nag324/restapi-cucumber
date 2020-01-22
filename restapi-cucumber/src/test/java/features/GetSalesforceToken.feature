Feature: Get access token and verify the branch object data in salesforce

Scenario: Get the access token by passing client secret
Given I perform authentication for "salesforceLogin" with params
|GrantType|ClientId|ClientSecret|UserName|Password|
|password|3MVG9G9pzCUSkzZuOH7_xGz.OogPNTJIWBj0bSAZheWD4FgZubWV6yxEK0Uol6s2elvkTH4dCsm43q4pPhAHi|20BDD4886B297F20D74B1A0859938AFDC5A8184B8669AFFB4F55121FA4F3B237|nag@nznetwork.com|salesforce1234|
Given I perform GET operation for "salesforceDevSandbox"
Then I should see label name as Account
