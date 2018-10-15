package step_definitions.account;
import java.lang.String;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.desktop.account.Account_Page;
import pages.desktop.account.SignUp_Page;
import random_email.GetRandomEmail;
import step_definitions.BaseSteps;

public class MemberSignupSteps extends BaseSteps {

    @Given("^I go to the sign up page by email")
    public void signUpByEmail() throws Throwable {
        visit(SignUp_Page.class);
        on(SignUp_Page.class).signemail();
    }

    @Given("^I go to the sign up page and input the email information")
    public void inputEmail() throws Throwable {
        on(SignUp_Page.class).emailtextfiel(new GetRandomEmail().getEmailString() + "@hotmail.com");
    }

    @And("^I input the password and repassword information")
    public void passwordfield() throws Throwable {
        on(SignUp_Page.class).passwordfield("q12345");
    }

    @And("^I input the name information then i click submit button")
    public void namefield() throws Throwable {
        on(SignUp_Page.class).namefield("QA testing by Auto");
        on(Account_Page.class).untilLoaded();
    }


    @Then("^I should see the account page$")
    public void hasName() throws Throwable {
        visit(Account_Page.class);
        on(Account_Page.class).hasName("QA testing by Auto");
    }
}