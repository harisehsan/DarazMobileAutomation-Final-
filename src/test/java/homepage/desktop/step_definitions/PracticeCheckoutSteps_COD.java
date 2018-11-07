package homepage.desktop.step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homepage.desktop.pages.HomePage;
import homepage.desktop.pages.HomePage_Base;
import base.BaseSteps;

public class CheckoutSteps_COD extends BaseSteps {


    HomePage_Base hp_Base;
    HomePage hp;
    @Given("I land in HomePage ")
    public void landInHomePage() {
        hp_Base.visit_URL("https://google.com");

    }

    @When("I click on log in")
    public void landLoginPage(){
        hp.clickToLoginPage();

    }

    @Then("I input username: \"([^\"]*)\"  and pwd: \"([^\"]*)\" ")
    public void loginWithAccount (String username, String pwd) {
        hp_Base.process_Login(username,pwd);

    }

    @When("I back to HP")
    public void backToHomePage() {

    }

    @Then("I go to category")
    public void landInRandomCategory (){

    }

    @And("I Select Product")
    public void selectRandomProduct (){

    }

    @When("I reach categorypage")
    public void checkCategory ()  {

    }

    @Then("I select random product have COD")
    public void selectCodProduct (){

    }

    @Then("I add product to cart successfully")
    public void addProductToCart () {

    }

    @When("I come to cart")
    public void checkCart() {

    }


    @Then("I doing checkout step")

    public void checkoutSteps () {

    }

    @And("Order is succefull place")

    public void checkOrder () {

    }
}
