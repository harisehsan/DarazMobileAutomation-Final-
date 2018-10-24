package step_definitions.desktop.checkout;

import cucumber.api.java.en.And;
import pages.desktop.checkout.Checkout_Page;
import step_definitions.BaseSteps;


public class CheckoutCreditCardSteps extends BaseSteps{

    @And("^I select credit card payment method")
    public void selectOperator() throws Throwable {
        on(Checkout_Page.class).selectCardMethod();
    }

    @And("^I open new card")
    public void selectNewCard() throws Throwable {
        on(Checkout_Page.class).newCrad();
    }

    @And("^I enter card data number:\"([^\"]*)\", name:\"([^\"]*)\", date:\"([^\"]*)\", cvv:\"([^\"]*)\"")
    public void enterData(String number, String name, String date, String cvv) throws Throwable {
        on(Checkout_Page.class).enterCardData(number, name, date, cvv);
    }
    @And("^I don't save card")
    public void dontSaveCard(){
        on(Checkout_Page.class).switchSaveCard();
    }

    @And("^I confirm pay")
    public void confirm(){
        on(Checkout_Page.class).confirm();
    }

    @And("^I wait loader, waiting:\"([^\"]*)\"")
    public void waitLoader(String time) {
        on(Checkout_Page.class).waitLoader(time);
    }
}
