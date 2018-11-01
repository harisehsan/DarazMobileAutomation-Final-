package member.desktop.step_definitions.account;
import cucumber.api.java.en.*;
import global.Global;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Member_SignUp_SMS_Page;
import base.BaseSteps;
import helper.RandomeHelper;

public class MemberSignupSMSSteps extends BaseSteps {
    @Given("^I go to the sign up page by smsphone")
    public void signUpPage() throws Throwable {
        visit(Member_SignUp_SMS_Page.class);
        Global.browser.refresh();

    }

    @And("^I input the phonenumber")
    public void inputPhone() throws Throwable {
        String mobilephone = Global.config.getString("member.phone_number_signup");
        on(Member_SignUp_SMS_Page.class).inputPhone(mobilephone + RandomeHelper.generatePhoneNumber());
    }
    @And("^I input password information on signup by sms")
    public void inputPass() throws Throwable {
        String pass = Global.config.getString("member.account.pass");
        on(Member_SignUp_SMS_Page.class).inputPassword(pass);
    }

    @And("^I click the sendcode button")
    public void sendCode() throws Throwable {
        on(Member_SignUp_SMS_Page.class).sendCode();
    }

    @And("^I click the slider button")
    public void sliderbtn() throws Throwable{
        on(Member_SignUp_SMS_Page.class).setSliderbtn();
    }

    @And("^I input the SMS code information")
    public void inputSMSCode() throws Throwable {
        String smscode = Global.config.getString("member.account.sms_code");
        on(Member_SignUp_SMS_Page.class).inputSMSCode(smscode);
    }

    @And("^On signup by SMS i click submit button")
    public void clickSubmit() throws Throwable {
        on(Member_SignUp_SMS_Page.class).submitButton();
    }

    @And("^I should see the account is verified")
    public void isVerified() throws Throwable {
        on(Account_Page.class).isVerified();
    }

}
