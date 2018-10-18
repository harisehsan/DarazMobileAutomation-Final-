@Member_PC
    
Feature: Member Test
    @Signupemail
    Scenario: Guest signup new account by email
        When I go to the sign up page by email
        And I input the email information
        And I input the password and repassword information
        And I input the name information
        And I click on submit button
        Then I should see the account page


    @Signupsmsphone
        Scenario: Guest signup new account by smsphone
        When I go to the sign up page by smsphone
        And I input the phonenumber
        And I click the sendcode button
        And I input the SMS code information
        And I input password information on signup by sms
        And I input the name information
        And I input the email information
        And On signup by SMS i click submit button
        Then I should see the account page


  @Loginbyemail
    Scenario: User login account by email
        When I go to the login page and input the email information
        And I input the password information
        And I click submit button
        Then I should see the account page


    @Loginbymobilephone
    Scenario: User login account by mobilephone
        When I go to the login page and input the mobilephone information
        And I input the password information
        And I click submit button
        Then I should see the account page


    @Logoutonpc
    Scenario: User login account then logout account on
        When I go to the login page and input the email information
        And I input the password information
        And I click submit button
        And I click on my account menu
        And I click on logout account
        Then I logout successful




