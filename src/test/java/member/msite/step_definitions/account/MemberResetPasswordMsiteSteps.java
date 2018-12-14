package member.msite.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import helper.RandomHelper;
import member.msite.pages.account.Member_ChangeEmail_Msite_Page;
import member.msite.pages.account.Member_Mailinator_Msite_Page;
import member.msite.pages.account.Member_Reset_Password_Msite_Page;
import org.testng.Assert;

public class MemberResetPasswordMsiteSteps extends BaseSteps {

    @When("^On Msite I access to reset password")
    public void accessPassWord() throws Throwable {
        visit(Member_Reset_Password_Msite_Page.class);
    }

    @And("^I progress to forgot password")
    public void forgotPassword() throws Throwable {
        String mail = Global.config.getString("member.reset_password_mail");
        Global.map.put("current_mail",mail);
        on(Member_Reset_Password_Msite_Page.class).resetPasswordStep(mail);
    }

    @And("^I choose Verify through Email button")
    public void accessPassPage() throws Throwable {
        on(Member_Reset_Password_Msite_Page.class).verifyByMail();
    }

    @And("^On Msite I get the email verification code from the inbox of current email")
    public void getCodeFromInboxMail() throws Throwable {
        String currentWindowHandleId = Global.browser.currentWindowHandleId();
        Global.map.put("current_tab",currentWindowHandleId);
        Global.browser.openNewTab("");
        visit(Member_Mailinator_Msite_Page.class);
        on(Member_Mailinator_Msite_Page.class).inputMail((String)Global.map.get("current_mail"));
        on(Member_Mailinator_Msite_Page.class).goToMailDetail();
        String smsCode = on(Member_Mailinator_Msite_Page.class).getSMSCodeDetail();
        Global.map.put("verify_code",smsCode);
    }

    @And("^On Msite i confirm code on Verify Email page")
    public void goBackOldTab() throws Throwable {
        Global.browser.switchToTab((String) Global.map.get("current_tab"));
        String smsCode = (String) Global.map.get("verify_code");
        on(Member_Reset_Password_Msite_Page.class).inputCode(smsCode);
    }

    @And("^On Msite I input new mail and send code")
    public void sendCodeToNewEmail() throws Throwable {
        String current_mail = RandomHelper.randomTestMail();
        Global.map.put("current_mail",current_mail);
        on(Member_ChangeEmail_Msite_Page.class).sendCodeToNewEmail(current_mail);
    }

    @And("^I input the new password for reset")
    public void inputNewPassword() throws Throwable {
        String randomPassword = RandomHelper.randomAlphabetString(5) + RandomHelper.randomNumber(5);
        on(Member_Reset_Password_Msite_Page.class).progressNewPass(randomPassword);
        Global.map.put("current_pass",randomPassword);
    }

    @Then("^I should see the success reset password on reset page")
    public void hasSuccessMessage() throws Throwable {
        Assert.assertTrue(on(Member_Reset_Password_Msite_Page.class).hasSuccessResetMessage(),"Checking reset password is successful if user getting the success message on reset page");
        on(Member_Reset_Password_Msite_Page.class).allureResetPassword((String)(Global.map.get("email is reset")),(String)Global.map.get("current_pass"));
    }
}