package _base.desktop_steps;

import base.BaseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import global.Global;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Member_Login_Page;

public class GlobalDesktopSteps extends BaseSteps {

    @And("^I login by email on lazada/daraz")
    public void globalLoginByEmail()throws Throwable {
        visit(Member_Login_Page.class);
        String email = Global.config.getString("member.account.mail");
        String pass = Global.config.getString("member.account.pass");
        on(Member_Login_Page.class).loginEmailPass(email,pass);
    }
}
