package step_definitions.pdp;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import global.Global;
import pages.pdp.Pdp_Page;
import step_definitions.BaseSteps;

import java.util.LinkedHashMap;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class PpdSteps extends BaseSteps{

    @Given("^I go to pdp page")
    public void goToPDPage() throws Throwable {
        visit(Pdp_Page.class);
    }

    @Given("^I go to \"([^\"]*)\" pdp page$")
    public void goToSpecificPDPage(String pdpType) throws Throwable {
//        LinkedHashMap map = (LinkedHashMap) Global.config.getString("pdp_url");
//        Object url = map.get(pdpType);
//        on(Pdp_Page.class).goToPDP((String) url);
    }

    @And("^I check out with \"([^\"]*)\" products")
    public void checkOutWithNumberOfItems(String numberOfItems) throws Throwable {
        on(Pdp_Page.class).selectNumberOfItem(numberOfItems);
        on(Pdp_Page.class).openBuyNowPage();
    }


    @And("^I add product to Wishlist from PDP")
    public void addToWishlist() throws Throwable {
        on(Pdp_Page.class).addToWishlist();
    }

    @And("^I get PDP info")
    public void getPDPInfo() throws Throwable {
        Global.map.put("current_info",on(Pdp_Page.class).getProductInfo());
    }

    @And("^I select product variation")
    public void selectVariation() throws Throwable {
        on(Pdp_Page.class).selectVariation();
    }

    @Then("^I can see the PDP page loaded")
    public void pdpLoaded() throws Throwable {
        on(Pdp_Page.class).waitUntilLoaded();
    }
}