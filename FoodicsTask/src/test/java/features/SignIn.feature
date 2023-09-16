Feature: Contact page features
  @Regression
  Scenario Outline: Login with valid credentials
    Given user open the Home page
    When Clicks Sign In button
    And user fills "<username>" and click continue
    And user fills "<password>" and click submit
    And user Open All Menu and Select Video Games and page should be opened
    And User filters the products and sort and select all products less than 15000
    And User clicks Add to Cart for products
    And User Added a new address
    Then Address should be added and amount is verified

    Examples:
    | username           | password |
    | +966536189765      | P@ssw0rd|



