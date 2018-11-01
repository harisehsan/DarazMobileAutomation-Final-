package step_definitions.desktop.account;

import cucumber.api.java.en.And;
import global.Global;
import helper.RandomeHelper;
import pages.desktop.account.Member_Complete_Your_Profile_Page;
import step_definitions.BaseSteps;

public class MemberCompleteProfileSteps extends BaseSteps {

    @And("^I jumps to email info page")
    public void jumpEmailInfo() throws Throwable{
        visit(Member_Complete_Your_Profile_Page.class);
    }
    @And("^I will input the name on form")
    public void inputName() throws Throwable{
        String namemsite = Global.config.getString("member.account.namemsite");
        on(Member_Complete_Your_Profile_Page.class).setInputName(namemsite);
    }


    @And("^I will input the email on form")
    public void inputEmail() throws Throwable{
        on(Member_Complete_Your_Profile_Page.class).setInputEmail(RandomeHelper.generateEmail()+"@hotmail.com");
    }


    @And("^I will input the password on form")
    public void inputPass() throws Throwable{
        String pass = Global.config.getString("member.account.pass");
        on(Member_Complete_Your_Profile_Page.class).setInputPassword(pass);
    }


    @And("^I will click submit on form")
    public void  submitButton() throws Throwable{
        on(Member_Complete_Your_Profile_Page.class).setCompleteButton();
    }
}
