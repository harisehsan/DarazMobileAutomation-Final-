@Wishlist

Feature: Wishlist Test


  @Guest
  Scenario: Guest Add to Wishlist from PDP
    When I go to pdp page
    And I select product variation
    And I get PDP info
    And I add product to Wishlist from PDP
    And I go to wishlist page
    Then I should see item displayed in Wishlist

  @LoggedIn
  Scenario: User Add to Wishlist from PDP
    Given I login from Account Page by account: "pdp_qaa_3@lzdtest.net", password: "qacucumber1"
    And I go to pdp page
    And I select product variation
    And I get PDP info
    And I add product to Wishlist from PDP
    And I go to wishlist page
    Then I should see item displayed in Wishlist

