package step_definitions.desktop.account;
import cucumber.api.java.en.*;
import global.Global;
import pages.desktop.account.Account_Page;
import pages.desktop.account.Member_SignUp_SMS_Page;
import step_definitions.BaseSteps;
import helper.RandomeHelper;

public class MemberSignupSMSSteps extends BaseSteps {
    @Given("^I go to the sign up page by smsphone")
    public void signupPage() throws Throwable {
        visit(Member_SignUp_SMS_Page.class);
        Global.browser.refresh();

    }

    @And("^I input the phonenumber")
    public void inputPhone() throws Throwable {
        String mobilephone = Global.config.getString("member.phonenumbersignup");
        on(Member_SignUp_SMS_Page.class).setInputPhone(mobilephone + RandomeHelper.generatePhoneNumber());
    }
    @And("^I input password information on signup by sms")
    public void inputPass() throws Throwable {
        String pass = Global.config.getString("member.account.pass");
        on(Member_SignUp_SMS_Page.class).setInputPassword(pass);
    }

    @And("^I click the sendcode button")
    public void sendCode() throws Throwable {
        on(Member_SignUp_SMS_Page.class).setSendCode();
    }

    @And("^I input the SMS code information")
    public void inputSMSCode() throws Throwable {
        String smscode = Global.config.getString("member.account.smscode");
        on(Member_SignUp_SMS_Page.class).setInputSMSCode(smscode);
    }

    @And("^On signup by SMS i click submit button")
    public void clickSubmit() throws Throwable {
        on(Member_SignUp_SMS_Page.class).setSubmitButton();
    }

    @And("^I should see the account is verified")
    public void isVerified() throws Throwable {
        on(Account_Page.class).isVerified();
    }

}
