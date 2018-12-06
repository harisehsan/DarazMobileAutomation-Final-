@Address_Msite

Feature: Address Msite test

  @17480551 @member_regression @member_smoke @no_lzd
  Scenario: User can add new address
    When I go to the sign up on Msite page by email
    And I input all information to signup by email page
    And I should see the name of user in account title
    And I access to address page
    And I input content of address_detail
    And I click save address button
    Then I should see one address on address page

  @17480541 @member_regression @member_smoke @no_lzd
  Scenario: User can edit address information - Drz
    Given I go to the sign up on Msite page by email
    When I input all information to signup by email page
    And I should see the name of user in account title
    And I access to address page
    And I input content of address_detail
    And I click save address button
    When I go to edit address information
    Then I should see the new address name on Msite

  @17480537 @member_regression @member_smoke @no_lzd
  Scenario: User can delete address successfully - Drz
    Given I go to the sign up on Msite page by email
    When I input all information to signup by email page
    And I should see the name of user in account title
    And I access to address page
    And I input content of address_detail
    And I click save address button
    When I input content of address_delete
    And I click save address button
    And I delete address on address book
    Then I should see one address on address page