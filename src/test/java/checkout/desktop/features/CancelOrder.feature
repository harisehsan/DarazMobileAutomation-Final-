@My_Order_PC

Feature: My Order PC Test for Daraz project

  @17916529 @911
  Scenario: User cancel order
    When I go to a pdp page
    And I login by api with email and password
    And I click on Add to cart button
    And I click Checkout button on Cart popup
    And I click Place Order button on Checkout Shipping page
    And I place order with COD payment method
    Then I should be on Checkout Success page
    And I click on track order link
    And I click cancel order button
    And I choose cancel reason to submit
    Then I should be on Cancel Success page