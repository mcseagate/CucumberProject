Feature: Login test validation


  Scenario: Test of valid login credential
    Given i navigate to the homepage
    And i input username  and password
    And click login button
    Then i am logged in and close the browser
