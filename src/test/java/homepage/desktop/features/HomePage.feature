@homepage
Feature: homepage Test


  @Existing_Account @buynow @Checkout_Regression
  Scenario: Existing account could checkout with COD as normal
    When  I go to HomePage
    And I click on log in to login page
    Then I input account information
    And I click on log in button
    Then I back to HomePage
    Then I select random product have COD
    Then I click on buy now that product
    Then I click on first place order button on shipping page
    And I select COD on payment page
    Then I confirm order
    Then Order is successful place

  @Existing_Account @addToCart
  Scenario: Existing account could add to cart and checkout with COD as normal
    When  I go to HomePage
    And I click on log in to login page
    Then I input account information
    And I click on log in button
    Then I back to HomePage
    Then I select random product have COD
    And I add product to cart successfully
    Then I go to Cart successful
    And I select all items in Cart
    Then I go to Checkout Page
    Then I click on first place order button on shipping page
    And I select COD on payment page
    Then I confirm order
    Then Order is successful place
