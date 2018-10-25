package step_definitions.desktop.account;
import cucumber.api.java.en.*;
import global.Global;
import pages.desktop.account.Account_Page;
import pages.desktop.account.SignUp_Page;
import step_definitions.BaseSteps;
import helper.RandomeHelper;

public class MemberSignupSteps extends BaseSteps {

    @Given("^I go to the sign up page by email")
    public void signUpByEmail() throws Throwable {
        visit(SignUp_Page.class);
        Global.browser.refresh();
        on(SignUp_Page.class).signemail();
    }

    @Given("^I input the email information")
    public void inputEmail() throws Throwable {
        on(SignUp_Page.class).emailtextfiel(RandomeHelper.generateEmail() + "@hotmail.com");
    }

    @And("^I input the password and repassword information")
    public void passwordfield() throws Throwable {
        on(SignUp_Page.class).passwordfield("q12345");
    }

    @And("^I input the name information")
    public void namefield() throws Throwable {
        on(SignUp_Page.class).namefield("QA testing by Auto");
    }

    @And("^I click on submit button")
    public void submit() throws Throwable {
        on(SignUp_Page.class).submitButton();
    }


    @Then("^I should see the account page$")
    public void hasName() {
        on(Account_Page.class).untilLoaded();
        on(Account_Page.class).hasName("QA testing by Auto");
    }
}