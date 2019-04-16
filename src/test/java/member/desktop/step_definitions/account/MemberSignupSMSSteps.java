package member.desktop.step_definitions.account;

import cucumber.api.java.en.*;
import global.Global;
import helper.RandomHelper;
import member.desktop.pages.account.*;
import base.BaseSteps;

public class MemberSignupSMSSteps extends BaseSteps {
    @Given("^I go to the sign up page by smsphone")
    public void signUpPage() throws Throwable {
        visit(Member_SignUp_SMS_Page.class);
    }

    @And("^I process to signup user by sms on signup page")
    public void signUpBySMSProcess() throws Throwable {
        String smsCode = Global.getConfig().getString("member.account.sms_code");
        String passWord = Global.getConfig().getString("member.account.pass");
        String name = Global.getConfig().getString("member.account.name");
        String randomEmail = RandomHelper.randomTestMail();
        on(Member_SignUp_SMS_Page.class).signUpBySMS(smsCode,passWord,name,randomEmail);
    }

    @And("^I input the phonenumber")
    public void inputPhone() throws Throwable {
        String mobilephoneTemplate = Global.getConfig().getString("member.phone_number_template");
        String currentPhoneNumber = RandomHelper.randomPhoneNumber(mobilephoneTemplate);
        on(Member_SignUp_SMS_Page.class).inputPhoneNumber(currentPhoneNumber);
        Global.getMap().put("mobile_phone_number", currentPhoneNumber);
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