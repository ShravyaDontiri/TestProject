Feature: Testing telesales portal funcionality

  Scenario Outline: Run a new wireline order
    Given user login to telesales channel
    And enter address details
    And select offer and add to cart
    And user enters the following credentials:
      | Field       | Value        |
      | First name  | <firstName>  |
      | Last name   | <lastName>   |
      | Fiscal Code | <fiscalCode> |
      | Email       | <email>      |
    When user completes the payment
    And click on submit order button
    Then verify that order is submitted

    Examples: 
      | firstName | lastName | fiscalCode       | email   |
      | AATTYY    | AATTYY   | TTYTYY98H13F205T | s@s.com |
