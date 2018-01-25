@LoginProfile
Feature: Wishlist Test


  @first_test
  Scenario: Add to Wishlist from PDP
    When I go to pdp page
    And I add product to Wishlist from PDP
    And I go to wishlist page
    Then I should see item displayed in Wishlist
