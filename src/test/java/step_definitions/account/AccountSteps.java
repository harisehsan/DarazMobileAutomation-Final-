package step_definitions.account;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import global.Global;
import pages.account.Account_Page;
import pages.account.Login_Page;
import pages.pdp.Pdp_Page;
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
}
