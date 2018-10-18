@Member_Msite

Feature: Member Msite Test

  @MsiteSignupemail
  Scenario: Guest signup new account by email
    When I go to Msite and open the sign up page by email
    And I input the name on form
    And I input the email on form
    And I input the password on form
    And I click submit on form
    Then I should see account page