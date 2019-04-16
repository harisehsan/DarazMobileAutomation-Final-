package asc.desktop.step_definitions;

import asc.desktop.pages.Seller_Home_Page;
import asc.desktop.pages.Seller_Login_Page;
import base.BaseSteps;
import com.typesafe.config.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Global;
import org.testng.Assert;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class LoginSteps extends BaseSteps {

    @Given("^I go to ASC login page")
    public void goLoginPage() throws Throwable {
        visit(Seller_Login_Page.class);
    }

    @When("^I login using seller \"([^\"]*)\" account")
    public void login(String seller) {
        Config ascConfig = Global.getConfig().getConfig("asc");
        String email = ascConfig.getString(seller+".mail");
        String pass = ascConfig.getString(seller+".pass");
        Global.getMap().put("current_seller",seller);
        on(Seller_Login_Page.class).login(email,pass);
    }

    @Then("^I should be logged in$")
    public void verifyLoggedIn() {
        Config ascConfig = Global.getConfig().getConfig("asc");
        String sellerNameConfig = String.format("%s.name",Global.getMap().get("current_seller"));
        String sellerName = ascConfig.getString(sellerNameConfig);
        String actualSellerName = on(Seller_Home_Page.class).currentSellerName();
        Assert.assertEquals(actualSellerName,sellerName);
    }


}
