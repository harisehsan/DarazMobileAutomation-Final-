package member.desktop.step_definitions.account;

import allure.AllureAttachment;
import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import helper.RandomeHelper;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Member_Change_Pass_Page;
import member.desktop.pages.account.SignUp_Page;
import org.testng.Assert;

public class MemberSignupSteps extends BaseSteps {

    @Given("^I go to the sign up page by email")
    public void signUpByEmail() throws Throwable {
        visit(SignUp_Page.class);
        Global.browser.refresh();
        on(SignUp_Page.class).signEmail();
    }

    @And("^I process to signup user by email on signup by email page")
    public void signUpByEmailProcess() throws Throwable {
        String randomEmail = "LAZADATEST_1111_" + RandomeHelper.generateEmail()+ "@hotmail.com";
        Global.map.put("email_random",randomEmail);
        String pass = Global.config.getString("member.pass");
        String name = Global.config.getString("member.account.name");
        on(SignUp_Page.class).signUpByEmail(randomEmail,pass,name);

    }

    @And("^I click on submit button")
    public void submit() throws Throwable {
        on(SignUp_Page.class).submitButton();
    }

    @And("^I click and hold on slider button")
    public void sliderbtn() throws Throwable {
        on(SignUp_Page.class).setSliderbtn();
    }

    @And("^I go to change password page")
    public void changePass() throws Throwable {
        visit(Member_Change_Pass_Page.class);
        String current_pass = Global.config.getString("member.pass");
        String new_pass = Global.config.getString("member.account.new_pass");
        on(Member_Change_Pass_Page.class).resetPass(current_pass,new_pass);
    }

    @Then("^I should see the account page$")
    public void hasEmailOnAccountPage() {
        on(Account_Page.class).untilLoaded();
        String currentEmail = on(Account_Page.class).hasEmail();
        String expectEmail = (String) Global.map.get("email_random");
        String pass = Global.config.getString("member.pass");
        Assert.assertEquals(currentEmail,expectEmail, "Comparing email is using signup/login should be same with email display on my dashboard");
        AllureAttachment.attachComment("Email", currentEmail);
        AllureAttachment.attachComment("Password", pass);
        AllureAttachment.attachComment("Url", Account_Page.page_url);
    }

    @Then("^I should see the email for reset on account page$")
    public void hasEmailReset() {
        on(Account_Page.class).untilLoaded();
        String currentEmail = on(Account_Page.class).hasEmail();
        String expectEmail = Global.config.getString("member.mail_for_reset");
        Assert.assertEquals(currentEmail,expectEmail, "Comparing email is using signup/login should be same with email display on my dashboard");
    }
}