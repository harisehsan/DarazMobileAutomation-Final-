package asc.desktop.step_definitions;

import cucumber.api.java.en.Then;
import global.Global;
import asc.desktop.pages.orders_management.Cancel_Form;
import asc.desktop.pages.orders_management.OrderManagement_Page;
import base.BaseSteps;

public class OrdersCancelSteps extends BaseSteps {


    @Then("^I cancel the last item in orders page")
    public void cancelLastItemInOrdersPage() throws Throwable {
        String orderNumber = on(OrderManagement_Page.class).getLastOrderNumber();
        on(OrderManagement_Page.class).openCancelForm(orderNumber);
        on(Cancel_Form.class).performCancel();
        Global.getMap().put("current_OrderNo",orderNumber);
        System.out.println(orderNumber);
    }

}
