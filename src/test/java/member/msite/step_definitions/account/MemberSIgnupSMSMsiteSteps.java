package member.msite.step_definitions.account;

import cucumber.api.java.en.*;
import global.Global;
import helper.RandomHelper;
import member.msite.pages.account.Member_SIgnupsms_Msite_Page;
import base.BaseSteps;

public class MemberSIgnupSMSMsiteSteps extends BaseSteps {

    @Given("^On Msite I go to signup by sms page")
    public void signupSMS() throws Throwable {
        visit(Member_SIgnupsms_Msite_Page.class);
        Global.browser.refresh();
    }

    @And("^ON Msite I input the phone number")
    public void inputPhone() throws Throwable {
        String mobilephoneTemplate = Global.config.getString("member.phone_number_template");
        String mobilephone = RandomHelper.randomPhoneNumber(mobilephoneTemplate);
        on(Member_SIgnupsms_Msite_Page.class).inputPhone(mobilephone);
    }

    @And("^On Msite I click sendcode button")
    public void clickSendCode() throws Throwable {
        on(Member_SIgnupsms_Msite_Page.class).clickSend();
    }

    @And("^On Msite I input the smscode")
    public void inputSMSCode() throws Throwable {
        String smscode = Global.config.getString("member.account.sms_code");
        on(Member_SIgnupsms_Msite_Page.class).inputSMSCode(smscode);
    }

    @And("^I click continue button")
    public void clickContinue() throws Throwable {
        on(Member_SIgnupsms_Msite_Page.class).clickContinue();
    }
}