@Member_Msite @911

Feature: Member Msite Test

  @17417211 @member_regression @member_smoke @no_lzd
  Scenario: Guest signup new account by email
    When I go to the sign up on Msite page by email
    And I input all information to signup by email page
    Then I should see the name of user in account title

  @17417223 @member_regression @member_smoke @no_lzd
  Scenario: User login account by email
    When I go to login by email on Msite
    And I input account information to login by email Msite page
    Then I should stayed in account page

  @17417234 @member_regression @member_smoke @no_lzd
  Scenario: User Logout account on Msite
    When I go to login by email on Msite
    And I input account information to login by email Msite page
    And I should stayed in account page
    And I go to setting page
    And I progress logout account on account setting page
    Then I should logout success

  @17480573 @member_regression @member_smoke @no_lzd
  Scenario: User change password and login again with new password on Msite
    When I go to the sign up on Msite page by email
    And I input all information to signup by email page
    And I should see the name of user in account title
    And I go to setting page
    And I click to change password button
    And I input all information to change pass
    And I go to setting page
    And I progress logout account on account setting page
    And I should logout success
    And I input email just signned up on Msite
    Then I should stayed in setting account page

  @17480565 @member_regression @member_smoke @no_lzd
  Scenario: User login and try to config newsletter
    When I go to login by email on Msite
    And I input account information to login by email Msite page
    And I should stayed in account page
    And I get result of newsletter config before trigger
    And I trigger on newsletter config
    Then I should see the result of current newsletter config changed