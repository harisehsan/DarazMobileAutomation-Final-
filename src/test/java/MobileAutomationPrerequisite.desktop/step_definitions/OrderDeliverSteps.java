package MobileAutomationPrerequisite.desktop.step_definitions;

import MobileAutomationPrerequisite.desktop.pages.Order_Deliver_Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class OrderDeliverSteps {
    Order_Deliver_Page orderDeliverPage = new Order_Deliver_Page();

    @And("I select buy now button")
    public void iSelectBuyNowButton() {
        orderDeliverPage.selectBuyNowbutton();
    }

    @And("I select google for signin")
    public void iSelectGoogleForSignin() {
        orderDeliverPage.selectGooglebutton();
    }

    @And("I sign by providing buyer google account {string} email and {string} password")
    public void iSignByProvidingBuyerEmailAndForTheAccount(String emailAddress, String password) {
        orderDeliverPage.signinWithGoogle(emailAddress,password);
    }

    @And("I save the Order Number for {string} order and venture details")
    public void iSaveTheOrderNumberAndVentureDetails(String orderType) throws IOException {
        orderDeliverPage.saveTheOrderNumberAndVenture(orderType);
    }

    @And("I make the order RTS from seller center for {string} order")
    public void iMakeTheOrderRTSFromSellerCenterHavingAnAccountEmailAndPassword(String orderType) throws IOException {
        orderDeliverPage.goToSellerOrderManagement(orderType);
    }

    @And("I goto order push tool")
    public void iGotoOrderPushTool() throws IOException {
        orderDeliverPage.goToOrderPushTool();
    }

    @And("I sign with my alibaba account {string} ID and {string} password")
    public void iSignWithMyAlibabaAccountIDAndPasswordPassword(String email, String password) {
        orderDeliverPage.loginUsingAliBabaAccount(email,password);
    }

    @And("I make the order status delivered for {string} order")
    public void iMakeTheOrderStatusDelivered(String orderType) throws IOException {
        orderDeliverPage.makeTheOrderDelivered(orderType);
    }

    @Then("I verify for the success message for order deliver")
    public void iVerifyForTheSuccessMessageForOrderDeliver() {
     Assert.assertTrue(orderDeliverPage.verifyForTheOrderSuccessStatus(),"Order is not successfully delivered!");
    }

    @And("I save the delivered order number for {string} product in mobile automation project")
    public void iSaveTheDeliveredOrderNumberForProductInMobileAutomationProject(String productType) throws IOException {
        orderDeliverPage.saveDeliveredOrderedNumber(productType);
    }

    @And("I make a checkout for combo product")
    public void iMakeACheckoutForComboProduct() {
        orderDeliverPage.addComboToCart();
    }
}
