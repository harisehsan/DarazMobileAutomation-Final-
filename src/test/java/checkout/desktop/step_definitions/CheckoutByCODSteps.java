package checkout.desktop.step_definitions;

import allure.AllureAttachment;
import base.BaseSteps;
import checkout.desktop.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Global;
import org.testng.Assert;
import pdp.desktop.pages.Pdp_Page;

public class CheckoutByCODSteps extends BaseSteps {


    @And("^I click on Add to cart button$")
    public void clickAddToCart() {
        on(Pdp_Page.class).switchToEnglish();
        on(Pdp_Page.class).clickAddToCartButton();
    }

    @And("^I click Checkout button on Cart popup$")
    public void clickCheckout() {
        on(Pdp_Page.class).switchToEnglish();
        on(Cart_PopUp.class).clickCheckout();
    }

    @And("^I click Place Order button on Checkout Shipping page$")
    public void clickPlaceOrder() {
     //   on(Pdp_Page.class).switchToEnglish();
        on(CheckoutShipping_Page.class).clickPlaceOrder();
    }

    @And("^I place order with COD payment method$")
    public void selectCOD() {
//        on(Pdp_Page.class).switchToEnglish();
        on(CheckoutPaymentMethod_Page.class).selectCOD();
        on(CheckoutPaymentMethod_Page.class).clickConfirmOrderButton();
    }

    @Then("^I should be on Checkout Success page$")
    public void confirmOnCheckoutSuccess() {
        Assert.assertTrue(on(CheckoutSuccess_Page.class).currentURL().contains(on(CheckoutSuccess_Page.class).orderNumber()), "Verification failed: Order is not placed");
        AllureAttachment.attachComment("Order ID", on(CheckoutSuccess_Page.class).orderNumber());
    }

    @And("^I click Go To Cart button on Cart popup$")
    public void clickGoToCart() {
        on(Cart_Page.class).clickGoToCartButton();
    }

    @Then("^I should see the product title in the Cart$")
    public void checkProductTitleExistInTheCart() {
        Assert.assertTrue(on(Cart_Page.class).checkProductExistInTheCart(), "Product is not in Cart");
    }

    @Then("^I click on track order link$")
    public void i_click_on_track_order_link() throws Throwable {
        on(CheckoutSuccess_Page.class).clickTrackOrder();
    }

}
