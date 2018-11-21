package member.desktop.step_definitions.my_order;

import base.BaseSteps;
import cucumber.api.java.en.And;
import member.desktop.pages.account.Member_MyOrder_Page;
import org.testng.Assert;

public class MyOrderSteps extends BaseSteps {

    @And("^I click cancel order button$")
    public void i_click_cancel_order_button() throws Throwable {
        on(Member_MyOrder_Page.class).clickCancelOrder();
    }

    @And("^I choose cancel reason to submit$")
    public void i_choose_cancel_reason_to_submit() throws Throwable {
        on(Member_MyOrder_Page.class).chooseCancelReason();
    }

    @And("^I should be on Cancel Success page$")
    public void i_should_be_on_Cancel_Success_page() throws Throwable {
        Assert.assertTrue(on(Member_MyOrder_Page.class).hasCancelSuccessTitle(), "Verification failed: Cancel order is not placed");
    }

}