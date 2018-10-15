@Member
    
Feature: Member Test
    @Signupemail
    Scenario: Guest signup new account by email
        When I go to the sign up page by email
        And I go to the sign up page and input the email information
        And I input the password and repassword information
        And I input the name information then i click submit button
        Then I should see the account page


#    @Signup @smsphone
#        Scenario: Guest signup new account by smsphone
#        When I go to the sign up page by smsphone
#        And

    @Loginbyemail
    Scenario: User login account by email
        When I go to the login page and input the email information
        And I input the password information
        And I click submit button
        Then I should see account page




