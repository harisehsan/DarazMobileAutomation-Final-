package member.desktop.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import helper.RandomeHelper;
import member.desktop.pages.account.*;

public class MemberSignupSteps extends BaseSteps {

    @Given("^I go to the sign up page by email")
    public void signUpByEmail() throws Throwable {
        visit(SignUp_Page.class);
        Global.browser.refresh();
        on(SignUp_Page.class).signEmail();
    }

    @And("^I process to signup user by email on signup by email page")
    public void signUpByEmailProcess() throws Throwable {
        String randomEmail = "LAZADATEST_1111_" + RandomeHelper.generateEmail()+ "@mailinator.com";
        Global.map.put("email_random",randomEmail);
        String pass = Global.config.getString("member.account.pass");
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
        String current_pass = Global.config.getString("member.account.pass");
        String changed_pass = Global.config.getString("member.account.changed_pass");
        on(Member_Change_Pass_Page.class).resetPass(current_pass,changed_pass);
    }
}