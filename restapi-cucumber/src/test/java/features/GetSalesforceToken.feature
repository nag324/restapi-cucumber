Feature: Get access token and verify the branch object data in salesforce

 Scenario: Get the access token by passing client secret
 Given I perform authentication for "salesforce" with params
 Given I perform GET operation on Account object in "sandbox" environment
 Then I should see label name as Account


 Scenario: Verify the count of urls in account object
  Given I perform GET operation on Account object in "sandbox" environment
  Then verify url contains "sobject" key in the response

 
  Scenario: Verify the count of urls in account object
  Given I perform GET operation on Account object in "sandbox" environment
  Then verify url contains "sobject" key in the response

