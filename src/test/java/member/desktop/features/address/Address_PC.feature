@Address_PC

Feature: Address on PC

  @17807244 @member_regression @member_smoke @no_sg
  Scenario: As user add new address for daraz on PC
    Given I go to the sign up page by email
    And I sign up by api
    And I open add new address page input name info
    And I create new address
    Then I should see the new address on account page

  @17480501 @member_regression @member_smoke @no_lzd
  Scenario: User edit address information for daraz on PC
    Given I go to the sign up page by email
    And I sign up by api
    And I open add new address page input name info
    And I create new address
    And I click first edit button on any address
    And I edit name, phone number information
    Then I should see on Daraz the new editing name of address

  @17937780 @member_regression @member_smoke @no_drz @no_sg
  Scenario: User edit address information for lzd on PC
    Given I go to the sign up page by email
    And I sign up by api
    And I open add new address page input name info
    And I create new address
    And I click last edit button on any address
    And I edit name, phone number information
    Then I should see on Lazada the new editing name of address

  @17480513 @member_regression @member_smoke @no_lzd
  Scenario: User delete address on address book for daraz on PC
    Given I go to the sign up page by email
    And I sign up by api
    And I open add new address page input name info
    And I create new address
    And I open add new address page input name info
    And I create an address to delete
    And I access edit page on Daraz to delete address
    And I click delete button
    And I go back the address book page
    Then I should not see address has deleted on page

  @17938204 @member_regression @member_smoke @no_drz @no_sg
  Scenario: User delete address on address book for lzd on PC
    Given I go to the sign up page by email
    And I sign up by api
    And I open add new address page input name info
    And I create new address
    And I open add new address page input name info
    And I create an address to delete
    And I access edit page on Lazada to delete address
    And I click delete button
    And I go back the address book page
    Then I should not see address has deleted on page