@CheckoutWithCOD
  Feature: Checkout with COD method

    @17847772 @Checkout_COD @Checkout_Regression @Checkout_Smoke
    Scenario: User (login by email and password) can checkout with COD successfully
      Given I login by email on lazada/daraz
      When I go to a pdp page
      And I click on Add to cart button
      And I click Checkout button on Cart popup
      And I click Place Order button on Checkout Shipping page
      And I place order with COD payment method
      Then I should be on Checkout Success page

    @17847772 @Check_Product_On_Cart @Checkout_Regression @Checkout_Smoke
    Scenario: Product exists on cart after user added successfully.
      Given I login by email on lazada/daraz
      When I go to a pdp page
      And I get the product title
      And I click on Add to cart button
      And I click Go To Cart button on Cart popup
      Then I should see the product title in the Cart

