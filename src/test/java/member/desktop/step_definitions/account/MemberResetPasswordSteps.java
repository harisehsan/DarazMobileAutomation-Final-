package member.desktop.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import helper.RandomeHelper;
import member.desktop.pages.account.*;

public class MemberResetPasswordSteps extends BaseSteps {

    @And("^I click reset password on login page")
    public void clickResetPass() throws Throwable {
        on(Member_Login_Page.class).clickResetPassBtn();
    }

    @And("^I go to forgot password page")
    public void accessResetPass() throws Throwable {
        visit(Member_Forget_Pass_PC_Page.class);
    }

    @And("^I submit email to reset password process")
    public void submitEmail() throws Throwable {
        String emailReset = Global.config.getString("member.mail_for_reset");
        on(Member_Forget_Pass_PC_Page.class).inputEmail(emailReset);
    }

    @And("^I click Verify through Email button")
    public void clickVerifyEmailBtn()throws Throwable {
        on(Member_Forget_Pass_PC_Page.class).clickVerifyEmailBtn();
    }

    @And("^I process to get smscode on verify by email page")
    public void processSMSCode() throws Throwable {
        on(Member_VerifyEmail_PC_Page.class).processVerifyEmailBtn();
    }

    @And("^I go to the inbox mail on new tab")
    public void accessInboxMail() throws Throwable {
        String currentWindowHandleId = Global.browser.currentWindowHandleId();
        Global.map.put("current_tab",currentWindowHandleId);
        Global.browser.openNewTab("");
        visit(Member_Mailinator_Page.class);

    }


    @And("^I open email to get sms code")
    public void accessSMSCode() throws Throwable {
        String emailReset = Global.config.getString("member.mail_for_reset");
        on(Member_Mailinator_Page.class).inputMail(emailReset);
        on(Member_Mailinator_Page.class).clickGoMailDetail();
        String smsCode = on(Member_Mailinator_Page.class).getSMSCodeDetail();
        Global.map.put("sms_code",smsCode);
    }

    @And("^I go back the old tab")
    public void goBackOldTab() throws Throwable {
        Global.browser.switchToTab((String) Global.map.get("current_tab"));
    }

    @And("^I input the smscode on verifyemail page from old tab")
    public void seeDetail() throws Throwable {
        on(Member_VerifyEmail_PC_Page.class).inputSMSCode((String) Global.map.get("sms_code"));
    }

    @And("I click Verify Code button on verifyemail page")
    public void clickVerifyCodeBtn() throws Throwable {
        on(Member_VerifyEmail_PC_Page.class).clickVerifyCodeBtn();
    }

    @And("^I go to reset password page")
    public void goToResetPass() throws Throwable {
        visit(Member_Reset_PassWord_Page.class);
    }

    @And("^I process reset password on reset password page")
    public void processResetPass() throws Throwable {
        String randomPassword = "q" + RandomeHelper.generateResetPass();
        on(Member_Reset_PassWord_Page.class).resetPassProcess(randomPassword,randomPassword);
        Global.map.put("new_reset_pass",randomPassword);
    }

    @And("^I login email with new password after reset")
    public void loginWithResetPass() throws Throwable {
        String emailForReset = Global.config.getString("member.mail_for_reset");
        on(Member_Login_Page.class).loginEmailPass(emailForReset,(String)Global.map.get("new_reset_pass"));
    }

}
