package asc.desktop.step_definitions;

import allure.AllureAttachment;
import cucumber.api.java.en.Then;
import global.Global;
import asc.desktop.pages.orders_management.OrderManagement_Page;
import asc.desktop.pages.orders_management.Rts_Form;
import base.BaseSteps;

public class OrdersReadyToShipSteps extends BaseSteps {


    @Then("^I RTS the last item in orders page")
    public void rtsLastItemInOrdersPage() throws Throwable {
        String orderNumber = on(OrderManagement_Page.class).getLastOrderNumber();
        on(OrderManagement_Page.class).openRTSForm(orderNumber);
        on(Rts_Form.class).performRTS();
        Global.getMap().put("current_OrderNo",orderNumber);
        AllureAttachment.attachComment("Current Order Number",orderNumber);
    }
}
