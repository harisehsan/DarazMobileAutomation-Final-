package step_definitions.desktop.asc;

import cucumber.api.java.en.Then;
import global.Global;
import pages.desktop.asc.orders_management.Cancel_Form;
import pages.desktop.asc.orders_management.OrderManagement_Page;
import step_definitions.BaseSteps;

public class OrdersCancelSteps extends BaseSteps {


    @Then("^I cancel the last item in orders page")
    public void cancelLastItemInOrdersPage() throws Throwable {
        String orderNumber = on(OrderManagement_Page.class).getLastOrderNumber();
        on(OrderManagement_Page.class).openCancelForm(orderNumber);
        on(Cancel_Form.class).performCancel();
        Global.map.put("current_OrderNo",orderNumber);
        System.out.println(orderNumber);
    }

}
