@Member_Msite @911

Feature: Member Msite Test

  @17417211 @member_regression @member_smoke @no_lzd
  Scenario: Guest signup new account by email
    When I go to the sign up on Msite page by email
    And I input all information on signup by email page
    And I click submit on form
    Then I should see the name of user in account title

  @17417218 @member_regression @member_smoke @no_lzd @no_drz_live
  Scenario: Guest signup new account by sms
    When I go to signup by sms page on Msite
    And I input the phone number on Msite
    And I click sendcode button on Msite
    And I input the smscode on Msite
    And I click continue button
    And I jumps to email info page
    And I input all information on signup by email page
    And I will click submit on form
    Then I should see the name of user in account title

  @17417223 @member_regression @member_smoke @no_lzd
  Scenario: User login account by email
    When I go to login by email on Msite
    And I input account information on login by email Msite page
    And I click login button on Msite
    Then I should stayed in account page

  @17417228 @member_regression @member_smoke @no_lzd @no_drz_live
  Scenario: User login account by SMS
    When I go to login by SMS on Msite
    And I input phonenumber info on Msite
    And I click the info sendcode button on Msite
    And I input code info on Msite
    And I click on loginbutton on Msite
    Then I should stayed in account page

  @17417234 @member_regression @member_smoke @no_lzd_live
  Scenario: User Logout account on Msite
    When I go to login by email on Msite
    And I login by api with email and password
    And I should stayed in account page
    And I go to setting page
    And I progress logout account on account setting page
    Then I should logout success

  @17480573 @member_regression @member_smoke @no_lzd
  Scenario: User change password and login again with new password on Msite
    When I go to the sign up on Msite page by email
    And I sign up by api
    And I should see the name of user in account title
    And I go to setting page
    And I click to change password button
    And I go to change pass page on Msite
    And I input all information to change pass
    And I click save password button
    And I click got it button on popup
    And I go to setting page
    And I progress logout account on account setting page
    And I should logout success
    And I go to login by email on Msite
    And I input email just signned up on Msite
    And I input new password info on Msite
    And I click login button on Msite
    Then I should stayed in account page

  @17480565 @member_regression @member_smoke @no_lzd_live @no_staging_sg @no_staging_th
  Scenario: User login and try to config newsletter
    When I go to login by email on Msite
    And I login by api with email and password
    And I should stayed in account page
    And I get result of newsletter config before trigger
    And I trigger on newsletter config
    Then I should see the result of current newsletter config changed