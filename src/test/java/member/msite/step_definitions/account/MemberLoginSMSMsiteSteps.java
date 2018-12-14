package member.msite.step_definitions.account;

import cucumber.api.java.en.*;
import global.Global;
import member.msite.pages.account.Member_Loginemail_Msite_Page;
import member.msite.pages.account.Member_Loginsms_Msite_Page;
import base.BaseSteps;

public class MemberLoginSMSMsiteSteps extends BaseSteps {

    @Given("^On Msite I go to login by SMS")
    public void loginSMS() throws Throwable{
        visit(Member_Loginemail_Msite_Page.class);
        on(Member_Loginemail_Msite_Page.class).clickSMSButton();
    }

    @And("^On Msite I input phonenumber info")
    public void inputPhone() throws Throwable{
        String mobile = Global.config.getString("member.registered_phone");
        on(Member_Loginsms_Msite_Page.class).inputPhone(mobile);
    }

    @And("^On Msite I click the info sendcode button")
    public void clickSend() throws Throwable{
        on(Member_Loginsms_Msite_Page.class).clickSendCode();
    }

    @And("^On Msite I input code info")
    public void inputCode() throws Throwable{
        String smscode = Global.config.getString("member.account.sms_code");
        on(Member_Loginsms_Msite_Page.class).inputSMSCode(smscode);
    }

    @And("^On Msite I click on login button")
    public void clickLogin() throws Throwable{
        on(Member_Loginsms_Msite_Page.class).clickLoginBtn();
    }
}