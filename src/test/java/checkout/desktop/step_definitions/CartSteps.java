package checkout.desktop.step_definitions;

import base.BaseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import checkout.desktop.pages.Cart_Page;
import org.testng.Assert;

public class CartSteps extends BaseSteps {
    @And("^I move the product to wishlist$")
    public void moveToWishlist(){
        on(Cart_Page.class).clickWishlistIcon();
        on(Cart_Page.class).confirmMoveOrRemove();
    }

    @Then("^I should see successful message and the product is not in Cart$")
    public void checkMoveToWishlistSuccessful(){
        Assert.assertTrue(on(Cart_Page.class).checkMoveToWishlistSuccessMessage(), "Verification failed: No success message displays");
        Assert.assertFalse(on(Cart_Page.class).checkProductExistInTheCart(), "Verification failed: Product still be on cart");
    }

    @And("^I delete the product$")
    public void deleteProduct(){
        on(Cart_Page.class).clickDeleteIcon();
        on(Cart_Page.class).confirmMoveOrRemove();
    }

    @Then("^I should not see the product in Cart$")
    public void checkProductNotExistInCart(){
        Assert.assertFalse(on(Cart_Page.class).checkProductExistInTheCart(), "Verification failed: Cart is not empty");
    }

    @And("^I click Confirm Cart$")
    public void clickConfirmCart(){
        on(Cart_Page.class).clickConfirmCart();
    }

}
