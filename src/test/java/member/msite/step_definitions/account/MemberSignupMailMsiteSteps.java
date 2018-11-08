package member.msite.step_definitions.account;

import global.Global;
import helper.RandomeHelper;
import member.msite.pages.account.Member_Account_Msite_Page;
import member.msite.pages.account.Member_Signupemail_Msite_Page;
import base.BaseSteps;
import cucumber.api.java.en.*;
import org.testng.Assert;

public class MemberSignupMailMsiteSteps extends BaseSteps {
    @Given("^I go to Msite and open the sign up page by email")
    public void signUpMsite() throws Throwable {
        visit(Member_Signupemail_Msite_Page.class);
        Global.browser.refresh();
        on(Member_Signupemail_Msite_Page.class).signUpEmail();
    }


    @And("^I input the name on form")
    public void inputName() throws Throwable {
        on(Member_Signupemail_Msite_Page.class).inputName("QA testing signup on Msite");
    }


    @And("^I input the email on form")
    public void inputEmail() throws Throwable {
        String randomEmail = "LAZADATEST_1111_" + RandomeHelper.generateEmail()+ "@hotmail.com";
        Global.map.put("email_random",randomEmail);
        on(Member_Signupemail_Msite_Page.class).inputEmail((String) Global.map.get("email_random"));
    }


    @And("^I input the password on form")
    public void inputPass() throws Throwable {
        String pass = Global.config.getString("member.account.pass");
        on(Member_Signupemail_Msite_Page.class).inputPassword(pass);
    }


    @And("^I click submit on form")
    public void submitButton() throws Throwable {
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

    @Then("^I should see account page")
    public void hasTitleAccount() throws Throwable {
        on(Member_Account_Msite_Page.class).setAccountTittle();
    }

    @Then("^I should see the result of current newsletter config changed")
    public void hasCurrentNews() throws Throwable {
        String before = (String) Global.map.get("current_newsletter");
        String after = on(Member_Account_Msite_Page.class).getCurrentNewsletter();
        Assert.assertEquals(before,after);
    }
}



