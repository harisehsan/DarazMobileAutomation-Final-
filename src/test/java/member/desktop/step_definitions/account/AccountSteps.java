package member.desktop.step_definitions.account;

import java.lang.String;
import cucumber.api.java.en.*;
import global.Global;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Login_Page;
import member.desktop.pages.account.Member_Login_Page;
import base.BaseSteps;
import org.testng.Assert;

/**
 * Created by admin.son.ton on 1/25/18.
 */
public class AccountSteps extends BaseSteps{

    @Given("^I login from Account Page by account: \"([^\"]*)\", password: \"([^\"]*)\"")
    public void loginFromAccPage(String user, String pass) throws Throwable {
        visit(Login_Page.class);
        on(Login_Page.class).logIn(user, pass);
        on(Account_Page.class).untilLoaded();
    }

    @Given("^I login from Account Page")
    public void loginFromAccPageWithConfigAccount() throws Throwable {
        String user = Global.config.getString("member.account.mail");
        String pass = Global.config.getString("member.account.pass");
        visit(Login_Page.class);
        on(Login_Page.class).logIn(user, pass);
        on(Account_Page.class).untilLoaded();
    }

    @And("^I click on logout account")
    public void logOut() throws Throwable {
        on(Account_Page.class).logOut();
    }

    @Then("^I logout successful")
    public void hasID() throws Throwable {
        Assert.assertTrue(on(Member_Login_Page.class).hasID(),"Checking user should be stay in login page");
    }
}