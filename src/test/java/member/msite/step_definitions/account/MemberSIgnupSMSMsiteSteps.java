package member.msite.step_definitions.account;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import global.Global;
import helper.RandomeHelper;
import member.msite.pages.account.Member_SIgnupsms_Msite_Page;
import base.BaseSteps;

public class MemberSIgnupSMSMsiteSteps extends BaseSteps {

    @Given("^I go to signup by sms page on Msite")
    public void signupSMS() throws Throwable{
        visit(Member_SIgnupsms_Msite_Page.class);
        Global.browser.refresh();
    }

    @And("^I input the phone number on Msite")
    public void inputPhone() throws Throwable{
        String mobilephone = Global.config.getString("member.phone_number_signup");
        on(Member_SIgnupsms_Msite_Page.class).inputPhone(mobilephone + RandomeHelper.generatePhoneNumber());
    }


    @And("^I click sendcode button on Msite")
    public void clickSendCode() throws Throwable{
        on(Member_SIgnupsms_Msite_Page.class).clickSend();
    }

    @And("^I input the smscode on Msite")
    public void inputSMSCode() throws Throwable{
        String smscode = Global.config.getString("member.sms_code");
        on(Member_SIgnupsms_Msite_Page.class).inputSMSCode(smscode);

    }

    @And("^I click continue button")
    public void clickContinue() throws Throwable{
        on(Member_SIgnupsms_Msite_Page.class).clickContinue();
    }



}
