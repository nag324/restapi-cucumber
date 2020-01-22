Feature: Get access token and verify the branch object data in salesforce

Scenario: Get the access token by passing client secret
 Given I perform authentication for "salesforce" with params
 Given I perform GET operation on Account object in "sandbox" environment
 Then I should see label name as Account