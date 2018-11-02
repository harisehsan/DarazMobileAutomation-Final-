package ngoc_checkout_practice.desktop.step_definitions;

import base.BaseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Global;
import ngoc_checkout_practice.desktop.pages.*;
import org.testng.Assert;

public class CheckoutByCODSteps extends BaseSteps {

    @When("^I go to a pdp page$")
    public void goToAPDPPage()
    {
        Pdp_Page.setUrl(Global.config.getConfig("asc").getString("pdp_url"));
        visit(Pdp_Page.class);
    }

    @And("^I click on Add to cart button$")
    public void clickAddToCart()
    {
        on(Pdp_Page.class).clickAddToCartButton();
    }


    @And("^I click Checkout button on Cart popup$")
    public void clickCheckout()
    {
        on(Cart_Page.class).clickCheckout();
    }

    @And("^I click Place Order button on Checkout Shipping page$")
    public void clickPlaceOrder()

    {
        on(CheckoutShipping_Page.class).clickPlaceOrder();
    }

    @And("^I select COD payment method$")
    public void selectCOD()
    {
        on(CheckoutPaymentMethod_Page.class).selectCOD();
    }

    @And("^I click Confirm Order button$")
    public void clickconfirmOrder()
    {
        on(CheckoutPaymentMethod_Page.class).clickConfirmOrderButton();
    }

    @Then("^I should be on Checkout Success page$")
    public void confirmOnCheckoutSuccess()
    {
        Assert.assertTrue(on(CheckoutSuccess_Page.class).hasThankyouTitle());
    }



}
