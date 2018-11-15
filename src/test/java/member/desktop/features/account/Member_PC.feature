@Member_PC

Feature: Member PC Test for Daraz project

  @Signupemail @no_lazada_live
  Scenario: Signup by email without slider
    When I go to the sign up page by email
    And I input the email information
    And I input password information
    And I input the name information
    And I click on submit button
    Then I should see the account page

  @Signupemail @no_staging
  Scenario: Guest signup by email with slider
    When I go to the sign up page by email
    And I input the email information
    And I input password information
    And I input the name information
    And I click and hold on slider button
    Then I should see the account page


  @Signupsmsphone @no_lazada_live
  Scenario: Guest signup by smsphone without slider
    When I go to the sign up page by smsphone
    And I input the phonenumber
    And I click the sendcode button
    And I input the SMS code information
    And I input password information on signup by sms
    And I input the name information
    And I input the email information
    And On signup by SMS i click submit button
    Then I should see the account is verified

  @Signupsmsphone @no_staging
  Scenario: Guest signup by smsphone with slider
    When I go to the sign up page by smsphone
    And I input the phonenumber
    And I click the slider button
    And I input the SMS code information
    And I input password information on signup by sms
    And I input the name information
    And I input the email information
    And On signup by SMS i click submit button
    Then I should see the account is verified


  @Loginbyemail
  Scenario: User login account by email
    When I go to the login by email page
    And I login account information on login by email page
    Then I should see the account page


  @Loginbymobilephone @no_lazada_live
  Scenario: User login account by mobilephone
    When I go to the login page, input the mobilephone information
    And I input the password information
    And I click submit button
    Then I should see the account page

  @EditNameinfo @no_lazada_live
  Scenario: User edit name information
    When I go to the sign up page by email
    And I input the email information
    And I input password information
    And I input the name information
    And I click on submit button
    And I should see the account page
    And I go to edit profile page and edit name info
    And I click on savechanges button
    Then I go back account page with new name


  @Logoutonpc
  Scenario: User login account then logout account
    When I go to the login by email page
    And I login account information on login by email page
    And I click on my account menu
    And I click on logout account
    Then I logout successful


  @Changepassword
  Scenario: User change password, login success by new password
    When I go to the sign up page by email
    And I input the email information
    And I input password information
    And I input the name information
    And I click on submit button
    And I go to change password page
    And I click on my account menu
    And I click on logout account
    And I login with new password
    Then I should see the account page

  @NewsletterConfig
  Scenario: User config newsletter
    When I go to the login by email page
    And I login account information on login by email page
    And I click on newsletter button to turn on or off config
    Then I go back account without error message

  @17740305 @member_regression @member_smoke
  Scenario: User reset password function
    When I go to the login by email page
    And I click reset password on login page
    And I go to forgot password page
    And I submit email to reset password process
    And I click Verify through Email button
    And I process to get smscode on verify by email page
    And I go to the inbox mail on new tab
    And I open email to get sms code
    And I go back the old tab
    And I input the smscode on verifyemail page from old tab
    And I click Verify Code button on verifyemail page
    And I process reset password on reset password page
    Then I should see the account page






