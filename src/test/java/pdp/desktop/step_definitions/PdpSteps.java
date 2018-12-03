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
        on(Pdp_Page.class).switchToEnglish();
    }

    @When("^I click wishlist icon$")
    public void addToWishlist() {
        on(Pdp_Page.class).addToWishlist();
    }

    @Then("^I should see wishlist icon turns to orange$")
    public void isWishlistIconChangedColor() {
        Assert.assertEquals(on(Pdp_Page.class).currentWishlistIconColor(), Global.config.getString("pdp.wishlist_clicked_icon_color"));
    }

    @Then("^I should see the product on My wishlist page$")
    public void isProductMovedToMyWishlist() {
        on(Pdp_Page.class).openWishlistPage();
        Assert.assertTrue(on(MyWishlist_Page.class).isProductDisplayedInMyWishlist(), "Product is not displayed in My wishlist page");
    }

    @When("^I ask a (.*?)$")
    public void askQuestion(String questionType) {
        switch (questionType) {
            case "valid_question":
                on(Pdp_Page.class).askQuestion(Global.config.getString("pdp.ask_valid_question"));
                break;
            case "question_contain_email":
                on(Pdp_Page.class).askQuestion(Global.config.getString("pdp.question_contain_email"));
                break;
            case "question_contain_phonenumber":
                on(Pdp_Page.class).askQuestion(Global.config.getString("pdp.question_contain_phonenumber"));
                break;
            case "question_contain_externalWebLink":
                on(Pdp_Page.class).askQuestion(Global.config.getString("pdp.question_contain_externalWebLink"));
                break;
        }
    }

    @Then("^I should see valid_question on the question list$")
    public void getFirstQuestion() {
        Assert.assertEquals(on(Pdp_Page.class).getFirstQuestion(), Global.config.getString("pdp.ask_valid_question"), "Verification failed: Valid question is not found");
    }

    @Then("^I should see error message that (.*?)$")
    public void errorMessageForInvalidQuestion(String errorMessage) {
        switch (errorMessage) {
            case "question_should_not_contain_email":
                Assert.assertEquals(on(Pdp_Page.class).errorMessageForInvalidQuestion(), Global.config.getString("pdp.error_message_for_question_contain_email"), "Verification failed: No error message for invalid question");
                break;
            case "question_should_not_contain_phonenumber":
                Assert.assertEquals(on(Pdp_Page.class).errorMessageForInvalidQuestion(), Global.config.getString("pdp.error_message_for_question_contain_phonenumber"), "Verification failed: No error message for invalid question");
                break;
            case "question_should_not_contain_externalWebLink":
                Assert.assertEquals(on(Pdp_Page.class).errorMessageForInvalidQuestion(), Global.config.getString("pdp.error_message_for_question_contain_externalWeblink"), "Verification failed: No error message for invalid question");
                break;
        }

    }

    @And("^I click Chat Now$")
    public void chatNow() {
        on(Pdp_Page.class).chatNow();
    }

    @Then("^I should see Chat Now screen popup$")
    public void isMessagePopupDisplayed() {
        Assert.assertTrue(on(Pdp_Page.class).isMessageViewOpened(),"No message view is open");
    }

    @Then("^I should see lead time section$")
    public void checkLeadTimeInfo() {
        Assert.assertTrue(on(Pdp_Page.class).isLeadtimeInfoDisplayed());
    }

    @And("^I click on Add to cart button$")
    public void clickAddToCart() {
        on(Pdp_Page.class).clickAddToCartButton();
    }

    @And("^I click on Add to cart button as a guest$")
    public void addToCartBeforeLogin() {
        on(Pdp_Page.class).clickAddToCartButtonBeforeLogin();
    }

    @Then("^I should see Login form$")
    public void isLoginFormDisplayed() {
        Assert.assertTrue(on(Pdp_Page.class).isLoginFormDisplayed());
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
        Assert.assertTrue(on(CheckoutShipping_Page.class).isOnCheckoutShipping(), "User is not directed to Checkout Shipping page");
    }

    @And("^I click plus icon to increase quantity$")
    public void increaseQuantity() {
        on(Pdp_Page.class).increaseProductQuantity();
    }

    @And("^I click minus icon to decrease quantity$")
    public void decreaseQuantity() {
        on(Pdp_Page.class).decreaseProductQuantity();
    }

    @Then("^I should see product quantity is (.*?)$")
    public void checkItemQuantity(int quantity) {
        Assert.assertEquals(quantity, on(Pdp_Page.class).getItemQuantity(), "Product quantity is not correct");
    }

    @And("^I enter a number that equals to maximum available quantity$")
    public void enterQuantity() {
        Global.map.put("Max_Available_Quantity", on(Pdp_Page.class).getMaxAvailableQuantity());
        int number = (int) Global.map.get("Max_Available_Quantity");

        on(Pdp_Page.class).enterProductQuantity(number);
    }

    @Then("^I should see that quantity number cannot exceed more than maximum available quantity$")
    public void checkItemQuantityCanBeInputed() {
        Assert.assertEquals(Global.map.get("Max_Available_Quantity"), on(Pdp_Page.class).getItemQuantity(), "Maximum Quantity that can be inputted is not correct");
    }

    @Then("^I should see product quantity on Cart same to quantity on pdp$")
    public void isProductQuantityInCartSameToItemQuantityOnPdp() {
        Assert.assertEquals(on(Pdp_Page.class).getItemQuantity(), on(Cart_PopUp.class).getItemQuantity(), "Incorrect quantity of product added to cart");
    }

}
