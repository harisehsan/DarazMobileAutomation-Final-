package step_definitions.account;

import java.lang.String;

import cucumber.api.java.en.*;
import global.Global;
import pages.desktop.account.Account_Page;
import pages.desktop.account.Member_Login_Page;
import step_definitions.BaseSteps;

public class MemberLoginSteps extends BaseSteps {

    @Given("I go to the login page and input the email information")
    public void loginEmail() throws Throwable {
        String email = Global.config.getString("member.account.mail");
        visit(Member_Login_Page.class);
        on(Member_Login_Page.class).loginEmail(email);
    }

    @And("^I input the password information")
    public void loginPass() throws Throwable {
        String password = Global.config.getString("member.account.pass");
        on(Member_Login_Page.class).loginPass(password);
    }

    @And("^I click submit button")
    public void submitButton() throws Throwable {
        on(Member_Login_Page.class).submitButton();
    }


    @Then("^I should see account page$")
    public void hasName() throws Throwable {
        visit(Member_Login_Page.class);
        on(Account_Page.class).hasName("Manage My Account");
    }
}
