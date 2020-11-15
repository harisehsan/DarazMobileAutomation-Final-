@prerequisite @deliveredorder

Feature: Make the delivered ordered for return

  @30475025 @make_the_delivered_order_for_normal_products
  Scenario: Make the normal order delivered
    When I go to HomePage
    And I select google for signin
    And I sign by providing buyer google account "Enter your e-mail here" email and "Enter your password here" password
    When I search for the 1 SKU from "Product" property file
    And I goto the product
    And I select buy now button
    And I click Place Order button on Checkout Shipping page
    And I place order with COD payment method
    Then I should be on Checkout Success page
    And I save the Order Number for "Normal" order and venture details
    And I make the order RTS from seller center for "Normal" order
    And I goto order push tool
    And I sign with my alibaba account "Enter your ID here" ID and "Enter your password here" password
    And I make the order status delivered for "Normal" order
    Then I verify for the success message for order deliver
    And I save the delivered order number for "Normal" product in mobile automation project

  @30475025 @make_the_delivered_order_for_free_gift_products
  Scenario: Make the free gift order delivered
    When I go to HomePage
    And I select google for signin
    And I sign by providing buyer google account "Enter your e-mail here" email and "Enter your password here" password
    When I search for the 4 SKU from "pdp" property file
    And I goto the product
    And I select buy now button
    And I click Place Order button on Checkout Shipping page
    And I place order with COD payment method
    Then I should be on Checkout Success page
    And I save the Order Number for "Free Gift" order and venture details
    And I make the order RTS from seller center for "Free Gift" order
    And I goto order push tool
    And I sign with my alibaba account "Enter your ID here" ID and "Enter your password here" password
    And I make the order status delivered for "Free Gift" order
    Then I verify for the success message for order deliver
    And I save the delivered order number for "Free Gift" product in mobile automation project

  @30475025 @make_the_delivered_order_for_combo_products
  Scenario: Make the combo order delivered
    When I go to HomePage
    And I select google for signin
    And I sign by providing buyer google account "Enter your e-mail here" email and "Enter your password here" password
    When I search for the 5 SKU from "pdp" property file
    And I goto the product
    And I make a checkout for combo product
    And I click Place Order button on Checkout Shipping page
    And I place order with COD payment method
    Then I should be on Checkout Success page
    And I save the Order Number for "Combo" order and venture details
    And I make the order RTS from seller center for "Combo" order
    And I goto order push tool
    And I sign with my alibaba account "Enter your ID here" ID and "Enter your password here" password
    And I make the order status delivered for "Combo" order
    Then I verify for the success message for order deliver
    And I save the delivered order number for "Combo" product in mobile automation project

  @30475025 @make_the_delivered_order_for_buy_more_save_more_products
  Scenario: Make the buy more save more order delivered
    When I go to HomePage
    And I select google for signin
    And I sign by providing buyer google account "Enter your e-mail here" email and "Enter your password here" password
    When I search for the 7 SKU from "Pdp" property file
    And I goto the product
    And I select buy now button
    And I click Place Order button on Checkout Shipping page
    And I place order with COD payment method
    Then I should be on Checkout Success page
    And I save the Order Number for "Save More" order and venture details
    And I make the order RTS from seller center for "Save More" order
    And I goto order push tool
    And I sign with my alibaba account "Enter your ID here" ID and "Enter your password here" password
    And I make the order status delivered for "Save More" order
    Then I verify for the success message for order deliver
    And I save the delivered order number for "Save More" product in mobile automation project

  @30475025 @make_the_delivered_order_for_buy_one_get_one_products
  Scenario: Make the buy one get one order delivered
    When I go to HomePage
    And I select google for signin
    And I sign by providing buyer google account "Enter your e-mail here" email and "Enter your password here" password
    When I search for the 8 SKU from "Pdp" property file
    And I goto the product
    And I select buy now button
    And I click Place Order button on Checkout Shipping page
    And I place order with COD payment method
    Then I should be on Checkout Success page
    And I save the Order Number for "B1G1" order and venture details
    And I make the order RTS from seller center for "B1G1" order
    And I goto order push tool
    And I sign with my alibaba account "Enter your ID here" ID and "Enter your password here" password
    And I make the order status delivered for "B1G1" order
    Then I verify for the success message for order deliver
    And I save the delivered order number for "B1G1" product in mobile automation project