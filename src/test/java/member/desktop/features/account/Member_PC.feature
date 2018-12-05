@Member_PC

Feature: Member PC Test

  @17417150 @member_regression @member_smoke @signup @no_lzd
  Scenario: Normal signup by email
    When I go to the sign up page by email
    And I process to signup user by email on signup by email page
    And I click on submit button
    Then I should see the account page

  @17417151 @member_regression @member_smoke @signup @no_drz @no_lzd
  Scenario: Signup by email
    When I go to the sign up page by smsphone
    And I sign up by api
    Then I should see the account page

  @17417173 @member_regression @member_smoke @login @no_lzd
  Scenario: Normal login by email
    When I go to the login by email page
    And I login account information on login by email page
    Then I should see the logged account page

  @17560793 @member_regression @member_smoke @login
  Scenario: Login by phone
    When I go to the login by email page
    And I login by api with mobile phone and password
    Then I should see the account is verified

  @18053135 @member_regression @member_smoke @login
  Scenario: Login by email
    When I go to the login by email page
    And I login by api with email and password
    Then I should see the logged account page

  @17417183 @member_regression @member_smoke @login @no_lzd
  Scenario: Normal login by phone
    When I go to the login by email page
    And I login account information by mobile phone on login by email page
    Then I should see the account is verified

  @17480509 @member_regression @member_smoke @no_lzd
  Scenario: User can edit name information
    When I go to the login by email page
    And I sign up by api
    And I go to the account page
    And I go to edit profile page and edit name info
    And I click on save changes button
    Then I go back account page with new name

  @17417198 @member_regression @member_smoke
  Scenario: User can logout successfully
    When I go to the login by email page
    And I login by api with email and password
    And I go to the account page
    And I click on logout account
    Then I logout successful

  @17480530 @member_regression @member_smoke @no_lzd
  Scenario: User can change password successfully
    When I go to the sign up page by smsphone
    And I sign up by api
    And I go to change password page
    And I click on logout account
    And I login by api with old email and changed_pass
    Then I should login success with new password

  @17480524 @member_regression @member_smoke
  Scenario: User can config newsletter
    When I go to the login by email page
    And I login by api with email and password
    And I go to the account page
    And I click on newsletter button to turn on or off config
    Then I should see the texts on configuration Newsletter difference before configuration

  @17740305 @member_regression @member_smoke
  Scenario: User can reset password successfully
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
    Then I should see the email for reset on account page

    @18090215 @member_regression @member_smoke
    Scenario: User can change email successfully
      Given I login account by before changing email
#      Given I sign up by api
      When I progress to send sms code for mail_before_change
      And I access the inbox of mail_before_change to get sms code
      And I confirm sms code on Verify Email page
      And I input mail_after_change information to send code
      And I access the inbox of mail_after_change to get sms code
      And I confirm sms code on Verify Email page
      Then I should see the mail_after_change info on account page
      And I progress to login by mail_after_change
      Then I should see mail after changing logging in successfully
      When I progress to send sms code for mail_after_change
      And I access the inbox of mail_after_change to get sms code
      And I confirm sms code on Verify Email page
      And I input mail_before_change information to send code
      And I access the inbox of mail_before_change to get sms code
      And I confirm sms code on Verify Email page
      Then I should see the mail_before_change info on account page


