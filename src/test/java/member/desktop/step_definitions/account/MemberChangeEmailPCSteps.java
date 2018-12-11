package member.desktop.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import helper.RandomHelper;
import member.desktop.pages.account.*;
import org.testng.Assert;

public class MemberChangeEmailPCSteps extends BaseSteps {

    @When("^I go to send sms code for before changing mail")
    public void sendSmsCodeToBeforeChangingMail() throws Throwable {
        visit(Member_AccEdit_PC_Page.class);
        on(Member_AccEdit_PC_Page.class).sendCodeToInboxMail();
        String beforeChangingMail = (String) Global.map.get("current_mail");
        Global.map.put("before_changing_mail",beforeChangingMail);
    }

    @And("^I access the inbox of (.*?) to get sms code")
    public void getSmsCodeFromInboxMail(String email) throws Throwable {
        String currentWindowHandleId = Global.browser.currentWindowHandleId();
        Global.map.put("current_tab", currentWindowHandleId);
        Global.browser.openNewTab("");
        visit(Member_Mailinator_Page.class);
        switch (email) {
            case "before changing mail":
                on(Member_Mailinator_Page.class).inputMail((String) Global.map.get("before_changing_mail"));
                break;
            case "after changing mail":
                on(Member_Mailinator_Page.class).inputMail((String) Global.map.get("after_changing_mail"));
                break;
        }
        on(Member_Mailinator_Page.class).goToMailDetail();
        Global.map.put("sms_code", on(Member_Mailinator_Page.class).getSMSCodeDetail());
    }

    @And("I confirm sms code on Verify Email page")
    public void verifySmsCode() throws Throwable {
        Global.browser.switchToTab((String) Global.map.get("current_tab"));
        on(Member_VerifyEmail_PC_Page.class).inputSMSCode((String) Global.map.get("sms_code"));
        on(Member_VerifyEmail_PC_Page.class).clickVerifyCodeBtn();
    }

    @And("^I input mail after changing information to send sms code")
    public void sendSmsCodeToAfterChangingMail() throws Throwable {
        String afterChangingMail = RandomHelper.randomTestMail();
        Global.map.put("after_changing_mail",afterChangingMail);
        on(Member_ChangeEmail_Page.class).sendCodeToMailAfterChanging(afterChangingMail);
    }

    @Then("^I should see the mail after changing info on account page$")
    public void hasEmailAfterChanging() throws Throwable {
        Assert.assertTrue(on(Member_ChangeEmail_Page.class).hasEmailChanging((String) Global.map.get("after_changing_mail")), "Checking the new email should be display on account page");
        on(Member_ChangeEmail_Page.class).allureReportEmailChanging((String) Global.map.get("after_changing_mail"));
    }

    @And("^I progress to login by mail after changing")
    public void loginByAfterChangingMail() throws Throwable {
        on(Account_Page.class).logOut();
        on(Member_Login_Page.class).loginEmailPass((String) Global.map.get("after_changing_mail"),(String) Global.map.get("current_pass"));
    }
}