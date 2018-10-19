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

  @MsiteSignupsms
  Scenario: Guest signup new account by sms
    When I go to signup by sms page on Msite
    And I input the phone number on Msite
    And I click sendcode button on Msite
    And I input the smscode on Msite
    And I click continue button
    And I jumps to email info page
    And I will input the name on form
    And I will input the email on form
    And I will input the password on form
    And I will click submit on form
    Then I should see account page
