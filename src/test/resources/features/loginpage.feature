Feature: Login functionality


  Background: User is on login page
    Given  user is on login page

  Scenario Outline: User can login with valid credentials

    When user enters valid email "<email>"
    And  user enters valid password "<password>"
    And  user clicks login button
    Then user is on home page

    Examples: Email and Password
      | email                   | password     |
      | salesmanager48@info.com | salesmanager |
      | salesmanager64@info.com | salesmanager |
      | posmanager48@info.com   | posmanager   |
      | posmanager64@info.com   | posmanager   |


  Scenario Outline: "Wrong login/password" should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials

    When user enters invalid email "<email>"
    And  user enters invalid password "<password>"
    And  user clicks login button
    Then user see  warning message

    Examples: Email and Password
      | email                    | password      |
      | posmanager480@info.com   | posmanager    |
      | salesmanager640@info.com | salesmanager  |
      | posmanager48@info.com    | posmanager123 |
      | salesmanager64@info.com  | posmanager123 |
      | posmanager614@info.com   | posmanager123 |
      | posmanager480@info.com   | posmanager234 |


  Scenario Outline: "Please fill out this field" message should be displayed if the password or username is empty

    When user do not enter  email "<email>" or "<password>" or both of them.
    And  user clicks login button
    Then user see  warning message

    Examples: Email and Password
      | email                   | password     |
      |                         | salesmanager |
      | salesmanager64@info.com |              |
      |                         | posmanager   |
      | posmanager64@info.com   |              |
      |                         |              |

