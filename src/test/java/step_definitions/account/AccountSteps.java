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
        //on(Login_Page.class).login("pdp_qaa_3@lzdtest.net", "qacucumber1");
        on(Login_Page.class).login(user, pass);
        on(Account_Page.class).untilLoaded();
    }

    @Given("^I login from Account Page")
    public void loginFromAccPageWithConfigAccount() throws Throwable {
        String user = Global.config.getString("asc.member_account.mail");
        String pass = Global.config.getString("asc.member_account.pass");
        visit(Login_Page.class);
        on(Login_Page.class).login(user, pass);
        on(Account_Page.class).untilLoaded();
    }
}
