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
        visit(Home_Page.class);
    }

    @Then("^I click on log in to login page")
    public void landLoginPage()  {
        on(Home_Page.class).clickToLoginPage();
    }

    @Then("^I input username: \"([^\"]*)\"  and pwd: \"([^\"]*)\"$")
    public void loginWithAccount (String username, String pwd) {

        on(Login_Page.class).inputLogin(username,pwd);
    }

    @Then("^I input account information")
    public void loginWithExistingAccount (){
        String username = Global.config.getString("homepage.account.mail");
        String pwd = Global.config.getString("homepage.account.pass");
        on(Login_Page.class).inputLogin(username,pwd);
    }
    @And("^I click on log in button")
    public void processLogIn ()
    {
        on(Login_Page.class).ClickToLogin();
    }
    @When("^I back to HomePage")
    public void backToHomePage() {
        on(Home_Page.class).backToHomePage();

    }

    @Then("^I select random product have COD")
    public void selectCodProduct (){
        //Global.browser.goTo("dsjakdslaj");
        //hp_Base.visit_URL("https://www.daraz.com.bd/-i100039713-s1013854700.html?");
        visit(Pdp_Page.class);
    }

    @Then("^I click on buy now that product")
    public void processBuyNow(){
        on(Pdp_Page.class).clickToBuyNow();
    }

    @Then("I add product to cart successfully")
    public void addProductToCart () {
        on(Pdp_Page.class).clickAddToCart();
        on(Pdp_Page.class).addToCartSuccess();
    }

    @Then("^I click on first place order button on shipping page")
    public void placeOrderBuyNow()
    {
        on(Checkout_Page.class).placeOrder();
    }

    @And("^I select all items in Cart")
    public void selectAllItems(){
        on(Cart_Page.class).selectAllItems();
    }
    @Then("^I select COD on payment page")
    public void selectCOD () {
        on(Checkout_Page.class).selectCOD();

    }

    @Then("^I confirm order")
    public void confirmOrder(){
        on(Checkout_Page.class).confirmOrder();
    }

    @And("Order is successful place")

    public void checkOrder () {
        on(Success_Page.class).checkSuccessfull();
    }

    @Then("^I go to Cart successful")

    public void goToCart(){
        on(Pdp_Page.class).goToCart();

    }

    @Then("^I go to Checkout Page")

    public void goToCheckout() {
        on(Cart_Page.class).processCheckout();
    }
}
