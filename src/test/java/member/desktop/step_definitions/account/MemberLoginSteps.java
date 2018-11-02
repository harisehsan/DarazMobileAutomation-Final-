package member.desktop.step_definitions.account;

import java.lang.String;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import member.desktop.pages.account.Member_Login_Page;

public class MemberLoginSteps extends BaseSteps {

    @Given("I go to the login page and input the email information")
    public void loginEmail() throws Throwable {
        String email = Global.config.getString("member.account.mail");
        visit(Member_Login_Page.class);
        on(Member_Login_Page.class).loginEmail(email);
    }

    @Given("I go to the login page and input the mobilephone information")
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
        on(Member_Login_Page.class).loginNewPass((String)Global.map.get("email_random"),new_pass);
    }

}
