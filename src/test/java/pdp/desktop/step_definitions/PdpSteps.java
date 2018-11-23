package pdp.desktop.step_definitions;

import base.BaseSteps;
import pdp.desktop.pages.MyWishlist_Page;
import pdp.desktop.pages.Pdp_Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Global;
import org.testng.Assert;


public class PdpSteps extends BaseSteps {
    @Given("^I go to a normal pdp page$")
    public void visitNormalPdpPage(){
        Pdp_Page.setUrl(Global.config.getString("pdp.normal_pdp_url"));
        visit(Pdp_Page.class);
        on(Pdp_Page.class).closeShippingFromOverseaPopup();
    }

    @When("^I click wishlist icon$")
    public void addToWishlist(){
        on(Pdp_Page.class).addToWishlist();
    }

    @Then("^I should see wishlist icon turns to orange$")
    public void wishlistIconClicked(){
        Assert.assertEquals(on(Pdp_Page.class).wishlistIconClicked(), "rgba(245, 114, 36, 1)");
    }

    @Then("^I should see the product on My wishlist page$")
    public void productMovedToMyWishlist(){
        on(Pdp_Page.class).clickMyWishlistMenu();
        on(MyWishlist_Page.class).checkProductExistInMyWishlist();
    }

}
