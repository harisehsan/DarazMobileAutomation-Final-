@PlaceOrder
Feature: Place order Test


  @test3
  Scenario: Guest can place a normal order
    When I login from Account Page
    And I go to normal pdp page
    And I check out with "5" products
    And I go to normal pdp page
    And I check out with "5" products
    And I place order from shipping page
    And I checkout with Cod method
    And I place normal order with "5" products

