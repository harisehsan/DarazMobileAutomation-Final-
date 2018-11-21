@Address_Msite

Feature: Address Msite test

  @MsiteAddNewAddess @911
  Scenario: User add new address on Msite
    When I go to Msite and open the sign up page by email
    And I input the name on form
    And I input the email on form
    And I input the password on form
    And I click submit on form
    And I should see account page
    And I access to address page
    And I input address information
    And I click save address button
    Then I should see the address on address page
