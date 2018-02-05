package step_definitions.Checkout;

import cucumber.api.java.en.And;
import pages.checkout.TopupSuccessful_Page;

public class TopupSuccessfulSteps {

    public String orderNumber;

    @And("^I check successful")
    public void checkSuccessful() throws Throwable {
        new TopupSuccessful_Page().checkSuccessful();
    }

    @And("^I check order Number")
    public String selectOrderNumber() throws Throwable {
        orderNumber = new TopupSuccessful_Page().toString();
        return orderNumber;
    }

    @And("^I check order details, SKU name:\"([^\"]*)\", phone:\"([^\"]*)\"")
    public void orderDetails(String name, String phone) throws Throwable {
        new TopupSuccessful_Page().checkOrder(name, phone);
    }

    @And("^I check pending")
    public void checkPending() throws Throwable {
        new TopupSuccessful_Page().checkPending();
    }
}
