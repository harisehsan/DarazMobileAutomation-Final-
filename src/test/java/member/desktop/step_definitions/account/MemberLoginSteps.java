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
        String email = Global.getConfig().getString("member.account.mail");
        Global.getMap().put("current_mail",email);
        String pass = Global.getConfig().getString("member.account.pass");
        Global.getMap().put("current_pass",pass);
        on(Member_Login_Page.class).loginEmailPass(email,pass);
    }

    @And("^I login account information by mobile phone on login by email page")
    public void loginByPhoneNumber()throws Throwable {
        String mobilephone = Global.getConfig().getString("member.registered_phone");
        String pass = Global.getConfig().getString("member.account.pass");
        on(Member_Login_Page.class).loginEmailPass(mobilephone,pass);
    }

    @And("I login with new password")
    public void loginNewPass() throws Throwable {
        String changed_pass = Global.getConfig().getString("member.account.changed_pass");
        on(Member_Login_Page.class).loginEmailPass(Global.getMap().get("current_mail").toString(), changed_pass);
    }

    @And("^I go to the account page")
    public void goToAccountPage() throws Throwable {
        String beforeConfig = on(Account_Page.class).hasNewsLetter();
        Global.getMap().put("before_config",beforeConfig);
    }

    @And("^I login email with new password after reset")
    public void loginWithResetPass() throws Throwable {
        String emailForReset = Global.getConfig().getString("member.reset_password_mail");
        on(Member_Login_Page.class).loginEmailPass(emailForReset, (String) Global.getMap().get("current_pass"));
    }

    @Then("^I should see the texts on configuration Newsletter difference before configuration")
    public void hasNewsLetter() throws Throwable {
        Global.getBrowser().refresh();
        String beforeConfigNewsletter = (String) Global.getMap().get("before_config");
        String afterConfigNewsletter = (String) Global.getMap().get("after_config");
        Assert.assertNotEquals(beforeConfigNewsletter,afterConfigNewsletter, "Comparing the texts Subscribe/Unsubscribe to our Newsletter before and after configuration should be different");
        on(Account_Page.class).allureUrl();
        on(Account_Page.class).allureConfigNewsletter(beforeConfigNewsletter,afterConfigNewsletter);
    }

    @And("^I re-login by api with new password")
    public void loginByApiNewPass(){
        visit(Login_Page.class);
        String emailLogin = (String) Global.getMap().get("current_mail");
        String newPass = (String) Global.getMap().get("changed_pass");
        on(Login_Page.class).loginApi(emailLogin,newPass);
        Global.getBrowser().refresh();
    }
}