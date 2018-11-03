@Address_PC

Feature: Address on PC
  @addaddresspcdz
  Scenario: As user add new address on PC
    Given I go to the sign up page by email
    And I input the email information
    And I input password information
    And I input the name information
    And I click on submit button
    And I open add new address page input name info
    And I input the mobile phone number
    And I select the location 1
    And I input the location 2
    And I input the location 3
    And I input address detail
    And I click on save button
    Then I should see the new address on account page

  @addaddresspclzd @no_lzdsg
  Scenario: As user add new address on PC
    Given I go to the sign up page by email
    And I input the email information
    And I input password information
    And I input the name information
    And I click on submit button
    And I open add new address page input name info
    And I input the mobile phone number
    And I input floor/unit number address detail
    And I select the location 1
    And I input the location 2
    And I input the location 3
    And I click on save button
    Then I should see the new address on account page

  @EditAddressPCdz
  Scenario: User edit address information
    Given I go to the sign up page by email
    And I input the email information
    And I input password information
    And I input the name information
    And I click on submit button
    And I open add new address page input name info
    And I create new address
    And I click edit button on any address
    And I edit name, phone number information
    Then I should see the new editing name of address

  @DeleteAddress
  Scenario: User delete address on address book
    Given I go to the sign up page by email
    And I input the email information
    And I input password information
    And I input the name information
    And I click on submit button
    And I open add new address page input name info
    And I input the mobile phone number
    And I select the location 1
    And I input the location 2
    And I input the location 3
    And I input address detail
    And I click on save button
    And I open add new address page input name info
    And I create an address to delete
    And I access edit page to delete address
    And I click delete button
    Then I should not see address has deleted on page
