@FIDEX10-350
Feature: Login functionality

#@FIDEX10-343
  Background: User is on login page
    Given  user is on login page

  @FIDEX10-344
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
      | posmanager74@info.com   | posmanager   |
      | posmanager84@info.com   | posmanager   |
      | salesmanager41@info.com | salesmanager |
      | salesmanager61@info.com | salesmanager |

  Scenario Outline: "Wrong login/password" should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials

    When user enters invalid email "<email>"
    And  user enters invalid password "<password>"
    And  user clicks login button
    Then user see  warning message

    Examples: Email and Password
      | email                     | password               |
      | posmanager480@info.com    | posmanager             |
      | salesmanager640@info.com  | salesmanager           |
      | posmanager48@info.com     | posmanagerTHGFD          |
      | salesmanager64@info.com   | posmanager^(*          |
      | posmanager614@info.com    | *+/.posmanager          |
      | posmanager480@info.com    | posma/*><              |
      | posmanager4*/@info.com    | \SAK82YWDHI5654        |
      | salesmanager640@info.com  | !"£$%^*([}@?><         |
      | posmanager??@info.com     | &*(posmanager123       |
      | salesmanager++@info.com   | HGSALYsmanager123      |
      | posmanager614.@info.com   | {}?pogalkGIsmanager123 |
      | posmanager480@info.com.tr | sossmanager            |

  @FIDEX10-346
  Scenario: "Please fill out this field" message should be displayed if the password or username is empty

    When user do not enter email or password
    And  user clicks login button
    Then user see "Please fill in this field." warning message

  @FIDEX10-347
  Scenario Outline: User should see the password in bullet signs by default
      When user enters valid email "<email>"
      And user enters valid password "<password>"
      Then the password should be masked with asteriks
      Examples:Email and Passwords
        | email                   | password     |
        | salesmanager60@info.com | salesmanager |
        | posmanager26@info.com   | posmanager |


  @FIDEX10-348
Scenario Outline: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
  When  user enters valid email "<email>"
  And user enters valid password "<password>"
  And user enters Enter key on the keyboard.
  Then user is on home page
  Examples:Email and Passwords
    | email                   | password     |
    | salesmanager90@info.com | salesmanager |
    | posmanager60@info.com   | posmanager   |
    | salesmanager95@info.com | salesmanager |
    | posmanager63@info.com   | posmanager   |
    | salesmanager10@info.com | salesmanager |
    | posmanager100@info.com   | posmanager   |
    | salesmanager97@info.com | salesmanager |
    | posmanager69@info.com   | posmanager   |


  @FIDEX10-349
Scenario: User land on the ‘reset password’ page after clicking on the "Reset password" link
  When user click "Reset password" link
  Then  User land on reset  password page
