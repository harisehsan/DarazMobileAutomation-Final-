package step_definitions.msite.account;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import global.Global;
import helper.RandomeHelper;
import pages.msite.account.Member_SIgnupsms_Msite_Page;
import step_definitions.BaseSteps;

public class MemberSIgnupSMSMsiteSteps extends BaseSteps {

    @Given("^I go to signup by sms page on Msite")
    public void signupSMS() throws Throwable{
        visit(Member_SIgnupsms_Msite_Page.class);
        Global.browser.refresh();
    }

    @And("^I input the phone number on Msite")
    public void inputPhone() throws Throwable{
        String mobilephone = Global.config.getString("member.phonenumbersignup");
        on(Member_SIgnupsms_Msite_Page.class).setInputPhone(mobilephone + RandomeHelper.generatePhoneNumber());
    }


    @And("^I click sendcode button on Msite")
    public void clickSendcode() throws Throwable{
        on(Member_SIgnupsms_Msite_Page.class).setClickSend();
    }

    @And("^I input the smscode on Msite")
    public void inputSMSCode() throws Throwable{
        String smscode = Global.config.getString("member.smscode");
        on(Member_SIgnupsms_Msite_Page.class).setInputSMSCode(smscode);

    }

    @And("^I click continue button")
    public void clickContinue() throws Throwable{
        on(Member_SIgnupsms_Msite_Page.class).setClickContinue();
    }



}
