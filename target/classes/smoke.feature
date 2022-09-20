
@Smoke
Feature: As a user
    User want to test all main site functionality
    So that user can be sure that site works correctly


  Scenario Outline: Check if the element "cropp" is visible
    Given User opens '<homePage>' page
    And User accepts cookies
    Then User checks whether header is visible of the site

    Examples:
    |homePage                     |
    |https://www.cropp.com/ua/uk/ |
