package step_definitions.checkout;

import cucumber.api.java.en.And;
import pages.checkout.TopupSuccessful_Page;
import step_definitions.BaseSteps;

public class TopupSuccessfulSteps extends BaseSteps{

    public String orderNumber;

    @And("^I check successful")
    public void checkSuccessful() throws Throwable {
        on(TopupSuccessful_Page.class).checkSuccessful();
    }

    @And("^I check order Number")
    public String selectOrderNumber() throws Throwable {
        orderNumber = on(TopupSuccessful_Page.class).orderNumber();
        return orderNumber;
    }

    @And("^I check order details, SKU name:\"([^\"]*)\", phone:\"([^\"]*)\"")
    public void orderDetails(String name, String phone) throws Throwable {
        on(TopupSuccessful_Page.class).checkOrder(name, phone);
    }

    @And("^I check pending")
    public void checkPending() throws Throwable {
        on(TopupSuccessful_Page.class).checkPending();
    }
}
