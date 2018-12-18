@cart @911
Feature: Cart features

  @17740822 @checkout_regression @checkout_smoke @smoke
  Scenario: User can move a product on Cart to wishlist
    Given I login by api with email
    When I go to a normal pdp page
    And I get the product title
    And I click on Add to cart button
    And I click Go To Cart button on Cart popup
    And I move the product to wishlist
    Then I should see successful message and the product is not in Cart

  @17742324 @checkout_regression @checkout_smoke @smoke @no_lzd @no_id @no_my
  Scenario: User can delete a product on Cart successfully
    Given I sign up by api with email
    When I go to a test COD pdp page
    And I get the product title
    And I click on Add to cart button
    And I click Go To Cart button on Cart popup
    And I delete the product
    Then I should not see the product in Cart

  @fail @17757740 @checkout_regression @checkout_smoke @smoke @no_lzd @no_id @no_my
  Scenario: Confirm Cart button leads user to Checkout Shipping page
    Given I sign up by api with email
    And I create a new member address by api
    When I go to a test COD pdp page
    And I click on Add to cart button
    And I click Go To Cart button on Cart popup
    And I click Confirm Cart
    And I click Place Order button on Checkout Shipping page
    And I place order with COD payment method
    Then I should be on Checkout Success page




