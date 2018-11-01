package step_definitions.msite.account;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import global.Global;
import pages.msite.account.Member_Loginemail_Msite_Page;
import pages.msite.account.Member_Loginsms_Msite_Page;
import step_definitions.BaseSteps;

public class MemberLoginSMSMsiteSteps extends BaseSteps {

    @Given("^I go to login by SMS on Msite")
    public void loginSMS() throws Throwable{
        visit(Member_Loginemail_Msite_Page.class);
        on(Member_Loginemail_Msite_Page.class).clickSMSButton();
    }


    @And("^I input phonenumber info on Msite")
    public void inputPhone() throws Throwable{
        String mobile = Global.config.getString("member.phonenumberlogin");
        on(Member_Loginsms_Msite_Page.class).inputPhone(mobile);

    }

    @And("^I click the info sendcode button on Msite")
    public void clickSend() throws Throwable{
        on(Member_Loginsms_Msite_Page.class).clickSendCode();
    }

    @And("^I input code info on Msite")
    public void inputCode() throws Throwable{
        String smscode = Global.config.getString("member.smscode");
        on(Member_Loginsms_Msite_Page.class).inputSMSCode(smscode);

    }

    @And("^I click on loginbutton on Msite")
    public void clickLogin() throws Throwable{
        on(Member_Loginsms_Msite_Page.class).clickLoginBtn();

    }

}
