
@Search
Feature: As a user
  User want to test search functionality
  So that user can be sure that site works correctly


  Scenario Outline: Check if products on Search page contains search request '<searchText>' more than '<times>' times
    Given User opens '<homePage>' page
    And User accepts cookies
    When User clicks on the Search button
    And User inputs the '<searchText>' search request
    Then User checks if products on Search page contains search request '<searchText>' more than '<times>' times

    Examples:
      |homePage                    |searchText    |times|
      |https://www.cropp.com/ua/uk/|Rick and Morty|10   |
