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
        String current_mail = Global.getMap().get("current_mail").toString();
        Global.getMap().put("current_mail",current_mail);
    }

    @And("^I get the email verification code from the inbox of current email")
    public void getCodeFromInboxMail() throws Throwable {
        String currentWindowHandleId = Global.getBrowser().currentWindowHandleId();
        Global.getMap().put("current_tab", currentWindowHandleId);
        Global.getBrowser().openNewTab("");
        visit(Member_Mailinator_Page.class);
        Global.getBrowser().refresh();
        on(Member_Mailinator_Page.class).inputMail(Global.getMap().get("current_mail").toString());
        on(Member_Mailinator_Page.class).goToMailDetail();
        Global.getMap().put("verify_code", on(Member_Mailinator_Page.class).getSMSCodeDetail());
    }

    @And("I confirm code on Verify Email page")
    public void verifyCode() throws Throwable {
        Global.getBrowser().switchToTab(Global.getMap().get("current_tab").toString());
        on(Member_VerifyEmail_PC_Page.class).inputSMSCode(Global.getMap().get("verify_code").toString());
        on(Member_VerifyEmail_PC_Page.class).clickVerifyCodeBtn();
    }

    @And("^I input new mail and send code")
    public void sendCodeToAfterChangingMail() throws Throwable {
        String current_mail = RandomHelper.randomTestMail();
        Global.getMap().put("current_mail",current_mail);
        on(Member_Change_Email_Pass_Page.class).sendCodeToMail(current_mail);
    }

    @Then("^I should see the new mail on personal profile page")
    public void hasEmailAfterChanging() throws Throwable {
        String currentMail = Global.getMap().get("current_mail").toString();
        Assert.assertTrue(on(Member_Change_Email_Pass_Page.class).hasEmailChanging(currentMail), "Checking the new email should be display on account page");
        on(Member_Change_Email_Pass_Page.class).allureReportEmailChanging(currentMail);
    }

    @And("^I re-login by new email")
    public void loginByAfterChangingMail() throws Throwable {
        on(Account_Page.class).logOut();
        String currentMail = Global.getMap().get("current_mail").toString();
        String currentPass = Global.getMap().get("current_pass").toString();
        on(Member_Login_Page.class).loginEmailPass(currentMail, currentPass);
    }
}