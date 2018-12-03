package member.desktop.step_definitions.account;

import cucumber.api.java.en.*;
import global.Global;
import member.desktop.pages.account.*;
import base.BaseSteps;
import helper.RandomeHelper;

public class MemberSignupSMSSteps extends BaseSteps {
    @Given("^I go to the sign up page by smsphone")
    public void signUpPage() throws Throwable {
        visit(Member_SignUp_SMS_Page.class);
    }

    @And("^I process to signup user by sms on signup page")
    public void signUpBySMSProcess() throws Throwable {
        String smsCode = Global.config.getString("member.account.sms_code");
        String passWord = Global.config.getString("member.pass");
        String name = Global.config.getString("member.account.name");
        String randomEmail = "LAZADATEST_1111_" + RandomeHelper.generateEmail()+ "@hotmail.com";
        on(Member_SignUp_SMS_Page.class).signUpBySMS(smsCode,passWord,name,randomEmail);
    }

    @And("^I input the phonenumber")
    public void inputPhone() throws Throwable {
        String mobilephone = Global.config.getString("member.phone_number_signup");
        Global.map.put("mobile_phone_number", mobilephone);
        on(Member_SignUp_SMS_Page.class).inputPhoneNumber(mobilephone + RandomeHelper.generatePhoneNumber());
    }

    @And("^I click the slider button")
    public void sliderbtn() throws Throwable{
        on(Member_SignUp_SMS_Page.class).setSliderbtn();
    }

    @And("^On signup by SMS i click submit button")
    public void clickSubmit() throws Throwable {
        on(Member_SignUp_SMS_Page.class).submitButton();
    }
}