package member.desktop.step_definitions.account;

import cucumber.api.java.en.And;
import helper.RandomeHelper;
import member.desktop.pages.account.Member_Complete_Your_Profile_Page;
import base.BaseSteps;

public class MemberCompleteProfileSteps extends BaseSteps {

    @And("^I jumps to email info page")
    public void jumpEmailInfo() throws Throwable{
        visit(Member_Complete_Your_Profile_Page.class);
    }
    @And("^I will input the name on form")
    public void inputName() throws Throwable{
        on(Member_Complete_Your_Profile_Page.class).setInputname("QA testing signup on Msite");
    }


    @And("^I will input the email on form")
    public void inputEmail() throws Throwable{
        on(Member_Complete_Your_Profile_Page.class).setInputemail(RandomeHelper.generateEmail()+"@hotmail.com");
    }


    @And("^I will input the password on form")
    public void inputPass() throws Throwable{
        on(Member_Complete_Your_Profile_Page.class).setInputpassword("q12345");
    }


    @And("^I will click submit on form")
    public void  submitButton() throws Throwable{
        on(Member_Complete_Your_Profile_Page.class).setCompletebutton();
    }
}
