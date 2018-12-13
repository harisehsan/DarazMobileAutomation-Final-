package member.desktop.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import helper.RandomHelper;
import member.desktop.pages.account.*;
import org.testng.Assert;

public class MemberChangeEmailPCSteps extends BaseSteps {

    @When("^I go to personal profile page to change email")
    public void goToPersonalProfilePage() throws Throwable {
        visit(Member_AccEdit_PC_Page.class);
    }

    @And("^I change email by email verification code")
    public void sendSmsCodeToBeforeChangingMail() throws Throwable {
        on(Member_AccEdit_PC_Page.class).sendCodeToInboxMail();
        String current_mail = (String) Global.map.get("current_mail");
        Global.map.put("current_mail",current_mail);
    }

    @And("^I get the email verification code from the inbox of current email")
    public void getSmsCodeFromInboxMail() throws Throwable {
        String currentWindowHandleId = Global.browser.currentWindowHandleId();
        Global.map.put("current_tab", currentWindowHandleId);
        Global.browser.openNewTab("");
        visit(Member_Mailinator_Page.class);
        on(Member_Mailinator_Page.class).inputMail((String) Global.map.get("current_mail"));
        on(Member_Mailinator_Page.class).goToMailDetail();
        Global.map.put("sms_code", on(Member_Mailinator_Page.class).getSMSCodeDetail());
    }

    @And("I confirm code on Verify Email page")
    public void verifySmsCode() throws Throwable {
        Global.browser.switchToTab((String) Global.map.get("current_tab"));
        on(Member_VerifyEmail_PC_Page.class).inputSMSCode((String) Global.map.get("sms_code"));
        on(Member_VerifyEmail_PC_Page.class).clickVerifyCodeBtn();
    }

    @And("^I input new mail and send code")
    public void sendSmsCodeToAfterChangingMail() throws Throwable {
        String current_mail = RandomHelper.randomTestMail();
        Global.map.put("current_mail",current_mail);
        on(Member_Change_Email_Pass_Page.class).sendCodeToMailAfterChanging(current_mail);
    }

    @Then("^I should see the new mail on personal profile page")
    public void hasEmailAfterChanging() throws Throwable {
        Assert.assertTrue(on(Member_Change_Email_Pass_Page.class).hasEmailChanging((String) Global.map.get("current_mail")), "Checking the new email should be display on account page");
        on(Member_Change_Email_Pass_Page.class).allureReportEmailChanging((String) Global.map.get("current_mail"));
    }

    @And("^I re-login by new email")
    public void loginByAfterChangingMail() throws Throwable {
        on(Account_Page.class).logOut();
        on(Member_Login_Page.class).loginEmailPass((String) Global.map.get("current_mail"),(String) Global.map.get("current_pass"));
    }
}