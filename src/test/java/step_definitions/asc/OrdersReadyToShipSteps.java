package step_definitions.asc;

import allure.AllureAttachment;
import cucumber.api.java.en.Then;
import global.Global;
import pages.desktop.asc.orders_management.Rts_Form;
import pages.desktop.asc.orders_management.OrderManagement_Page;
import step_definitions.BaseSteps;

public class OrdersReadyToShipSteps extends BaseSteps {


    @Then("^I RTS the last item in orders page")
    public void rtsLastItemInOrdersPage() throws Throwable {
        String orderNumber = on(OrderManagement_Page.class).getLastOrderNumber();
        on(OrderManagement_Page.class).openRTSForm(orderNumber);
        on(Rts_Form.class).performRTS();
        Global.map.put("current_OrderNo",orderNumber);
        AllureAttachment.attachComment("Current Order Number",orderNumber);
    }
}
