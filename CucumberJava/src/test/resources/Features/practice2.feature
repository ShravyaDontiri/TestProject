Feature: Testing telesales portal funcionality

  Scenario Outline: Run a new wireline order
    Given user login to telesales channel
    And enter address details
    And select offer and add to cart
    And user enters <firstName>,<lastName>,<fiscalCode> and <email>
    When user completes the payment
    And click on submit order button
    Then verify that order is submitted

    Examples: 
      | firstName | lastName | fiscalCode       | email        |
      | SDDT       | SDDT      | SDDSDT98H15F205T | sdt@mail.com |
