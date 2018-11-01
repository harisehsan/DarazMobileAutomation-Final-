package member.desktop.step_definitions.account;
import cucumber.api.java.en.*;
import global.Global;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.SignUp_Page;
import base.BaseSteps;
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
        String randomEmail = RandomeHelper.generateEmail();
        on(SignUp_Page.class).emailtextfiel(randomEmail + "@hotmail.com");
        Global.map.put("email_random",randomEmail);
    }

    @And("^I input the password and repassword information")
    public void passwordfield() throws Throwable {
        on(SignUp_Page.class).passwordfield("q12345");
        Global.map.get("email_random");
    }

    @And("^I input the name information")
    public void namefield() throws Throwable {
        on(SignUp_Page.class).namefield("QA testing by Auto");
    }

    @And("^I click on submit button")
    public void submit() throws Throwable {
        on(SignUp_Page.class).submitButton();
    }

    @And("^I click and hold on slider button")
    public void sliderbtn() throws Throwable {
        on(SignUp_Page.class).setSliderbtn();
    }


    @Then("^I should see the account page$")
    public void hasName() {
        on(Account_Page.class).untilLoaded();
        on(Account_Page.class).hasName("QA testing by Auto");
    }
}