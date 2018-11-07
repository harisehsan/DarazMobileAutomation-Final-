package _base.desktop_steps;

import base.BaseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import global.Global;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Member_Login_Page;

public class GlobalDesktopSteps extends BaseSteps {

    @And("I login with new password")
    public void loginNewPass() throws Throwable {
        String new_pass = Global.config.getString("member.account.new_pass");
        on(Member_Login_Page.class).loginEmail((String)Global.map.get("email_random"),new_pass);
    }
}
