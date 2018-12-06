package member.desktop.step_definitions.account;

import java.lang.String;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import member.desktop.pages.account.*;
import org.testng.Assert;

public class MemberLoginSteps extends BaseSteps {

    @When("^I go to the login by email page")
    public void accessLoginPage(){
        visit(Member_Login_Page.class);
    }

    @And("^I login account information on login by email page")
    public void loginByEmail()throws Throwable {
        String email = Global.config.getString("member.account.mail");
        String pass = Global.config.getString("member.account.pass");
        on(Member_Login_Page.class).loginEmailPass(email,pass);
    }

    @And("^I login account information by mobile phone on login by email page")
    public void loginByPhoneNumber()throws Throwable {
        String mobilephone = Global.config.getString("member.phone_number_login");
        String pass = Global.config.getString("member.account.pass");
        on(Member_Login_Page.class).loginEmailPass(mobilephone,pass);
    }

    @And("I login with new password")
    public void loginNewPass() throws Throwable {
        String changed_pass = Global.config.getString("member.account.changed_pass");
        on(Member_Login_Page.class).loginEmailPass((String)Global.map.get("email_random"),changed_pass);
    }

    @And("^I go to the account page")
    public void goToAccountPage() throws Throwable {
        String beforeConfig = on(Account_Page.class).hasNewsLetter();
        Global.map.put("before_config",beforeConfig);
    }

    @And("^I login email with new password after reset")
    public void loginWithResetPass() throws Throwable {
        String emailForReset = Global.config.getString("member.mail_for_reset");
        on(Member_Login_Page.class).loginEmailPass(emailForReset, (String) Global.map.get("new_reset_pass"));
    }

    @Then("^I should see the texts on configuration Newsletter difference before configuration")
    public void hasNewsLetter() throws Throwable {
        Global.browser.refresh();
        String beforeConfigNewsletter = (String) Global.map.get("before_config");
        String afterConfigNewsletter = (String) Global.map.get("after_config");
        Assert.assertNotEquals(beforeConfigNewsletter,afterConfigNewsletter, "Comparing the texts Subscribe/Unsubscribe to our Newsletter before and after configuration should be different");
        on(Account_Page.class).allureUrl();
        on(Account_Page.class).allureConfigNewsletter(beforeConfigNewsletter,afterConfigNewsletter);
    }

    @And("^I re-login by api with new password$")
    public void loginByApiNewPass(String pass){
        visit(Login_Page.class);
        String emailLogin = (String) Global.map.get("email_random");
        String newPass = (String) Global.map.get("changed_pass");
        on(Login_Page.class).loginApi(emailLogin,newPass);
        Global.browser.refresh();
    }
}