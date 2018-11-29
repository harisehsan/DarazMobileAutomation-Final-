package member.msite.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import member.msite.pages.account.Member_Mailinator_Msite_Page;
import member.msite.pages.account.Member_Reset_Password_Msite_Page;
import org.testng.Assert;

public class MemberResetPasswordMsiteSteps extends BaseSteps {

    @When("^I access to reset password on Msite")
    public void accessPassWord() throws Throwable {
        visit(Member_Reset_Password_Msite_Page.class);
    }

    @And("^I progress to forgot password")
    public void forgotPassword() throws Throwable {
        String mail = Global.config.getString("member.mail_for_reset");
        on(Member_Reset_Password_Msite_Page.class).resetPasswordStep(mail);
    }

    @And("^I choose Verify through Email button")
    public void accessPassPage() throws Throwable {
        on(Member_Reset_Password_Msite_Page.class).verifyByMail();
    }

    @And("^I go to the inbox mail in Msite on new tab")
    public void accessInboxMail() throws Throwable {
        String currentWindowHandleId = Global.browser.currentWindowHandleId();
        Global.map.put("current_tab",currentWindowHandleId);
        Global.browser.openNewTab("");
        visit(Member_Mailinator_Msite_Page.class);
    }

    @And("^I open email on Msite to get sms code")
    public void accessSMSCode() throws Throwable {
        String emailReset = Global.config.getString("member.mail_for_reset");
        on(Member_Mailinator_Msite_Page.class).inputMail(emailReset);
        on(Member_Mailinator_Msite_Page.class).clickGoMailDetail();
        String smsCode = on(Member_Mailinator_Msite_Page.class).getSMSCodeDetail();
        Global.map.put("sms_code",smsCode);
    }

    @And("^I on Msite go back the old tab")
    public void goBackOldTab() throws Throwable {
        Global.browser.switchToTab((String) Global.map.get("current_tab"));
    }

    @And("^I input the smsCode to reset password on msite")
    public void inputSmsCode() throws Throwable {
        String smsCode = (String) Global.map.get("sms_code");
        on(Member_Reset_Password_Msite_Page.class).inputCode(smsCode);
    }

    @And("^I input the new password for reset")
    public void inputNewPassword() throws Throwable {
        String newPass = Global.config.getString("member.account.new_pass");
        on(Member_Reset_Password_Msite_Page.class).progressNewPass(newPass);
    }

    @Then("^I should see the success reset password on reset page")
    public void hasSuccessMessage() throws Throwable {
        Assert.assertTrue(on(Member_Reset_Password_Msite_Page.class).hasSuccessResetMessage(),"Checking reset password is successful if user getting the success message on reset page");
    }

}