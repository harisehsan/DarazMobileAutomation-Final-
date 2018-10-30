@Address_PC

Feature: Address on PC
  @addaddresspcdz
  Scenario: As user add new address on PC
    Given I go to the sign up page by email
    And I input the email information
    And I input the password and repassword information
    And I input the name information
    And I click on submit button
    And I open add new address page and input name info
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
    And I input the password and repassword information
    And I input the name information
    And I click on submit button
    And I open add new address page and input name info
    And I input the mobile phone number
    And I input floor/unit number address detail
    And I select the location 1
    And I input the location 2
    And I input the location 3
    And I click on save button
    Then I should see the new address on account page
