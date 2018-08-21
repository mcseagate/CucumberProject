Feature: Fetch all rows and column value from dynamic web tables

  Scenario: A test to fetch rows and columms

    Given i am already signed in and i navigate to the table under test
    And i fetch all columns from the table
    Then i close the browser