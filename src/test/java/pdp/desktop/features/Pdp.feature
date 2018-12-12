@pdp @911
Feature: Pdp features

  @17958367 @checkout_regression @checkout_smoke @no_lzd
  Scenario: User can add the product to wishlist
    Given I sign up by api with email
    Given I go to a normal pdp page
    And I get the product title
    When I click wishlist icon
    Then I should see wishlist icon turns to orange
    And I should see the product on My wishlist page

  @18008755 @checkout_regression @checkout_smoke @no_lzd_live @no_drz_live
  Scenario: Ask valid question for shop
    Given I login by api with email
    And I go to a normal pdp page
    When I ask a valid_question
    Then I should see valid_question on the question list

  @18008857 @checkout_regression @checkout_smoke
  Scenario: Ask invalid questions
    Given I login by api with email
    And I go to a normal pdp page
    And I ask a question_contain_email
    Then I should see error message that question_should_not_contain_email
    And I ask a question_contain_phonenumber
    Then I should see error message that question_should_not_contain_phonenumber
    And I ask a question_contain_externalWebLink
    Then I should see error message that question_should_not_contain_externalWebLink

  @18008960 @checkout_regression @checkout_smoke @no_drz
  Scenario: Chat with shop
    Given I go to a normal pdp page
    And I click Chat Now
    Then I should see Message popup opening

  @18009022 @checkout_regression @checkout_smoke @no_my @no_th @no_sg
  Scenario: Check LeadTime function on pdp
    When I go to a normal pdp page
    Then I should see lead time section
    When I change a new address for Leadtime
    Then I should see Leadtime with new address

  @18135032 @checkout_regression @checkout_smoke @no_drz @no_vn @no_sg @no_ph @no_id
  Scenario: Check LeadTime function for MY and TH
    When I go to a normal pdp page
    And I submit new postcode in Leadtime
    Then I should see new Leadtime address has postcode

  @18009106 @checkout_regression @checkout_smoke
  Scenario: Check Buy Now/Add To Cart buttons work with guest user
    When I go to a normal pdp page
    And I click on Add to cart button as a guest
    Then I should see Login form
    When I close Login form
    And I click on Buy Now button
    Then I should see Login form

  @18009198 @checkout_regression @checkout_smoke @no_lzd
  Scenario: Check Buy Now/Add To Cart buttons work with login user
    Given I sign up by api with email
    And I create a new member address by api
    And I go to a normal pdp page
    And I click on Add to cart button on Pdp Page
    Then I should see Cart popup with product added to Cart
    When I close Cart popup
    And I click on Buy Now button
    Then I should be on Checkout Shipping page

  @18009289 @checkout_regression @checkout_smoke @no_lzd
  Scenario: Change item quantity by +/- icon
    Given I sign up by api with email
    And I go to a normal pdp page
    And I click plus icon to increase quantity
    Then I should see product quantity is 2
    And I click minus icon to decrease quantity
    Then I should see product quantity is 1
    And I click plus icon to increase quantity
    And I click on Add to cart button on Pdp Page
    Then I should see product quantity on Cart same to quantity on pdp

  @18009359 @checkout_regression @checkout_smoke
  Scenario: User cannot input a item quantity exceed than Max available number of product (maximum 5)
    Given I go to a normal pdp page
    And I enter a number that equals to maximum available quantity
    Then I should see that quantity number cannot exceed more than maximum available quantity






