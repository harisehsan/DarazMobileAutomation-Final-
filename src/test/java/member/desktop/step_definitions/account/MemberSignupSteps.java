package member.desktop.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import global.Global;
import helper.RandomeHelper;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Member_Change_Pass_Page;
import member.desktop.pages.account.SignUp_Page;

public class MemberSignupSteps extends BaseSteps {

    @Given("^I go to the sign up page by email")
    public void signUpByEmail() throws Throwable {
        visit(SignUp_Page.class);
        Global.browser.refresh();
        on(SignUp_Page.class).signEmail();
    }

    @Given("^I input the email information")
    public void inputEmail() throws Throwable {
        String randomEmail = "LAZADATEST_1111_" + RandomeHelper.generateEmail()+ "@hotmail.com";
        Global.map.put("email_random",randomEmail);
        on(SignUp_Page.class).emailTextField((String) Global.map.get("email_random"));
    }

    @And("^I input password information")
    public void passWordField() throws Throwable {
        String pass = Global.config.getString("member.account.pass");
        on(SignUp_Page.class).passWordField(pass);
    }

    @And("^I input the name information")
    public void nameField() throws Throwable {
        String name = Global.config.getString("member.account.name");
        on(SignUp_Page.class).nameField(name);
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
        String new_pass = Global.config.getString("member.account.new_pass");
        on(Member_Change_Pass_Page.class).resetPass(current_pass,new_pass,new_pass);
    }

    @Then("^I should see the account page$")
    public void hasName() {
        on(Account_Page.class).untilLoaded();
        on(Account_Page.class).hasName((String) Global.map.get("email_random"));
    }
}