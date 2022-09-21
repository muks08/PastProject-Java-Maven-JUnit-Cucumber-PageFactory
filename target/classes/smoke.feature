
@Smoke
Feature: As a user
    User want to test all main site functionality
    So that user can be sure that site works correctly


  Scenario Outline: Check if the header of the site is visible
    Given User opens '<homePage>' page
    And User accepts cookies
    Then User checks whether header is visible

    Examples:
      |homePage                    |
      |https://www.cropp.com/ua/uk/|


  Scenario Outline: Check if the elements contains word <keyWord> more than ten times
    Given User opens '<homePage>' page
    And User accepts cookies
    When User moves a cursor to the tab menu Shoes
    And User clicks All for men
    Then User checks if the elements on page contains word '<keyWord>'more than ten times

    Examples:
      |homePage                    |keyWord|
      |https://www.cropp.com/ua/uk/|Кеди   |


  Scenario Outline: Check location and language change working correctly
    Given User opens '<homePage>' page
    And User accepts cookies
    When User clicks Language button
    And User changes location to '<location>'
    Then User checks that url of the '<homePage>' has changed to '<expectedUrl>'

    Examples:
      |homePage                    |location|expectedUrl               |
      |https://www.cropp.com/ua/uk/|Poland  |https://www.cropp.com/pl/pl/|
