package pdp.desktop.step_definitions;

import base.BaseSteps;
import checkout.desktop.pages.Cart_PopUp;
import checkout.desktop.pages.CheckoutShipping_Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Global;
import helper.RandomHelper;
import org.testng.Assert;
import pdp.desktop.pages.MyWishlist_Page;
import pdp.desktop.pages.Pdp_Page;


public class PdpSteps extends BaseSteps {


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
        Assert.assertTrue(on(MyWishlist_Page.class).isProductDisplayed(), "Product is not displayed in My wishlist page");
    }

    @When("^I ask a (.*?)$")
    public void askQuestion(String questionType) {
        switch (questionType) {
            case "valid_question":
                String validQuestion = RandomHelper.randomSentence(10);
                on(Pdp_Page.class).askQuestion(validQuestion);
                Global.map.put("Valid_Question", validQuestion);
                break;
            case "question_contain_email":
                on(Pdp_Page.class).askQuestion(RandomHelper.randomSentence(5)+ " " + RandomHelper.randomTestMail());
                break;
            case "question_contain_phonenumber":
                on(Pdp_Page.class).askQuestion(RandomHelper.randomSentence( 5)+ " " + RandomHelper.randomNumber(8));
                break;
            case "question_contain_externalWebLink":
                on(Pdp_Page.class).askQuestion(RandomHelper.randomSentence(5) + " https://www."+RandomHelper.randomAlphabetString(5) + ".com/" + RandomHelper.randomAlphaNumericString(6));
                break;
        }
    }

    @Then("^I should see valid_question on the question list$")
    public void getFirstQuestion() {
        Assert.assertEquals(on(Pdp_Page.class).getFirstQuestion(), Global.map.get("Valid_Question"), "Verification failed: Valid question is not found");
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

    @Then("^I should see Message popup opening$")
    public void isMessagePopupDisplayed() {
        Assert.assertTrue(on(Pdp_Page.class).isMessageViewOpened(),"No message popup is open");
    }

    @Then("^I should see lead time section$")
    public void checkLeadTimeInfo() {
        Assert.assertTrue(on(Pdp_Page.class).isLeadtimeInfoDisplayed());
    }

    @And("^I click on Add to cart button on Pdp Page$")
    public void clickAddToCartFromPdp() {
        on(Pdp_Page.class).clickAddToCartButton();
    }

    @And("^I click on Add to cart button as a guest$")
    public void addToCartBeforeLogin() {
        on(Pdp_Page.class).clickAddToCartButtonBeforeLogin();
    }

    @Then("^I should see Login form$")
    public void isLoginFormDisplayed() {
        Assert.assertTrue(on(Pdp_Page.class).isLoginFormDisplayed(), "Login form is not displayed");
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
        Assert.assertTrue(on(Pdp_Page.class).addToCartSuccessMessage(), "No success message on Cart popup");
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

    @And("^I change a new address for Leadtime$")
    public void changeAddressInLeadtime() {
        String beforeChangedAddress = on(Pdp_Page.class).getCurrentAddress();
        Global.map.put("beforeChangedAddress",beforeChangedAddress);
        on(Pdp_Page.class).clickChangeLink();
        on(Pdp_Page.class).selectRandomAddress();
    }

    @Then("^I should see Leadtime with new address$")
    public void isNewAddressSelected() {
        on(Pdp_Page.class).waitUntilAddressChanged((String) Global.map.get("beforeChangedAddress"));
        Assert.assertEquals(on(Pdp_Page.class).getCurrentAddress(), on(Pdp_Page.class).randomAddress, "Random address is not selected");
    }

    @And("^I submit new postcode in Leadtime$")
    public void submitPostCode() {
        String beforeChangedAddress = on(Pdp_Page.class).getCurrentAddress();
        Global.map.put("beforeChangedAddress",beforeChangedAddress);
        on(Pdp_Page.class).clickChangeLink();
        on(Pdp_Page.class).submitPostCode(Global.config.getString("pdp.valid_postcode"));
    }

    @Then("^I should see new Leadtime address has postcode$")
    public void newAddressHasPostCode() {
        on(Pdp_Page.class).waitUntilAddressChanged((String) Global.map.get("beforeChangedAddress"));
        Assert.assertTrue(on(Pdp_Page.class).getCurrentAddress().contains(Global.config.getString("pdp.valid_postcode")));
    }

    @And("^I send a message to shop$")
    public void iSendAMessageToShop() throws Throwable {
        String message = RandomHelper.randomAlphabetString(5) + RandomHelper.randomNumber(5);
        on(Pdp_Page.class).submitMessageToShop(message);
    }

    @Then("^I should see my message in Message popup$")
    public void iShouldSeeMyMessageInMessagePopup() throws Throwable {
        Assert.assertTrue(on(Pdp_Page.class).messageListPopup().contains(on(Pdp_Page.class).getSentMessage()),"Message is not sent");
    }
}
