package asc.desktop.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import global.Global;
import asc.desktop.pages.orders_management.OrderManagement_Page;
import base.BaseSteps;

public class OrdersNavigationSteps extends BaseSteps {


    @Given("^I go to orders management page")
    public void goToOrdersManagementPage() throws Throwable {
        visit(OrderManagement_Page.class);
    }

    @Then("^I go to Pending orders Tab")
    public void goToPending() throws Throwable {
        on(OrderManagement_Page.class).openPendingTab();
        Global.map.get("current_seller");
    }

    @Then("^I go to RTS orders Tab$")
    public void goToRTS()  throws Throwable{
        on(OrderManagement_Page.class).openReadyToShipTab();
    }

    @Then("^I go to Cancelled orders Tab$")
    public void goToCancelled()  throws Throwable{
        on(OrderManagement_Page.class).openCancelledTab();
    }

    @Then("^I search for the current order$")
    public void searchCurrentOrder()  throws Throwable{
        on(OrderManagement_Page.class).clearFilter();
        on(OrderManagement_Page.class).searchOrder(String.valueOf(Global.map.get("current_OrderNo")));
    }

    @Then("^I Should see order is displayed")
    public void isDisplayed() throws Throwable {
        on(OrderManagement_Page.class).orderDisplayed(String.valueOf(Global.map.get("current_OrderNo")));
    }
}
