@Member
    
Feature: Member Test
    @Signup @email
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




