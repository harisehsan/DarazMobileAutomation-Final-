package checkout.desktop.step_definitions;

import cucumber.api.java.en.And;
import checkout.desktop.pages.Checkout_Page;
import checkout.desktop.pages.Shipping_Page;
import old_module.desktop.pages.desktop.pdp.Pdp_Page;
import base.BaseSteps;


public class CheckOutCodSteps extends BaseSteps{

    @And("^I place order from shipping page")
    public void placeOrderFromShipping() throws Throwable {
//        visit(Shipping_Page.class);
        on(Shipping_Page.class).placeOrder();
    }

    @And("^I checkout with Cod method")
    public void checkoutUsingCodMethod() throws Throwable {
        String orderNumber = on(Checkout_Page.class).placeCODOrder();
        System.out.println(orderNumber);

    }

    @And("^I place normal order with \"([^\"]*)\" products")
    public void placeNormalOrder(String numberOfItems) throws Throwable {
        visit(Pdp_Page.class);
        on(Pdp_Page.class).selectNumberOfItem(numberOfItems);
        on(Pdp_Page.class).openBuyNowPage();
        on(Shipping_Page.class).placeOrder();
        String orderNumber = on(Checkout_Page.class).placeCODOrder();
        System.out.println(orderNumber);
    }



}
