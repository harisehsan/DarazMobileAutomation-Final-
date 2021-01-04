@prerequisite @productcheck

Feature: Products Checking

  @30475025 @verify_first_item_from_products_properties
  Scenario: verify the first item from product property file
   When I go to HomePage
    When I search for the 1 SKU from "Product" property file
    And I goto the product
    Then I verify that the product is in stock

  @30475025 @verify_second_item_from_products_properties
  Scenario: verify the second item from product property file
    When I go to HomePage
    When I search for the 2 SKU from "Product" property file
    And I goto the product
    Then I verify that the product is in stock

  @30475025 @verify_third_item_from_products_properties
  Scenario: verify the third from product property file
    When I go to HomePage
    When I search for the 3 SKU from "Product" property file
    And I goto the product
    Then I verify that the product is in stock

  @30475025 @verify_first_item_from_pdp_properties
  Scenario: verify the first item from Pdp property file
    When I go to HomePage
    When I search for the 1 SKU from "Pdp" property file
    And I goto the product
    Then I verify that the product is in stock
    Then I verify the existence of chat feature on this product

  @30475025 @verify_second_item_from_pdp_properties
  Scenario: verify the second item from Pdp property file
    When I go to HomePage
    When I search for the 2 SKU from "Pdp" property file
    And I goto the product
    Then I verify that the product is in stock
    And I select the last SKU of product
    Then I verify that the product is in stock

  @30475025 @verify_third_item_from_pdp_properties
  Scenario: verify the third item from Pdp property file
    When I go to HomePage
    When I search for the 3 SKU from "Pdp" property file
    And I goto the product
    Then I verify that the product is in stock
    Then I verify for the seller "Collect" voucher

  @30475025 @verify_fourth_item_from_pdp_properties
  Scenario: verify the fourth item from Pdp property file
    When I go to HomePage
    When I search for the 4 SKU from "Pdp" property file
    And I goto the product
    Then I verify that the product is in stock
    Then I verify the existence of "Free Gift" promotion on Pdp

  @30475025 @verify_fifth_item_from_pdp_properties
  Scenario: verify the fifth item from Pdp property file
    When I go to HomePage
    When I search for the 5 SKU from "Pdp" property file
    And I goto the product
    Then I verify that the product is in stock
    Then I verify the existence of "Combo Offer" promotion on Pdp

  @30475025 @verify_sixth_item_from_pdp_properties
  Scenario: verify the sixth item from Pdp property file
    When I go to HomePage
    When I search for the 6 SKU from "Pdp" property file
    And I goto the product
    Then I verify that the product is in stock
    Then I verify for the seller "Copy" voucher

  @30475025 @verify_seventh_item_from_pdp_properties
  Scenario: verify the seventh item from Pdp property file
    When I go to HomePage
    When I search for the 7 SKU from "Pdp" property file
    And I goto the product
    Then I verify that the product is in stock
    Then I verify the existence of "Buy More & Save Up" promotion on Pdp

  @30475025 @verify_eight_item_from_pdp_properties
  Scenario: verify the eight item from Pdp property file
    When I go to HomePage
    When I search for the 8 SKU from "Pdp" property file
    And I goto the product
    Then I verify that the product is in stock
    Then I verify the existence of "Buy One Get One Free" promotion on Pdp

  @30475025 @verify_ninth_item_from_pdp_properties
  Scenario: verify the ninth item from Pdp property file
    When I go to HomePage
    When I search for the 9 SKU from "Pdp" property file
    And I goto the product
    Then I verify that the product is in stock
    Then I verify for the digital product

#  @30475025 @verify_tenth_item_from_pdp_properties @no_bd @no_lk @no_np @no_mm
#  Scenario: verify the tenth item from Pdp property file
#    When I go to HomePage
#    When I search for the 10 SKU from "Pdp" property file
#    And I goto the product
#    Then I verify that the product is in stock
#
#  @30475025 @verify_eleventh_item_from_pdp_properties @no_bd @no_lk @no_np @no_mm
#  Scenario: verify the eleventh item from Pdp property file
#    When I go to HomePage
#    When I search for the 11 SKU from "Pdp" property file
#    And  I goto the product
#    Then I verify that the product is in stock
#
#  @30475025 @verify_twelveth_item_from_pdp_properties @no_bd @no_lk @no_np @no_mm
#  Scenario: verify the twelveth item from Pdp property file
#    When I go to HomePage
#    When I search for the 12 SKU from "Pdp" property file
#    And  I goto the product
#    Then I verify that the product is in stock
#
#  @30475025 @verify_thirteenth_item_from_pdp_properties @no_bd @no_lk @no_np @no_mm
#  Scenario: verify the thirteenth item from Pdp property file
#    When I go to HomePage
#    When I search for the 13 SKU from "Pdp" property file
#    And  I goto the product
#    Then I verify that the product is in stock
#    Then I verify for the digital product