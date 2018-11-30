package member.desktop.step_definitions.account;

import java.lang.String;
import cucumber.api.java.en.*;
import global.Global;
import member.desktop.pages.account.*;
import base.BaseSteps;
import org.testng.Assert;

/**
 * Created by admin.son.ton on 1/25/18.
 */
public class AccountSteps extends BaseSteps{

    @Given("^I login from Account Page by account: \"([^\"]*)\", password: \"([^\"]*)\"")
    public void loginFromAccPage(String user, String pass) throws Throwable {
        visit(Login_Page.class);
        on(Login_Page.class).logIn(user, pass);
        on(Account_Page.class).untilLoaded();
    }

    @Given("^I login from Account Page")
    public void loginFromAccPageWithConfigAccount() throws Throwable {
        String user = Global.config.getString("member.account.mail_test");
        String pass = Global.config.getString("member.pass");
        visit(Login_Page.class);
        on(Login_Page.class).logIn(user, pass);
        on(Account_Page.class).untilLoaded();
    }

    @And("^I click on newsletter button to turn on or off config")
    public void setNewsLetter() throws Throwable {
        on(Account_Page.class).setNewsLetter();
        String afterConfig = on(Account_Page.class).hasNewsLetter();
        Global.map.put("after_config", afterConfig);
    }

    @And("^I click on logout account")
    public void logOut() throws Throwable {
        on(Account_Page.class).logOut();
    }

    @Then("^I logout successful")
    public void hasID() throws Throwable {
        Assert.assertTrue(on(Member_Login_Page.class).hasID(),"Checking user should be stay in login page");
    }

    @Then("^I should see the account page$")
    public void hasEmailOnAccountPage() {
        on(Account_Page.class).untilLoaded();
        String currentEmail = on(Account_Page.class).hasEmail();
        String expectEmail = (String) Global.map.get("email_random");
        String pass = Global.config.getString("member.pass");
        Assert.assertEquals(currentEmail, expectEmail, "Comparing email is using signup/login should be same with email display on my dashbogitard");
        on(Account_Page.class).allureMailUrlPass(pass);
    }

    @Then("^I should see the email for reset on account page$")
    public void hasEmailReset() {
        on(Account_Page.class).untilLoaded();
        String currentEmail = on(Account_Page.class).hasEmail();
        String expectEmail = Global.config.getString("member.mail_for_reset");
        String passWord = (String) Global.map.get("new_reset_pass");
        Assert.assertEquals(currentEmail, expectEmail, "Comparing email is using signup/login should be same with email display on my dashboard");
        on(Account_Page.class).allureMailUrlPass(passWord);
    }

    @Then("^I should login success with new password")
    public void hasEmail() {
        on(Account_Page.class).untilLoaded();
        Global.browser.refresh();
        String currentEmail = on(Account_Page.class).hasEmail();
        String passWord = Global.config.getString("member.account.new_pass");
        String expectEmail = (String) Global.map.get("email_random");
        Assert.assertEquals(currentEmail, expectEmail, "Comparing email is using signup/login should be same with email display on my dashboard");
        on(Account_Page.class).allureMailUrlPass(passWord);
    }

    @And("^I should see the account is verified")
    public void isVerified() throws Throwable {
        Assert.assertTrue(on(Account_Page.class).isVerified(), "Checking is verified icon should be display if user has updated mobile phone");
        String mobilephone = Global.config.getString("member.phone_number_login");
        String passWord = (String) Global.map.get("new_reset_pass");
        on(Account_Page.class).allureMailUrlPass(passWord);
        on(Account_Page.class).allureMobilePhone(mobilephone);
    }

    @Then("^I should see the logged account page")
    public void hasEmailLogged() {
        on(Account_Page.class).untilLoaded();
        Global.browser.refresh();
        String mobilephone = Global.config.getString("member.phone_number_login");
        String currentEmail = on(Account_Page.class).hasEmail();
        String pass = Global.config.getString("member.pass");
        String expectEmail = Global.config.getString("member.account.mail_test");
        Assert.assertEquals(currentEmail, expectEmail, "Comparing email is using signup/login should be same with email display on my dashboard");
        on(Account_Page.class).allureMailUrlPass(pass);
        on(Account_Page.class).allureMobilePhone(mobilephone);
    }
}