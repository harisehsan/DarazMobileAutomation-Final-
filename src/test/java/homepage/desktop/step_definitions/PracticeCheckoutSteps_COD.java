package homepage.desktop.step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Global;
import homepage.desktop.pages.*;
import base.BaseSteps;

public class PracticeCheckoutSteps_COD extends BaseSteps {


    @When("^I go to HomePage")
    public void landInHomePage() throws Throwable {
        //hp_Base.visit_URL("https://www.daraz.com.bd/");
        //Global.browser.goTo("https://www.daraz.com.bd/");
        visit(HomePage.class);
    }

    @Then("^I click on log in to login page")
    public void landLoginPage()  {
        on(HomePage.class).clickToLoginPage();
    }

    @Then("^I input username: \"([^\"]*)\"  and pwd: \"([^\"]*)\"$")
    public void LoginWithAccount (String username, String pwd) {

        on(LoginPage.class).InputLogin(username,pwd);
    }

    @Then("^I input account information")
    public void LoginWithExistingAccount (){
        String username = Global.config.getString("homepage.account.mail");
        String pwd = Global.config.getString("homepage.account.pass");
        on(LoginPage.class).InputLogin(username,pwd);
    }
    @And("^I click on log in button")
    public void ProcessLogIn ()
    {
        on(LoginPage.class).ClickToLogin();
    }
    @When("^I back to HomePage")
    public void backToHomePage() {
        on(HomePage.class).backToHomePage();

    }

    @Then("^I select random product have COD")
    public void selectCodProduct (){
        //Global.browser.goTo("dsjakdslaj");
        //hp_Base.visit_URL("https://www.daraz.com.bd/-i100039713-s1013854700.html?");
        visit(PdpPage.class);
    }

    @Then("^I click on buy now that product")
    public void processBuyNow(){
        on(PdpPage.class).clickToBuyNow();
    }

    @Then("I add product to cart successfully")
    public void addProductToCart () {
        on(PdpPage.class).clickAddToCart();
        on(PdpPage.class).addToCartSuccess();
    }

    @Then("^I click on first place order button on shipping page")
    public void PlaceOrderBuyNow()
    {
        on(CheckoutPage.class).placeOrder();
    }

    @And("^I select all items in Cart")
    public void SelectAllItems(){
        on(cartPage.class).SelectAllItems();
    }
    @Then("^I select COD on payment page")
    public void SelectCOD () {
        on(CheckoutPage.class).selectCOD();

    }

    @Then("^I confirm order")
    public void ConfirmOrder(){
        on(CheckoutPage.class).confirmOrder();
    }

    @And("Order is successful place")

    public void checkOrder () {
        on(SuccessPage.class).checkSuccessfull();
    }

    @Then("^I go to Cart successful")

    public void goToCart(){
        on(PdpPage.class).goToCart();

    }

    @Then("^I go to Checkout Page")

    public void goToCheckout() {
        on(cartPage.class).processCheckout();
    }
}
