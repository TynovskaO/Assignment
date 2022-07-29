Feature: Buy Coins

  Scenario Outline: Buy a coin and validate successful message

    When user is on main page
    And user selects "<coin>"
    And user enters amount
    And user clicks BUY
    Then user sees successful message

    Examples:
      | coin     |
      | Ethereum |
      | Bitcoin  |
      | Solana   |

  Scenario Outline: Buy a coin with invalid amount and validate error

    When user is on main page
    And user selects random coin
    And user enters "<invalid amount>"
    Then BUY button should be disabled

    Examples:
      | invalid amount |
      | -50            |
      | 012.456        |
      | Solana         |