package ngoc_checkout_practice.desktop.step_definitions;

import base.BaseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import ngoc_checkout_practice.desktop.pages.Cart_Page;
import org.testng.Assert;

public class CartSteps extends BaseSteps {
    @And("^I move the product to wishlist$")
    public void moveToWishlist(){
        on(Cart_Page.class).clickWishlistIcon();
        on(Cart_Page.class).confirmMoveOrRemove();
    }

    @Then("^I should see successful message and the product is not in Cart$")
    public void checkMoveToWishlistSuccessful(){
        Assert.assertTrue(on(Cart_Page.class).checkMoveToWishlistSuccessMessage());
        Assert.assertFalse(on(Cart_Page.class).checkProductExistInTheCart());
    }

    @And("^I delete the product$")
    public void deleteProduct(){
        on(Cart_Page.class).clickDeleteIcon();
        on(Cart_Page.class).confirmMoveOrRemove();
    }

    @Then("^I should not see the product in Cart$")
    public void checkProductNotExistInCart(){
        Assert.assertTrue(on(Cart_Page.class).checkEmptyCart());
    }

    @And("^I click Confirm Cart$")
    public void clickConfirmCart(){
        on(Cart_Page.class).clickConfirmCart();
    }

}
