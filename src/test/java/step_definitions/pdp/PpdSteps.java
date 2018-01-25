package step_definitions.pdp;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import global.Global;
import model.ProductDetailInfo;
import pages.wishlist.Pdp_Page;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class PpdSteps {

    @Given("^I go to pdp page")
    public void goToPDPage() throws Throwable {
        Pdp_Page.visit();
    }

    @And("^I add product to Wishlist from PDP")
    public void addToWishlist() throws Throwable {
        new Pdp_Page().addToWishlist();
    }

    @And("^I get PDP info")
    public void getPDPInfo() throws Throwable {
        Global.map.put("current_info",new Pdp_Page().getProductInfo());
    }


}
