Feature: Test login funtionality

  Scenario Outline: Login to webpage using multiple users in variable
    Given user is on login page
    When user enters <username> and <password>
    And clicked on login
    Then login is succesful

    Examples: 
      | username | password |
      | Mani     |      123 |
      | Sam      |      125 |
