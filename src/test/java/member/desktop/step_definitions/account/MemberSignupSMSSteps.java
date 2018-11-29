package member.desktop.step_definitions.account;

import allure.AllureAttachment;
import cucumber.api.java.en.*;
import global.Global;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Member_SignUp_SMS_Page;
import base.BaseSteps;
import helper.RandomeHelper;
import org.testng.Assert;

public class MemberSignupSMSSteps extends BaseSteps {
    @Given("^I go to the sign up page by smsphone")
    public void signUpPage() throws Throwable {
        visit(Member_SignUp_SMS_Page.class);
    }

    @And("^I process to signup user by sms on signup page")
    public void signUpBySMSProcess() throws Throwable {
        String smsCode = Global.config.getString("member.account.sms_code");
        String passWord = Global.config.getString("member.pass");
        Global.map.put("password", passWord);
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

    @And("^I should see the account is verified")
    public void isVerified() throws Throwable {
        Assert.assertTrue(on(Account_Page.class).isVerified(),"Checking is verified icon should be display if user has updated mobile phone");
    }

    @Then("^I should see the logged account page")
    public void hasEmailLogged() {
        on(Account_Page.class).untilLoaded();
        Global.browser.refresh();
        String mobilePhone = (String) Global.map.get("mobile_phone_number");
        String currentEmail = on(Account_Page.class).hasEmail();
        String passwordLG = (String) Global.map.get("password");
        String expectEmail = Global.config.getString("member.mail");
        Assert.assertEquals(currentEmail, expectEmail, "Comparing email is using signup/login should be same with email display on my dashboard");
        AllureAttachment.attachComment("Email", currentEmail);
        AllureAttachment.attachComment("PhoneNumber", mobilePhone);
        AllureAttachment.attachComment("Password", passwordLG);
        AllureAttachment.attachComment("Url", Account_Page.page_url);
    }
}