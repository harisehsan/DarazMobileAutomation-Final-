package step_definitions.account;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import global.Global;
import pages.desktop.account.Member_Loginemail_Msite_Page;
import pages.desktop.account.Member_Loginsms_Msite_Page;
import step_definitions.BaseSteps;

public class MemberLoginSMSMsiteSteps extends BaseSteps {

    @Given("^I go to login by SMS on Msite")
    public void loginsms() throws Throwable{
        visit(Member_Loginemail_Msite_Page.class);
        on(Member_Loginemail_Msite_Page.class).setClicksmsbutton();
    }


    @And("^I input phonenumber info on Msite")
    public void inputPhone() throws Throwable{
        String mobile = Global.config.getString("member.phonenumberlogin");
        on(Member_Loginsms_Msite_Page.class).setInputphone(mobile);

    }

    @And("^I click the info sendcode button on Msite")
    public void clickSend() throws Throwable{
        on(Member_Loginsms_Msite_Page.class).setClicksendcode();
    }

    @And("^I input code info on Msite")
    public void inputCode() throws Throwable{
        on(Member_Loginsms_Msite_Page.class).setInputsmscode("888888");

    }

    @And("^I click on loginbutton on Msite")
    public void clickLogin() throws Throwable{
        on(Member_Loginsms_Msite_Page.class).setClickloginbtn();

    }

}
