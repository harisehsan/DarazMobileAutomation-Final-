package member.msite.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.And;
import global.Global;
import helper.RandomeHelper;
import member.msite.pages.account.Member_Complete_Your_Profile_Page;

public class MemberCompleteProfileSteps extends BaseSteps {

    @And("^I jumps to email info page")
    public void jumpEmailInfo() throws Throwable {
        visit(Member_Complete_Your_Profile_Page.class);
    }

    @And("^I will input the name on form")
    public void inputName() throws Throwable {
        String name_msite = Global.config.getString("member.account.name_msite");
        on(Member_Complete_Your_Profile_Page.class).inputName(name_msite);
    }


    @And("^I will input the email on form")
    public void inputEmail() throws Throwable {
        String randomEmail = "LAZADATEST_1111_" + RandomeHelper.generateEmail()+ "@hotmail.com";
        Global.map.put("email_random",randomEmail);
        on(Member_Complete_Your_Profile_Page.class).inputEmail((String) Global.map.get("email_random"));
    }


    @And("^I will input the password on form")
    public void inputPass() throws Throwable{
        String pass = Global.config.getString("member.account.pass");
        on(Member_Complete_Your_Profile_Page.class).inputPassword(pass);
    }


    @And("^I will click submit on form")
    public void  submitButton() throws Throwable{
        on(Member_Complete_Your_Profile_Page.class).completeButton();
    }
}
