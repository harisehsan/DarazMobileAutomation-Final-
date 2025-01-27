@pdp @911 @smoke
Feature: Pdp features

  @17958367 @pdp_regression @pdp_smoke @smoke
  Scenario: User can add the product to wishlist
    Given I login by api with email
    Given I go to a normal pdp page
    And I get the product title
    When I click wishlist icon
    Then I should see wishlist icon turns to orange
    And I should see the product on My wishlist page

  @18008755 @pdp_regression @pdp_smoke @smoke
  Scenario: Ask valid question for shop
    Given I login by api with email
    And I go to a test QnA pdp page
    When I ask a valid_question
    Then I should see valid_question on the question list

  @18008857 @pdp_regression @pdp_smoke @smoke
  Scenario: Ask invalid questions
    Given I login by api with email
    And I go to a normal QnA pdp page
    And I ask a question_contain_email
    Then I should see error message that question_should_not_contain_email
    And I ask a question_contain_phonenumber
    Then I should see error message that question_should_not_contain_phonenumber
    And I ask a question_contain_externalWebLink
    Then I should see error message that question_should_not_contain_externalWebLink

  @17916534 @18008960 @pdp_regression @pdp_smoke @smoke @no_drz
  Scenario: Chat with shop
    Given I login by api with email
    And I go to a test Chat Message pdp page from test sellers
    And I click Chat Now
    And I should see Message popup opening
    And I send a message to shop
    Then I should see my message in Message popup

  @18009022 @pdp_regression @pdp_smoke @smoke @no_my @no_th @no_sg
  Scenario: Check LeadTime function on pdp
    When I go to a normal COD pdp page
    Then I should see lead time section
    When I change a new address for Leadtime
    Then I should see Leadtime with new address

  @18135032 @pdp_regression @pdp_smoke @smoke @no_drz @no_vn @no_sg @no_ph @no_id
  Scenario: Check LeadTime function for MY and TH
    When I go to a normal pdp page
    And I submit new postcode in Leadtime
    Then I should see new Leadtime address has postcode

  @18009106 @pdp_regression @pdp_smoke @smoke @cart
  Scenario: Check Buy Now/Add To Cart buttons work with guest user
    When I go to a normal COD pdp page
    And I click on Add to cart button as a guest
    Then I should see Login form
    When I close Login form
    And I click on Buy Now button
    Then I should see Login form

  @18009198 @pdp_regression @pdp_smoke @smoke @cart
  Scenario: Check Buy Now/Add To Cart buttons work with login user
    Given I login by api with email
    And I go to a normal COD pdp page
    And I click on Add to cart button on Pdp Page
    Then I should see Cart popup with product added to Cart
    When I close Cart popup
    And I click on Buy Now button
    Then I should be on Checkout Shipping page

  @18009289 @pdp_regression @pdp_smoke @smoke @cart
  Scenario: Change item quantity by +/- icon
    Given I login by api with email
    And I go to a normal COD pdp page
    And I click plus icon to increase quantity
    Then I should see product quantity is 2
    And I click minus icon to decrease quantity
    Then I should see product quantity is 1
    And I click plus icon to increase quantity
    And I click on Add to cart button on Pdp Page
    Then I should see product quantity on Cart same to quantity on pdp

  @18009359 @pdp_regression @pdp_smoke
  Scenario: User cannot input a item quantity exceed than Max available number of product (maximum 5)
    Given I go to a normal COD pdp page
    And I enter a number that equals to maximum available quantity
    Then I should see that quantity number cannot exceed more than maximum available quantity






