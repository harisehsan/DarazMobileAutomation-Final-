package step_definitions.wishlist;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;
import pages.wishlist.Wishlist_Page;
import global.Global;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class AddSteps {

    private Wishlist_Page wlPage;

    @Given("^I go to wishlist page")
    public void goToWishlistPage() throws Throwable {
        wlPage = new Wishlist_Page(Global.browser);
    }

    @Given("^I add all product to cart")
    public void addAllProductToCart() throws Throwable {
        wlPage.addAllToCart();
    }

    @Then("^I should see item displayed in Wishlist$")
    public void hasItem(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(123);
//        throw new PendingException();
    }


}
