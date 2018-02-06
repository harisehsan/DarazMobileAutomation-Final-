package step_definitions.pdp;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import global.Global;
import model.ProductDetailInfo;
import pages.pdp.Pdp_Page;
import step_definitions.BaseSteps;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class PpdSteps extends BaseSteps{

    @Given("^I go to pdp page")
    public void goToPDPage() throws Throwable {
        visit(Pdp_Page.class);
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


}
