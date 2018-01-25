package step_definitions.account;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import global.Global;
import pages.account.Account_Page;
import pages.account.Login_Page;
import pages.wishlist.Pdp_Page;

/**
 * Created by admin.son.ton on 1/25/18.
 */
public class AccountSteps {

    @Given("^I login from Account Page")
    public void loginFromAccPage() throws Throwable {
        Login_Page.visit();
        new Login_Page().login("pdp_qaa_3@lzdtest.net", "qacucumber1");
        new Account_Page().untilLoaded();
    }
}
