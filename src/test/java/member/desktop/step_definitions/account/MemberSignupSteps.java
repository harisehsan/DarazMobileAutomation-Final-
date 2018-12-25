package member.desktop.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import helper.RandomHelper;
import member.desktop.pages.account.*;
import org.testng.Assert;

public class MemberSignupSteps extends BaseSteps {

    @Given("^I go to the sign up page by email")
    public void signUpByEmail() throws Throwable {
        visit(SignUp_Page.class);
        Global.browser.refresh();
        on(SignUp_Page.class).switchToEnglish();
        on(SignUp_Page.class).signEmail();
    }

    @And("^I process to signup user by email on signup by email page")
    public void signUpByEmailProcess() throws Throwable {
        String randomEmail = RandomHelper.randomTestMail();
        Global.map.put("current_mail",randomEmail);
        String pass = Global.config.getString("member.account.pass");
        Global.map.put("current_pass",pass);
        String name = Global.config.getString("member.account.name");
        on(SignUp_Page.class).signUpByEmail(randomEmail,pass,name);
    }

    @And("^I click on submit button")
    public void submit() throws Throwable {
        on(SignUp_Page.class).submitButton();
    }

    @And("^I click and hold on slider button")
    public void clickSliderBtn() throws Throwable {
        on(SignUp_Page.class).setSliderbtn();
    }

    @And("^I go to the inbox of current email")
    public void goToInboxMail() throws Throwable{
        Global.browser.openNewTab("");
        visit(Member_Mailinator_Page.class);
        Global.browser.refresh();
        on(Member_Mailinator_Page.class).inputMail(Global.map.get("current_mail").toString());
        on(Member_Mailinator_Page.class).goToMailDetail();
    }

    @Then("^I should see the receive register success email")
    public void isReceiveRegisterSuccessEmail() throws Throwable {
        Assert.assertTrue(on(Member_Mailinator_Page.class).hasSuccessEmail(), "Checking email registration was success should send to inbox mail");
    }
}