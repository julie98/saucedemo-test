Feature: User Login

  Scenario Outline: User login attempt
    Given I am on the login page
    When I enter the username "<username>"
    And I enter the password "<password>"
    And I click the login button
    Then I should see "<result>"

    Examples:
      | username      | password     | result           |
      | standard_user | secret_sauce | the product page |
      | invalid_user  | invalid_pwd  | an error message |