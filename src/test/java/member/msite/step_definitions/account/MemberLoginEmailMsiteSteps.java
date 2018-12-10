package member.msite.step_definitions.account;

import cucumber.api.java.en.*;
import global.Global;
import helper.RandomHelper;
import member.msite.pages.account.Member_AccountSetting_Msite_Page;
import member.msite.pages.account.Member_Account_Msite_Page;
import member.msite.pages.account.Member_Loginemail_Msite_Page;
import base.BaseSteps;
import org.testng.Assert;

public class MemberLoginEmailMsiteSteps extends BaseSteps {

    @Given("^I go to login by email on Msite")
    public void openLogin() throws Throwable {
        visit(Member_Loginemail_Msite_Page.class);
    }

    @And("^I input email just signned up on Msite")
    public void inputEmailSignUp() throws Throwable {
        String changed_pass = RandomHelper.randomAlphaNumericString(6);
        Global.map.put("changed_pass", changed_pass);
        on(Member_Loginemail_Msite_Page.class).inputEmail((String) Global.map.get("current_mail"));
        on(Member_Loginemail_Msite_Page.class).inputPass((String) Global.map.get("changed_pass"));
        on(Member_Loginemail_Msite_Page.class).clickLoginButton();
    }

    @And("^I input account information to login by email Msite page")
    public void logInByEmailMsite() throws Throwable {
        String email = Global.config.getString("member.account.mail");
        Global.map.put("current_mail", email);
        on(Member_Loginemail_Msite_Page.class).inputEmail(email);
        String pass = Global.config.getString("member.account.pass");
        Global.map.put("current_pass", pass);
        on(Member_Loginemail_Msite_Page.class).inputPass(pass);
        on(Member_Loginemail_Msite_Page.class).clickLoginButton();
    }

    @And("^I go to setting page")
    public void settingOpen() throws Throwable {
        visit(Member_AccountSetting_Msite_Page.class);
    }

    @And("I progress logout account on account setting page")
    public void logOutAction() throws Throwable {
        on(Member_AccountSetting_Msite_Page.class).logOut();
        on(Member_AccountSetting_Msite_Page.class).setOkButton();
    }

//    @Then("^I should stayed in account page")
//    public void hasStayOnAccountPage(){
//        Assert.assertTrue(on(Member_Account_Msite_Page.class).hasAccountTittle(),"Checking user should be stayed in account page after logging in success");
//        String email = (String) Global.map.get("email_login");
//        String password = (String) Global.map.get("password_login");
//        on(Member_Account_Msite_Page.class).allureMailUrlPassMsite(email, password);
//    }

    @Then("^I should stayed in setting account page")
    public void hasStayOnSettingPage(){
        Assert.assertTrue(on(Member_AccountSetting_Msite_Page.class).hasSettingPage(),"Checking user should be stayed back the setting page after logging in success");
        on(Member_AccountSetting_Msite_Page.class).allureUrlSettingPage();
    }

    @Then("^I should logout success")
    public void waitUntilVisible() throws Throwable {
        Assert.assertTrue(on(Member_Loginemail_Msite_Page.class).hasLoginForm(),"Checking user should not be stayed in account page after logging out success");
        on(Member_Account_Msite_Page.class).allureCurrentUrl();
    }
}