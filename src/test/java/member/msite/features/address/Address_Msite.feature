@Address_Msite

Feature: Address Msite test

  @17480551 @member_regression @member_smoke @no_lzd
  Scenario: User add new address on Msite
    When I go to the sign up on Msite page by email
    And I input all information to signup by email page
    And I should stayed in account page
    And I access to address page
    And I input content of address_detail
    And I click save address button
    Then I should see the address on address page

  @17480541 @member_regression @member_smoke @no_lzd
  Scenario: User edit address on Msite
    Given I go to the sign up on Msite page by email
    When I input all information to signup by email page
    And I should stayed in account page
    And I access to address page
    And I input content of address_detail
    And I click save address button
    When I go to edit address information
    Then I should see the new address name on Msite
