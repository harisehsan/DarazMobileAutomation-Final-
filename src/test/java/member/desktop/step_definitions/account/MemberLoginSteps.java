package member.desktop.step_definitions.account;

import java.lang.String;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Member_Login_Page;

public class MemberLoginSteps extends BaseSteps {

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

    @And("^I click on newsletter button to turn on or off config")
    public void setNewsLetter() throws Throwable {
        on(Account_Page.class).setNewsLetter();

    }


    @Then("^I go back account without error message")
    public void hasNewsLetter() throws Throwable {
        on(Account_Page.class).hasNewsLetter();

    }

}
