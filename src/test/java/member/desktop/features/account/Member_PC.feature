@Member_PC

Feature: Member PC Test

  @17417150 @member_regression @member_smoke @no_lzd
  Scenario: Signup by email
    When I go to the sign up page by email
    And I process to signup user by email on signup by email page
    And I click on submit button
    Then I should see the account page

  @17417151 @member_regression @member_smoke @no_drz
  Scenario: Guest signup email by api
    When I go to the sign up page by smsphone
    And I sign up by api
    Then I should see the account page

  @17417173 @member_regression @member_smoke @no_lzd
  Scenario: User login account by email on login by email page
    When I go to the login by email page
    And I login account information on login by email page
    Then I should see the logged account page

  @17560793 @member_regression @member_smoke
  Scenario: User login account by mobilephone on login by email page
    When I go to the login by email page
    And I login by api with mobile phone and password
    Then I should see the logged account page

  @17417183 @member_regression @member_smoke @no_lzd
  Scenario: User login account by mobilephone on login by email page
    When I go to the login by email page
    And I login account information by mobile phone on login by email page
    Then I should see the logged account page

  @17480509 @member_regression @member_smoke
  Scenario: User edit name information
    When I go to the sign up page by smsphone
    And I sign up by api
    And I go to the account page
    And I go to edit profile page and edit name info
    And I click on save changes button
    Then I go back account page with new name

  @17417198 @member_regression @member_smoke
  Scenario: User login account then logout account
    When I go to the login by email page
    And I login by api with email and password
    And I click on logout account
    Then I logout successful

  @17480530 @member_regression @member_smoke
  Scenario: User change password, login success by new password
    When I go to the sign up page by smsphone
    And I sign up by api
    And I go to change password page
    And I click on logout account
    And I login by api with email and new_pass
    Then I should see the account page

  @17480524 @member_regression @member_smoke
  Scenario: User config newsletter
    When I go to the login by email page
    And I login by api with email and password
    And I go to the account page
    And I click on newsletter button to turn on or off config
    Then I should see the texts on configuration Newsletter difference before configuration

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
    Then I should see the email for reset on account page