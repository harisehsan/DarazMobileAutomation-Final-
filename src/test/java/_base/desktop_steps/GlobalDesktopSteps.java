package _base.desktop_steps;

import base.BaseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import global.Global;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Member_Login_Page;

public class GlobalDesktopSteps extends BaseSteps {

    @Given("I go to the login page, input the email information")
    public void loginEmail() throws Throwable {
        String email = Global.config.getString("member.account.mail");
        visit(Member_Login_Page.class);
        on(Member_Login_Page.class).loginEmail(email);
    }

    @Given("I go to the login page, input the mobilephone information")
    public void loginMobilePhone() throws Throwable {
        String mobilephone = Global.config.getString("member.phone_number_login");
        visit(Member_Login_Page.class);
        on(Member_Login_Page.class).loginEmail(mobilephone);
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

    @And("I login with new password")
    public void loginNewPass() throws Throwable {
        String new_pass = Global.config.getString("member.account.new_pass");
        on(Member_Login_Page.class).loginEmail((String)Global.map.get("email_random"),new_pass);
    }

    @Then("^I go back account without error message")
    public void hasNewsLetter() throws Throwable {
        on(Account_Page.class).hasNewsLetter();

    }
}
