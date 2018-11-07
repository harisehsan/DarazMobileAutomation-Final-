@HP
Feature: homepage Test

// for practice
  @Guest @normal
  Scenario: Guest can go to normal PDP
    When I go to "normal" pdp page
    Then I can see the PDP page loaded
    Then I can add product to cart
    After that I can go to cart
    Then I checkout