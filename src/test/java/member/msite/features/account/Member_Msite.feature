@Member_Msite @911 @smoke

Feature: Member Msite Test

  @17417211 @member_regression @member_smoke @signup @no_lzd
  Scenario: Normal signup by email
    When On Msite I go to the sign up page by email
    And I input all information to signup by email page
    Then On Msite I should see the user info is correctly displayed on account page

  @17417223 @member_regression @member_smoke @login
  Scenario: Normal login by email
    When On Msite I go to login by email
    And On Msite I input account information to login by email page
    Then On Msite I should see the user info is correctly displayed on account page

  @17417234 @member_regression @member_smoke
  Scenario: User can logout successfully
    When On Msite I go to login by email
    And On Msite I input account information to login by email page
    And On Msite I should see the user info is correctly displayed on account page
    And I go to setting page
    And I progress logout account on account setting page
    Then I should logout success

  @17480573 @member_regression @member_smoke @no_lzd
  Scenario: User can change password successfully
    When On Msite I go to the sign up page by email
    And I input all information to signup by email page
    And On Msite I should see the user info is correctly displayed on account page
    And I go to setting page
    And I click to change password button
    And I input all information to change pass
    And I go to setting page
    And I progress logout account on account setting page
    And I should logout success
    And On Msite I input email just signned up
    Then I should stayed in setting account page

  @17480565 @member_regression @member_smoke
  Scenario: User can config newsletter
    When On Msite I go to login by email
    And On Msite I input account information to login by email page
    And On Msite I should see the user info is correctly displayed on account page
    And I get result of newsletter config before trigger
    And I trigger on newsletter config
    Then I should see the result of current newsletter config changed

  @17740312 @member_regression @member_smoke
  Scenario: User can reset password successfully
    Given On Msite I go to login by email
    When On Msite I access to reset password
    And I progress to forgot password
    And I choose Verify through Email button
    And I get the email verification code from the inbox of current email
    And On Msite i confirm code on Verify Email page
    And I input the new password for reset
    Then I should see the success reset password on reset page

  @18235358 @member_regression @member_smoke @no_lzd
  Scenario: User can change email successfully on Msite
    When On Msite I go to the sign up page by email
    And I input all information to signup by email page
    And On Msite I should see the user info is correctly displayed on account page
    And I go to account info page
    And On Msite I change email by email verification code
    And On Msite I get the email verification code from the inbox of current email
    And On Msite i confirm code on Verify Email page
    And On Msite I input new mail and send code
    And I get the email verification code from the inbox of current email
    And On Msite i confirm code on Verify Email page
    Then I should see the new mail on account info page
    And On Msite i re-login by new email
    Then I should stayed in setting account page