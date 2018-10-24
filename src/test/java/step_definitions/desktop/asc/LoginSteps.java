package step_definitions.desktop.asc;

import com.typesafe.config.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Global;
import org.testng.Assert;
import pages.desktop.asc.Seller_Home_Page;
import pages.desktop.asc.Seller_Login_Page;
import step_definitions.BaseSteps;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class LoginSteps extends BaseSteps{

    @Given("^I go to ASC login page")
    public void goLoginPage() throws Throwable {
        visit(Seller_Login_Page.class);
    }

    @When("^I login using seller \"([^\"]*)\" account")
    public void login(String seller) {
        Config ascConfig = Global.config.getConfig("asc");
        String email = ascConfig.getString(seller+".mail");
        String pass = ascConfig.getString(seller+".pass");
        Global.map.put("current_seller",seller);
        on(Seller_Login_Page.class).login(email,pass);
    }

    @Then("^I should be logged in$")
    public void verifyLoggedIn() {
        Config ascConfig = Global.config.getConfig("asc");
        String sellerNameConfig = String.format("%s.name",Global.map.get("current_seller"));
        String sellerName = ascConfig.getString(sellerNameConfig);
        String actualSellerName = on(Seller_Home_Page.class).currentSellerName();
        Assert.assertEquals(actualSellerName,sellerName);
    }


}
