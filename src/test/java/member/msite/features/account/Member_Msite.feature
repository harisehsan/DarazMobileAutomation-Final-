@Member_Msite @911 @smoke

Feature: Member Msite Test

  @17417211 @member_regression @member_smoke @signup @no_lzd
  Scenario: Normal signup by email
    When I go to the sign up on Msite page by email
    And I input all information to signup by email page
    Then On Msite I should see the user info is correctly displayed on account page

  @18375556 @member_regression @member_smoke @signup @no_drz @no_lzd
  Scenario: Normal signup by email
    When I go to the sign up on Msite page by email
    And I input all information to signup email by slider button
    Then On Msite I should see the user info is correctly displayed on account page

  @17417223 @member_regression @member_smoke @login
  Scenario: Normal login by email
    When I go to login by email on Msite
    And I input account information to login by email Msite page
    Then On Msite I should see the user info is correctly displayed on account page

  @17417234 @member_regression @member_smoke
  Scenario: User can logout successfully
    When I go to login by email on Msite
    And I input account information to login by email Msite page
    And On Msite I should see the user info is correctly displayed on account page
    And I go to setting page
    And I progress logout account on account setting page
    Then I should logout success

  @17480573 @member_regression @member_smoke @no_lzd
  Scenario: User can change password successfully
    When I go to the sign up on Msite page by email
    And I input all information to signup by email page
    And On Msite I should see the user info is correctly displayed on account page
    And I go to setting page
    And I click to change password button
    And I input all information to change pass
    And I go to setting page
    And I progress logout account on account setting page
    And I should logout success
    And I input email just signned up on Msite
    Then I should stayed in setting account page

  @17480565 @member_regression @member_smoke
  Scenario: User can config newsletter
    When I go to login by email on Msite
    And I input account information to login by email Msite page
    And On Msite I should see the user info is correctly displayed on account page
    And I get result of newsletter config before trigger
    And I trigger on newsletter config
    Then I should see the result of current newsletter config changed

  @17740312 @member_regression @member_smoke
  Scenario: User can reset password successfully
    Given I go to login by email on Msite
    When I access to reset password on Msite
    And I progress to forgot password
    And I choose Verify through Email button
    And I go to the inbox mail in Msite on new tab
    And I open email on Msite to get sms code
    And I on Msite go back the old tab
    And I input the smsCode to reset password on msite
    And I input the new password for reset
    Then I should see the success reset password on reset page


