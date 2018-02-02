package step_definitions.Checkout;

import cucumber.api.java.en.And;
import pages.checkout.Checkout_Page;


public class CheckoutCreditCardSteps {

    @And("^I select credit card payment method")
    public void selectOperator() throws Throwable {
        new Checkout_Page().selectCardMethod();
    }

    @And("^I open new card")
    public void selectNewCard() throws Throwable {
        new Checkout_Page().newCrad();
    }

    @And("^I enter card data number:\"([^\"]*)\", name:\"([^\"]*)\", date:\"([^\"]*)\", cvv:\"([^\"]*)\"")
    public void enterData(String number, String name, String date, String cvv) throws Throwable {
        new Checkout_Page().enterCardData(number, name, date, cvv);
    }
    @And("^I don't save card")
    public void dontSaveCard(){
        new Checkout_Page().switchSaveCard();
    }
    @And("^I confirm pay")
    public void confirm(){
        new Checkout_Page().confirm();
    }
}
