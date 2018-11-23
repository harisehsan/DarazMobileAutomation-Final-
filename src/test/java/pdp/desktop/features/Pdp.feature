@pdp @911
Feature: Pdp features

  @17958367 @checkout_regression @checkout_smoke
  Scenario: User can add the product to wishlist
    Given I go to a normal pdp page
    And I get the product title
    And I sign up by api
    When I click wishlist icon
    Then I should see wishlist icon turns to orange
    And I should see the product on My wishlist page


