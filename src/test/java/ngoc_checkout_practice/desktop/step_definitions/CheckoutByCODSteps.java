package ngoc_checkout_practice.desktop.step_definitions;

import allure.AllureAttachment;
import base.BaseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Global;
import io.qameta.allure.Allure;
import ngoc_checkout_practice.desktop.pages.*;
import org.testng.Assert;

public class CheckoutByCODSteps extends BaseSteps {
    @When("^I go to a pdp page$")
    public void goToPdpPage() {
        Pdp_Page.setUrl(Global.config.getString("checkout.cod_pdp_url"));
        visit(Pdp_Page.class);
        on(Pdp_Page.class).switchToEnglish();
    }

    @When("^I get the product title$")
    public void getProductTitle(){
        on(Pdp_Page.class).setProductTitle(on(Pdp_Page.class).getProductTitle());
    }

    @And("^I click on Add to cart button$")
    public void clickAddToCart() {
        on(Pdp_Page.class).clickAddToCartButton();
    }

    @And("^I click Checkout button on Cart popup$")
    public void clickCheckout() {
        on(Cart_PopUp.class).clickCheckout();
    }

    @And("^I click Place Order button on Checkout Shipping page$")
    public void clickPlaceOrder() {
        on(CheckoutShipping_Page.class).clickPlaceOrder();
    }

    @And("^I place order with COD payment method$")
    public void selectCOD() {
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

}
