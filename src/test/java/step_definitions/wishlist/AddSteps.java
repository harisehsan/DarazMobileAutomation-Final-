package step_definitions.wishlist;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.ProductDetailInfo;
import org.testng.Assert;
import pages.*;
import pages.wishlist.Wishlist_Page;
import global.Global;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class AddSteps {

    @Given("^I go to wishlist page")
    public void goToWishlistPage() throws Throwable {
        Wishlist_Page.visit();
    }

    @Given("^I add all product to cart")
    public void addAllProductToCart() throws Throwable {
        new Wishlist_Page().addAllToCart();
    }

    @Then("^I should see item displayed in Wishlist$")
    public void hasItem() throws Throwable {
        boolean result = new Wishlist_Page().hasItem((ProductDetailInfo)Global.map.get("current_info"));
        Assert.assertTrue(result,"Wishlist item is not match PDP item");
    }


}
