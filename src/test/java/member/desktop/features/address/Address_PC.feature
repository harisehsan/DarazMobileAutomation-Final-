@Address_PC @smoke

Feature: Address on PC

  @17807244 @member_regression @member_smoke @no_sg @no_drz
  Scenario: User can add new address
    Given I go to the sign up page by smsphone
    And I login by api with email
#    And I sign up by api
    And I open add new address page input name info
    And I create new address
    Then I should see the new address on account page
    And I access edit page on Lazada to delete address
    And I click delete button
    And I go back the address book page
    Then I should delete address successfully

  @17807244 @member_regression @member_smoke @no_lzd
  Scenario: User can add new address
    Given I sign up by api with email
    And I open add new address page input name info
    And I create new address
    Then I should see the new address on account page

  @18062654 @member_regression @member_smoke @no_drz @no_id @no_th @no_vn @no_my @no_ph
  Scenario: User can add new address and delete address- SG
    Given I go to the sign up page by smsphone
    And I login by api with email
    And I open add new address page input name info
    And I create a new address for SG
    Then I should see the new address on account page
    And I delete address by api
    Then I should delete address successfully

  @17480501 @member_regression @member_smoke @no_lzd
  Scenario: User can edit address information - Drz
    Given I sign up by api with email
    And I open add new address page input name info
    And I create new address
    And I click first edit button on any address
    And I edit name, phone number information
    Then I should see on Daraz the new editing name of address

  @17937780 @member_regression @member_smoke @no_drz @no_sg @no_lzd
  Scenario: User can edit address information - Lzd
    Given I go to the sign up page by smsphone
    And I sign up by api with email
    And I open add new address page input name info
    And I create new address
    And I click last edit button on any address
    And I edit name, phone number information
    Then I should see on Lazada the new editing name of address

  @17480513 @member_regression @member_smoke @no_lzd
  Scenario: User can delete address successfully - Drz
    Given I sign up by api with email
    And I open add new address page input name info
    And I create new address
    And I open add new address page input name info
    And I create an address to delete
    And I access edit page on Daraz to delete address
    And I click delete button
    And I go back the address book page
    Then I should not see address has deleted on page


  @17938204 @member_regression @member_smoke @no_drz @no_sg
  Scenario: User can delete address successfully - Lzd
##    Given I go to the sign up page by smsphone
##    And I sign up by api
##    And I open add new address page input name info
##    And I create new address
##    And I open add new address page input name info
##    And I create an address to delete
##    And I access edit page on Lazada to delete address
##    And I click delete button
##    And I go back the address book page
##    Then I should not see address has deleted on page
    Given I go to the sign up page by smsphone
    And I login by api with email
    And I open add new address page input name info
    And I create new address
    Then I should see the new address on account page
    And I access edit page on Lazada to delete address
    And I click delete button
    And I go back the address book page
    Then I should delete address successfully


  @Delete_Address_API
  Scenario: User can delete address successfully - Lzd
    Given I go to the sign up page by smsphone
    And I login by api with email
    And I open add new address page input name info
    And I create new address
    And I delete address by api
    Then I should delete address successfully

