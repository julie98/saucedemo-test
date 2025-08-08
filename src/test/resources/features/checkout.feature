Feature: Add items to cart and checkout

  Scenario Outline: Logged in user adds an item to cart and checks out
    Given I am logged in and on the inventory page with "<username>" and "<password>"
    When I add an item to the cart
    And I go to the cart page
    And I click the checkout button
    Then I should be directed to the information page
    When I enter the customer information "<firstName>" "<lastName>" "<zipCode>"
    And I click the continue button
    Then I should see the confirmation page
    And I click the finish button
    Then I should see the order complete page

    Examples:
    | username      | password     | firstName | lastName | zipCode |
    | standard_user | secret_sauce | George    | Zhu      | 95110   |