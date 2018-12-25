@Member_PC @smoke

Feature: Member PC Test

  @17417150 @member_regression @member_smoke @signup @no_drz
  Scenario: Normal signup by email
    When I go to the sign up page by email
    And I process to signup user by email on signup by email page
    And I click and hold on slider button
    Then I should see the user info is correctly displayed on account page

  @18433990_lzd @member_regression @member_smoke @signup @no_drz
  Scenario: Receive Register success email
    When I go to the sign up page by email
    And I process to signup user by email on signup by email page
    And I click and hold on slider button
    And I go to the inbox of current email
    Then I should see the receive register success email

  @17417150 @member_regression @member_smoke @signup @no_lzd
  Scenario: Normal signup by email
    When I go to the sign up page by email
    And I process to signup user by email on signup by email page
    And I click on submit button
    Then I should see the user info is correctly displayed on account page

  @18433990_drz @member_regression @member_smoke @signup @no_lzd
  Scenario: Receive Register success email
    When I go to the sign up page by email
    And I process to signup user by email on signup by email page
    And I click on submit button
    And I go to the inbox of current email
    Then I should see the receive register success email

  @17417151 @member_regression @member_smoke @signup @no_drz @no_lzd
  Scenario: Signup by email
    Given I sign up by api with email
    And I go to the account page
    Then I should see the user info is correctly displayed on account page

  @17417173 @member_regression @member_smoke @login @no_lzd
  Scenario: Normal login by email
    When I go to the login by email page
    And I login account information on login by email page
    Then I should see the user info is correctly displayed on account page

  @17560793 @member_regression @member_smoke @login
  Scenario: Login by phone
    Given I login by api with phone
    Then I should see the account is verified

  @18053135 @member_regression @member_smoke @login
  Scenario: Login by email
    Given I login by api with email
    Then I should see the user info is correctly displayed on account page

  @17417183 @member_regression @member_smoke @login @no_lzd
  Scenario: Normal login by phone
    When I go to the login by email page
    And I login account information by mobile phone on login by email page
    Then I should see the account is verified

  @17480509 @member_regression @member_smoke @no_lzd
  Scenario: User can edit name information
    When I sign up by api with email
    And I go to the account page
    And I go to edit profile page and edit name info
    And I click on save changes button
    Then I go back account page with new name

  @17417198 @member_regression @member_smoke
  Scenario: User can logout successfully
    And I login by api with email
    And I go to the account page
    And I click on logout account
    Then I logout successful

  @17480530 @member_regression @member_smoke @no_lzd
  Scenario: User can change password successfully
    Given I sign up by api with email
    And I go to change password page
    And I click on logout account
    And I re-login by api with new password
    Then I should see the user info is correctly displayed on account page

  @17480524 @member_regression @member_smoke
  Scenario: User can config newsletter
    And I login by api with email
    And I go to the account page
    And I click on newsletter button to turn on or off config
    Then I should see the texts on configuration Newsletter difference before configuration

  @17740305 @member_regression @member_smoke
  Scenario: User can reset password successfully
    When I go to the login by email page
    And I click reset password on login page
    And I go to forgot password page
    And I submit email to reset password process
    And I reset password by email verification code
    And I get the email verification code from the inbox of current email
    And I confirm code on Verify Email page
    And I process reset password on reset password page
    Then I should see the user info is correctly displayed on account page

  @18217646 @member_regression @member_smoke @no_lzd
  Scenario: User can change email successfully
    Given I sign up by api with email
    And I go to personal profile page to change email
    And I change email by email verification code
    And I get the email verification code from the inbox of current email
    And I confirm code on Verify Email page
    And I input new mail and send code
    And I get the email verification code from the inbox of current email
    And I confirm code on Verify Email page
    Then I should see the new mail on personal profile page
    And I re-login by new email
    Then I should see the user info is correctly displayed on account page