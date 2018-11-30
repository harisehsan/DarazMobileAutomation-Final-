@pdp @911
Feature: Pdp features

  @17958367 @checkout_regression @checkout_smoke @no_lzd
  Scenario: User can add the product to wishlist
    Given I go to a normal pdp page
    And I get the product title
    And I sign up by api
    When I click wishlist icon
    Then I should see wishlist icon turns to orange
    And I should see the product on My wishlist page

  @18008755 @checkout_regression @checkout_smoke @no_lzd_live @no_drz_live
  Scenario: Ask valid question for shop
    Given I login by api with email and password
    And I go to a normal pdp page
    When I ask a valid_question
    Then I should see valid_question on the question list

  @18008857 @checkout_regression @checkout_smoke @no_id @no_th
  Scenario: Ask invalid questions
    Given I login by api with email and password
    And I go to a normal pdp page
    And I ask a question_include_email
    Then I should see error message that question_should_not_contain_email
    And I ask a question_include_phonenumber
    Then I should see error message that question_should_not_contain_phonenumber
    And I ask a question_include_externalWebLink
    Then I should see error message that question_should_not_contain_externalWebLink

  @18008960 @checkout_regression @checkout_smoke @no_drz @no_th
  Scenario: Chat with shop
    Given I go to a normal pdp page
    And I click Chat Now
    Then I should see Chat Now screen popup

  @18009022 @checkout_regression @checkout_smoke
  Scenario: Check LeadTime section exist on pdp
    When I go to a normal pdp page
    Then I should see lead time section

  @18009106 @checkout_regression @checkout_smoke
  Scenario: Check Buy Now/Add To Cart buttons work with user not login
    When I go to a normal pdp page
    And I click on Add to cart button - user not login
    Then I should see Login form
    When I close Login form
    And I click on Buy Now button
    Then I should see Login form

  @18009198 @checkout_regression @checkout_smoke @no_lzd
  Scenario: Check Buy Now/Add To Cart buttons work with user already login
    Given I go to a normal pdp page
    And I sign up by api
    And I create a new member address by api
    And I click on Add to cart button
    Then I should see Cart popup with product added to Cart
    When I close Cart popup
    And I click on Buy Now button
    Then I should be on Checkout Shipping page

  @18009289 @checkout_regression @checkout_smoke @no_lzd
  Scenario: Change item quantity by +/- icon
    Given I go to a normal pdp page
    And I sign up by api
    And I click plus icon to increase quantity
    Then I should see product quantity is 2
    And I click minus icon to decrease quantity
    Then I should see product quantity is 1
    And I click plus icon to increase quantity
    And I click on Add to cart button
    Then I should see product quantity in Cart is 2

  @18009359 @checkout_regression @checkout_smoke
  Scenario: User is able to input a number <= Max available number of product (maximum 5)
    Given I go to a normal pdp page
    And I get maximum available number of product
    And I enter a number that equal to maximum number
    Then I should see that quantity number is maximum number
    And I enter a number that greater than maximum number
    Then I should see that quantity number is maximum number





