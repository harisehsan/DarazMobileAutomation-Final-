package step_definitions.account;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import global.Global;
import pages.desktop.account.Member_Loginemail_Msite_Page;
import step_definitions.BaseSteps;

public class MemberLoginEmailMsiteSteps extends BaseSteps {

    @Given("^I go to login by email on Msite")
    public void openLogin() throws Throwable{
        visit(Member_Loginemail_Msite_Page.class);
    }

    @And("^I input email info on Msite")
    public void inputEmail() throws Throwable{
        String email = Global.config.getString("member.account.mail");
        on(Member_Loginemail_Msite_Page.class).setInputemail(email);

    }

    @And("^I input password info on Msite")
    public void inputPass() throws Throwable{
        String pass = Global.config.getString("member.account.pass");
        on(Member_Loginemail_Msite_Page.class).setInputpass(pass);

    }

    @And("^I click login button on Msite")
    public void clickLoginButton() throws Throwable{
        on(Member_Loginemail_Msite_Page.class).setClickloginbutton();

    }



}
