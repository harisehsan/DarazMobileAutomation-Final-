package step_definitions.desktop.account;
import java.lang.String;

import cucumber.api.java.en.*;
import global.Global;
import pages.desktop.account.Account_Page;
import pages.desktop.account.Login_Page;
import pages.desktop.account.Member_Login_Page;
import step_definitions.BaseSteps;

/**
 * Created by admin.son.ton on 1/25/18.
 */
public class AccountSteps extends BaseSteps{


    @Given("^I login from Account Page by account: \"([^\"]*)\", password: \"([^\"]*)\"")
    public void loginFromAccPage(String user, String pass) throws Throwable {
        visit(Login_Page.class);
        on(Login_Page.class).login(user, pass);
        on(Account_Page.class).untilLoaded();
    }

    @Given("^I login from Account Page")
    public void loginFromAccPageWithConfigAccount() throws Throwable {
        String user = Global.config.getString("member.account.mail");
        String pass = Global.config.getString("member.account.pass");
        visit(Login_Page.class);
        on(Login_Page.class).login(user, pass);
        on(Account_Page.class).untilLoaded();
    }

    @And("^I click on my account menu")
    public void myAccountTrigger() throws Throwable {
        visit(Account_Page.class);
        on(Account_Page.class).setMyAccount_trigger();
    }
    @And("^I click on logout account")
    public void logout() throws Throwable {
        on(Account_Page.class).setLogout();
    }

    @Then("^I logout successful")
    public void hasID() throws Throwable {
        on(Account_Page.class);
        on(Member_Login_Page.class).hasID();
    }

}
