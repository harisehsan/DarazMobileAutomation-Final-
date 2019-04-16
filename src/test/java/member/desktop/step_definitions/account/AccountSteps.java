package member.desktop.step_definitions.account;

import java.lang.String;
import cucumber.api.java.en.*;
import global.Global;
import helper.RandomHelper;
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
        String user = Global.getConfig().getString("member.account.mail");
        String pass = Global.getConfig().getString("member.account.pass");
        visit(Login_Page.class);
        on(Login_Page.class).logIn(user, pass);
        on(Account_Page.class).untilLoaded();
    }

    @And("^I click on newsletter button to turn on or off config")
    public void setNewsLetter() throws Throwable {
        on(Account_Page.class).setNewsLetter();
        String afterConfig = on(Account_Page.class).hasNewsLetter();
        Global.getMap().put("after_config", afterConfig);
    }

    @And("^I click on logout account")
    public void logOut() throws Throwable {
        on(Account_Page.class).logOut();
    }

    @And("^I go to change password page")
    public void changePass() throws Throwable {
        visit(Member_Change_Email_Pass_Page.class);
        String current_pass = Global.getConfig().getString("member.account.pass");
        String changedPass = RandomHelper.randomAlphabetString(5) + RandomHelper.randomNumber(5);
        Global.getMap().put("changed_pass",changedPass);
        on(Member_Change_Email_Pass_Page.class).resetPass(current_pass,changedPass);
    }

    @Then("^I logout successful")
    public void hasID() throws Throwable {
        Assert.assertTrue(on(Member_Login_Page.class).hasID(),"Checking user should be stay in login page");
        on(Account_Page.class).allureUrl();
    }

    @Then("^I should see the email for reset on account page$")
    public void hasEmailReset() {
        on(Account_Page.class).untilLoaded();
        String currentEmail = on(Account_Page.class).hasEmail();
        String expectEmail = Global.getConfig().getString("member.reset_password_mail");
        String passWord = (String) Global.getMap().get("current_pass");
        Assert.assertEquals(currentEmail, expectEmail, "Comparing email is using signup/login should be same with email display on my dashboard");
        on(Account_Page.class).allureMailUrlPass(passWord);
    }

    @And("^I should see the account is verified")
    public void isVerified() throws Throwable {
        Assert.assertTrue(on(Account_Page.class).isVerified(), "Checking is verified icon should be display if user has updated mobile phone");
        String mobilephone = Global.getConfig().getString("member.registered_phone");
        String pass = Global.getConfig().getString("member.account.pass");
        on(Account_Page.class).allureMailUrlPass(pass);
        on(Account_Page.class).allureMobilePhone(mobilephone);
    }

    @Then("^I should see mail after changing logging in successfully")
    public void hasNewEmailAfterChanging() throws Throwable {
        Assert.assertTrue(on(Account_Page.class).isEmail(),"Checking user should login new email successfully");
        on(Account_Page.class).allureMailUrlPass(Global.getConfig().getString("member.account.pass"));
    }

    @Then("^I should see the user info is correctly displayed on account page")
    public void isCorrectUserInfo() throws Throwable {
        on(Account_Page.class).untilLoaded();
        Global.getBrowser().refresh();
        String pass = (String) Global.getMap().get("current_pass");
        String expectEmail = (String) Global.getMap().get("current_mail");
        String currentEmail = on(Account_Page.class).hasEmail();
        Assert.assertEquals(currentEmail, expectEmail, "Comparing email is using signup/login should be same with email display on my dashboard");
        on(Account_Page.class).allureMailUrlPass(pass);
    }

    @Then("^I should see the receive register success email")
    public void hasSuccessRegistrationEmail() throws Throwable{
        Assert.assertTrue(on(Member_Mailinator_Page.class).hasSuccessEmail(),"Checking email registration was success should send to inbox mail");
    }
}