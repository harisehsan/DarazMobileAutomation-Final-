@Member
    
Feature: Member Test
    @Signup
    Scenario: Guest signup new account
        When I go to the sign up page and input the email information
        And I input the password and repassword information
        And I input the name information then i click submit button
        Then I should see the account page
