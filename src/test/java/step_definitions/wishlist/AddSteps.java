package step_definitions.wishlist;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.ProductDetailInfo;
import org.testng.Assert;
import pages.*;
import pages.wishlist.Wishlist_Page;
import global.Global;
import step_definitions.BaseSteps;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class AddSteps extends BaseSteps{

    @Given("^I go to wishlist page")
    public void goToWishlistPage() throws Throwable {
        visit(Wishlist_Page.class);
    }

    @Given("^I add all product to cart")
    public void addAllProductToCart() throws Throwable {
        on(Wishlist_Page.class).addAllToCart();
    }

    @Then("^I should see item displayed in Wishlist$")
    public void hasItem() throws Throwable {
        boolean result = on(Wishlist_Page.class).hasItem((ProductDetailInfo)Global.map.get("current_info"));
        Assert.assertTrue(result,"Wishlist item is not match PDP item");
    }


}
