package checkout.desktop.step_definitions;

import base.BaseSteps;
import checkout.desktop.pages.CancelOrderSuccess_Page;
import checkout.desktop.pages.OrderDetails_Page;
import checkout.desktop.pages.RequestCancellation_Page;
import cucumber.api.java.en.And;
import org.testng.Assert;

public class CheckoutCancelOrderSteps extends BaseSteps {

    @And("^I click cancel order button$")
    public void i_click_cancel_order_button() throws Throwable {
        on(OrderDetails_Page.class).clickCancelOrder();
    }

    @And("^I choose cancel reason to submit$")
    public void i_choose_cancel_reason_to_submit() throws Throwable {
        on(RequestCancellation_Page.class).chooseCancelReason();
    }

    @And("^I should be on Cancel Success page$")
    public void i_should_be_on_Cancel_Success_page() throws Throwable {
        Assert.assertTrue(on(CancelOrderSuccess_Page.class).hasCancelSuccessTitle(), "Verification failed: Cancel order is not placed");
    }

}