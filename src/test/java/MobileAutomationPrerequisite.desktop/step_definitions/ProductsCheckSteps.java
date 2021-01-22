package MobileAutomationPrerequisite.desktop.step_definitions;

import MobileAutomationPrerequisite.desktop.pages.Products_Check_Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class ProductsCheckSteps {
    Products_Check_Page products_check_page = new Products_Check_Page();
    @When("I search for the {int} SKU from {string} property file")
    public void iSearchForTheFromPropertyFile(int productNumber, String productFile) throws IOException {
        products_check_page.productCheck(productNumber,productFile);
    }
    @And("I goto the product")
    public void andIGotoTheProduct() {
        products_check_page.goToProduct();
    }

    @Then("I verify that the product is in stock")
    public void iVerifyThatTheIsInStock() {
        Assert.assertFalse(products_check_page.verifyTheOutOfStock(),"This product is out of stock!");
    }


    @Then("I verify the existence of chat feature on this product")
    public void iVerifyTheExistenceOfChatFeatureOnThisProduct() {
      Assert.assertTrue(products_check_page.verifyTheExistenceOfChatFeatureOnPdp(),"Chat feature is not available on this product!");
    }

    @And("I select the last SKU of product")
    public void iSelectTheLastSKUOfProduct() {
        products_check_page.selectTheLaskSku();
    }

    @Then("I verify the existence of {string} promotion on Pdp")
    public void iVerifyTheExistenceOfPromotionOnPdp(String promotionName) {
       Assert.assertTrue(products_check_page.verifyTheExistenceOfPromotion(promotionName),"Required promotion is not available!");
    }

    @Then("I verify for the digital product")
    public void iVerifyForTheDigitalProduct() {
        Assert.assertTrue(products_check_page.verifyforDigitalItem(),"This product is not digital!");
    }

    @Then("I verify for the seller {string} voucher")
    public void iVerifyForTheSellerVoucher(String voucherType) {
      Assert.assertTrue(products_check_page.verifyForTheSellerVoucher(voucherType),"The seller voucher is not existed on this product");
    }

    @Then("I verify that no apostrophe sign in the product name")
    public void iVerifyThatNoApostropheSignInTheProductName() {
        Assert.assertFalse(products_check_page.verifyTheApostrphieSignInTheProductName(),"The Product name contains apostrophe sign!");
    }
}
