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

  @MsiteLoginEmail
  Scenario: User login account by email
    When I go to login by email on Msite
    And I input email info on Msite
    And I input password info on Msite
    And I click login button on Msite
    Then I should see account page

  @MsiteLoginSMS
  Scenario: User login account by SMS
    When I go to login by SMS on Msite
    And I input phonenumber info on Msite
    And I click the info sendcode button on Msite
    And I input code info on Msite
    And I click on loginbutton on Msite
    Then I should see account page


  @MsiteLogout
  Scenario: User Logout account on Msite
    When I go to login by email on Msite
    And I input email info on Msite
    And I input password info on Msite
    And I click login button on Msite
    And I should see account page
    And I go to setting page
    And I click Logout button and choose OK button
    Then I should logout success