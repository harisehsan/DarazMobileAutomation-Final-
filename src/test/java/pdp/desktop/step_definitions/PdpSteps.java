package pdp.desktop.step_definitions;

import base.BaseSteps;
import checkout.desktop.pages.Cart_PopUp;
import checkout.desktop.pages.CheckoutShipping_Page;
import cucumber.api.java.en.And;
import pdp.desktop.pages.MyWishlist_Page;
import pdp.desktop.pages.Pdp_Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Global;
import org.testng.Assert;


public class PdpSteps extends BaseSteps {
    @Given("^I go to a normal pdp page$")
    public void visitNormalPdpPage() {
        Pdp_Page.setUrl(Global.config.getString("pdp.normal_pdp_url"));
        visit(Pdp_Page.class);
        on(Pdp_Page.class).closeShippingFromOverseaPopup();
    }

    @When("^I click wishlist icon$")
    public void addToWishlist() {
        on(Pdp_Page.class).addToWishlist();
    }

    @Then("^I should see wishlist icon turns to orange$")
    public void wishlistIconClicked() {
        Assert.assertEquals(on(Pdp_Page.class).wishlistIconClicked(), "rgba(245, 114, 36, 1)");
    }

    @Then("^I should see the product on My wishlist page$")
    public void productMovedToMyWishlist() {
        on(Pdp_Page.class).clickMyWishlistMenu();
        on(MyWishlist_Page.class).checkProductExistInMyWishlist();
    }

    @When("^I ask a (.*?)$")
    public void askQuestion(String question) {
        if (question.equals("valid_question")) {
            on(Pdp_Page.class).askQuestion(Global.config.getString("pdp.ask_valid_question"));
        } else if (question.equals("question_include_email")) {
            on(Pdp_Page.class).askQuestion(Global.config.getString("pdp.question_include_email"));
        } else if (question.equals("question_include_phonenumber")) {
            on(Pdp_Page.class).askQuestion(Global.config.getString("pdp.question_include_phonenumber"));
        } else if (question.equals("question_include_externalWebLink")) {
            on(Pdp_Page.class).askQuestion(Global.config.getString("pdp.question_include_externalWebLink"));
        }
    }

    @Then("^I should see valid_question on the question list$")
    public void firstQuestion() {
        Assert.assertEquals(on(Pdp_Page.class).getFirstQuestion(), Global.config.getString("pdp.ask_valid_question"), "Verification failed: Valid question is not found");
    }

    @Then("^I should see error message that (.*?)$")
    public void errorMessageForInvalidQuestion(String errorMessage) {
        if (errorMessage.equals("question_should_not_contain_email")) {
            Assert.assertEquals(on(Pdp_Page.class).errorMessageForInvalidQuestion(), "Your question should not contain email.", "Verification failed: No error message for invalid question");
        } else if (errorMessage.equals("question_should_not_contain_phonenumber")) {
            Assert.assertEquals(on(Pdp_Page.class).errorMessageForInvalidQuestion(), "Your question should not contain phone number.", "Verification failed: No error message for invalid question");
        } else if (errorMessage.equals("question_should_not_contain_externalWebLink")) {
            Assert.assertEquals(on(Pdp_Page.class).errorMessageForInvalidQuestion(), "Your question should not contain external url(s)", "Verification failed: No error message for invalid question");
        }

    }

    @And("^I click Chat Now$")
    public void chatNow() {
        on(Pdp_Page.class).chatNow();
    }

    @Then("^I should see Chat Now screen popup$")
    public void checkMessagePopup() {
        on(Pdp_Page.class).checkMessageViewPopup();
    }

    @Then("^I should see lead time section$")
    public void checkLeadTime() {
        Assert.assertTrue(on(Pdp_Page.class).checkLeadTimeExist());
    }

    @And("^I click on Add to cart button$")
    public void clickAddToCart() {
        on(Pdp_Page.class).clickAddToCartButton();
    }

    @And("^I click on Add to cart button - user not login$")
    public void addToCartBeforeLogin() {
        on(Pdp_Page.class).clickAddToCartButtonBeforeLogin();
    }

    @Then("^I should see Login form$")
    public void loginFormExist() {
        Assert.assertTrue(on(Pdp_Page.class).loginFormExist());
    }

    @When("^I close Login form$")
    public void closeLoginForm() {
        on(Pdp_Page.class).closeLoginForm();
    }

    @And("^I click on Buy Now button$")
    public void clickBuyNow() {
        on(Pdp_Page.class).clickBuyNow();
    }

    @Then("^I should see Cart popup with product added to Cart$")
    public void addToCartSuccess() {
        Assert.assertTrue(on(Pdp_Page.class).addToCartSuccessMessage());
    }

    @When("^I close Cart popup$")
    public void closeCartPopup() {
        on(Pdp_Page.class).closeCartPopup();
    }

    @Then("^I should be on Checkout Shipping page$")
    public void onCheckoutShipping() {
        on(CheckoutShipping_Page.class).onCheckoutShipping();
    }

    @And("^I click plus icon to increase quantity$")
    public void increaseQuantity() {
        on(Pdp_Page.class).increaseQuantity();
    }

    @And("^I click minus icon to decrease quantity$")
    public void decreaseQuantity() {
        on(Pdp_Page.class).decreaseQuantity();
    }

    @Then("^I should see product quantity is (.*?)$")
    public void checkItemQuantity(String quantity) {
        Assert.assertEquals(quantity, on(Pdp_Page.class).itemQuantity());
    }

    @And("^I get maximum available number of product$")
    public void getMaxAvailableQuantity() {
        Global.map.put("Max Available Quantity", on(Pdp_Page.class).maxAvailableQuantity());
    }

    @And("^I enter a number that (.*?) maximum number$")
    public void enterQuantity(String condition) {
        int number = (int) Global.map.get("Max Available Quantity");

        if (condition.equals("equal to")) {
            on(Pdp_Page.class).enterQuantity(number);
        } else if (condition.equals("greater than")) {
            on(Pdp_Page.class).enterQuantity(number + 2);
            System.out.println("aa");
        }
    }

    @Then("^I should see that quantity number is maximum number$")
    public void checkItemQuantityIsMaxNumber() {
        Assert.assertEquals(Global.map.get("Max Available Quantity").toString(), on(Pdp_Page.class).itemQuantity());
    }

    @Then("^I should see product quantity in Cart is 2$")
    public void checkProductQuantityInCart(){
        Assert.assertEquals(2, on(Cart_PopUp.class).checkItemQuantity(), "Incorrect quantity of product added to cart");
    }



}
