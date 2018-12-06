package member.msite.step_definitions.account;

import global.Global;
import helper.RandomeHelper;
import member.msite.pages.account.Member_Account_Msite_Page;
import member.msite.pages.account.Member_Signupemail_Msite_Page;
import base.BaseSteps;
import cucumber.api.java.en.*;
import org.testng.Assert;

public class MemberSignupMailMsiteSteps extends BaseSteps {

    @Given("^I go to the sign up on Msite page by email")
    public void signUpMsite() throws Throwable {
        visit(Member_Signupemail_Msite_Page.class);
        Global.browser.refresh();
        on(Member_Signupemail_Msite_Page.class).signUpEmail();
    }

    @And("^I input all information to signup by email page")
    public void signUpByEmail() throws Throwable {
        String name = Global.config.getString("member.account.name");
        Global.map.put("name_of_account",name);
        String randomEmail = "LAZADATEST_1111_" + RandomeHelper.generateEmail()+ "@mailinator.com";
        Global.map.put("current_mail",randomEmail);
        String passWord = Global.config.getString("member.account.pass");
        Global.map.put("current_pass", passWord);
        on(Member_Signupemail_Msite_Page.class).signUpByEmail(name,randomEmail,passWord);
        on(Member_Signupemail_Msite_Page.class).signUpButton();
    }

    @And("^I get result of newsletter config before trigger")
    public void currentNewsLetterConfig() throws  Throwable {
        String beforeTriggerNewsLetter = on(Member_Account_Msite_Page.class).getCurrentNewsletter();
        Global.map.put("current_newsletter",beforeTriggerNewsLetter);
    }

    @And("^I trigger on newsletter config")
    public void newsLetterConfig() throws  Throwable {
        on(Member_Account_Msite_Page.class).setNewsletterTrigger();
    }

    @Then("^On Msite I should see the user info is correctly displayed on account page")
    public void hasTitleAccount() throws Throwable {
        Assert.assertTrue(on(Member_Account_Msite_Page.class).hasAccountTittle(),"Checking account tittle on my account page should be displayed");
        String email = (String) Global.map.get("current_mail");
        String password = (String) Global.map.get("current_pass");
        on(Member_Account_Msite_Page.class).allureMailUrlPassMsite(email, password);
    }

    @Then("^I should see the result of current newsletter config changed")
    public void hasCurrentNews() throws Throwable {
        String before = (String) Global.map.get("current_newsletter");
        String after = on(Member_Account_Msite_Page.class).getCurrentNewsletter();
        Assert.assertNotEquals(before,after, "Checking the newsletter action should be different before and after configuration");
        on(Member_Account_Msite_Page.class).allureConfigNewsletter(before,after);
    }
}