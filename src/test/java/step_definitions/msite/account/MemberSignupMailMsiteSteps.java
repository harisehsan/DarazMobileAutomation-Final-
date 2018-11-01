package step_definitions.msite.account;

import global.Global;
import helper.RandomeHelper;
import pages.msite.account.Member_Account_Msite_Page;
import pages.msite.account.Member_Signupemail_Msite_Page;
import step_definitions.BaseSteps;
import cucumber.api.java.en.*;

public class MemberSignupMailMsiteSteps extends BaseSteps {
    @Given("^I go to Msite and open the sign up page by email")
    public void signUpMsite() throws Throwable {
        visit(Member_Signupemail_Msite_Page.class);
        Global.browser.refresh();
        on(Member_Signupemail_Msite_Page.class).setSignupEmail();
    }


    @And("^I input the name on form")
    public void inputName() throws Throwable {
        on(Member_Signupemail_Msite_Page.class).setInputName("QA testing signup on Msite");
    }


    @And("^I input the email on form")
    public void inputEmail() throws Throwable {
//        on(Member_Signupemail_Msite_Page.class).setInputEmail(RandomeHelper.generateEmail() + "@hotmail.com");
        String randomEmail = "LAZADATEST_1111_" + RandomeHelper.generateEmail()+ "@hotmail.com";
        Global.map.put("email_random",randomEmail);
        on(Member_Signupemail_Msite_Page.class).setInputEmail((String) Global.map.get("email_random"));
    }


    @And("^I input the password on form")
    public void inputPass() throws Throwable {
        String pass = Global.config.getString("member.pass");
        on(Member_Signupemail_Msite_Page.class).setInputPassword(pass);
    }


    @And("^I click submit on form")
    public void submitButton() throws Throwable {
        on(Member_Signupemail_Msite_Page.class).setSignupButton();
    }


    @Then("^I should see account page")
    public void titleAccount() throws Throwable {
        on(Member_Account_Msite_Page.class).setAccounttittle();
    }
}



