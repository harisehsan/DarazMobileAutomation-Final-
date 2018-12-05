package member.desktop.step_definitions.account;

import base.BaseSteps;
import com.typesafe.config.Config;
import cucumber.api.java.en.*;
import global.Global;
import member.desktop.pages.account.*;
import org.testng.Assert;

public class MemberChangeEmailPCSteps extends BaseSteps {

    @Given("^I login account by before changing email")
    public void loginByBeforeChangingMail() throws Throwable {
        visit(Member_Login_Page.class);
        String mailBeforeChanging = Global.config.getString("member.account.mail_before_change");
        Global.map.put("mail_before_change",mailBeforeChanging);
        String password = Global.config.getString("member.account.pass");
        on(Member_Login_Page.class).loginEmailPass(mailBeforeChanging,password);
    }

    @When("^I progress to send sms code for (.*?)$")
    public void sendSmsCodeToBeforeChangingMail(String email) throws Throwable {
        visit(Member_AccEdit_PC_Page.class);
        on(Member_AccEdit_PC_Page.class).sendCodeToInboxMail();
        Config emailConfig = Global.config.getConfig("member.account");
        String oldEmail = emailConfig.getString(email);
        Global.map.put("old_email",oldEmail);
    }

    @And("^I access the inbox of (.*?) to get sms code")
    public void getSmsCodeFromInboxMail(String email) throws Throwable {
        String currentWindowHandleId = Global.browser.currentWindowHandleId();
        Global.map.put("current_tab", currentWindowHandleId);
        Global.browser.openNewTab("");
        visit(Member_Mailinator_Page.class);
        Config emailConfig = Global.config.getConfig("member.account");
        String currentEmail = emailConfig.getString(email);
        on(Member_Mailinator_Page.class).inputMail(currentEmail);
        on(Member_Mailinator_Page.class).goToMailDetail();
        Global.map.put("sms_code", on(Member_Mailinator_Page.class).getSMSCodeDetail());
    }

    @And("I confirm sms code on Verify Email page")
    public void verifySmsCode() throws Throwable {
        Global.browser.switchToTab((String) Global.map.get("current_tab"));
        on(Member_VerifyEmail_PC_Page.class).inputSMSCode((String) Global.map.get("sms_code"));
        on(Member_VerifyEmail_PC_Page.class).clickVerifyCodeBtn();
    }

    @And("^I input (.*?) information to send code$")
    public void sendSmsCodeToAfterChangingMail(String email) throws Throwable {
        Config emailConfig = Global.config.getConfig("member.account");
        String currentEmail = emailConfig.getString(email);
        on(Member_ChangeEmail_Page.class).sendCodeToMailAfterChanging(currentEmail);
    }

    @Then("^I should see the (.*?) info on account page$")
    public void hasEmailAfterChanging(String email) throws Throwable {
        Config emailConfig = Global.config.getConfig("member.account");
        String currentEmail = emailConfig.getString(email);
        Assert.assertTrue(on(Member_ChangeEmail_Page.class).hasEmailChanging(currentEmail), "Checking the new email should be display on account page");
        on(Member_ChangeEmail_Page.class).allureReportEmailChanging(currentEmail);
    }

    @And("^I progress to login by (.*?)$")
    public void loginByEmailAfterChanging(String email) throws Throwable {
        on(Account_Page.class).logOut();
        Config emailConfig = Global.config.getConfig("member.account");
        String currentEmail = emailConfig.getString(email);
        on(Member_Login_Page.class).loginEmailPass(currentEmail,Global.config.getString("member.account.pass"));
    }
}