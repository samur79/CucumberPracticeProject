@FIDEX10-363
Feature: Log Out functionality

  Background: User is on login page
    #@FIDEX10-360
    Given  user is on login page
    And user logged in with a valid credential


  @FIDEX10-361
    Scenario: User can log out and ends up in login page.
      When user clicks username at the right top corner.
      And user see "log out" button.
      And  user clicks "log out" button.
      Then user goes back to login page.


  @FIDEX10-362
      Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out.
        When user clicks username at the right top corner.
        And  user clicks "log out" button.
        Then user goes back to login page.
        And user press "back" key on the keyboard
        And user is still on login page