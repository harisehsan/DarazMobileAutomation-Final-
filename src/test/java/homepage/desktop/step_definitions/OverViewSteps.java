package homepage.desktop.step_definitions;


import cucumber.api.java.en.And;
import base.BaseSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homepage.desktop.pages.CustomerCare_LandingPage;
import homepage.desktop.pages.Home_Page;
import homepage.desktop.pages.Landing_Page;
import homepage.desktop.pages.SellOnLazada_LandingPage;
import org.testng.Assert;

import java.io.IOException;

public class OverViewSteps extends BaseSteps {

    @When("^I go to HomePage")
    public void landInHomePage() {
        visit(Home_Page.class);
//        on(Home_Page.class).switchToEnglish();
    }

    @Then("^I click on log in to login page")
    public void landLoginPage()
    {
        on(Home_Page.class).clickToLoginPage();
    }

    @And ("I click on Save More on App button")
    public void clickSaveMoreBtn () {
        on(Home_Page.class).clickToAppPopupBtn();
    }

    @Then("^I see pop up is display")
    public void popUpIsDisplay()  {
        Assert.assertTrue(on(Home_Page.class).verifyAppPopUp(),"Pop up can't display");
    }

    @Then("^I see Customer Care pop up is display")
    public void customerCarePopUpIsDisplayed()  {
        Assert.assertTrue(on(Home_Page.class).isCustomerCarePopUpDisplayed(),"Customer Care Pop up can't display");
    }

    @And ("I click on App benefit text")
    public void clickAppBenefitTxt () {
        on(Home_Page.class).clickToAppLandingPage();
    }

    @Then("^I should land on App Page")
    public void verifyAppLandingPage()  {
        Assert.assertTrue( on(Landing_Page.class).isAppLandingPage(),"Fail cannot reach App Landing Page");
    }

    @And("^I click on Google Play icon")
    public void clickOnGooglePlayIcon()
    {
        on(Home_Page.class).clickOnPlayQRCode();
    }

    @Then("^I should land on Google Play Page")
    public void verifyGoogleLandingPage()  {
        Assert.assertTrue(on(Landing_Page.class).isPlayStoreLandingPage(), "Fail cannot reach Play Store Landing Page");
    }

    @And("^I click on App Store icon")
    public void clickOnAppStoreIcon()
    {
        on(Home_Page.class).clickOnAppStoreIcon();
    }

    @Then("^I should land on App Store Page")
    public void verifyAppStoreLandingPage()  {
        Assert.assertTrue(on(Landing_Page.class).isAppStoreLandingPage(), "Fail cannot reach App Store Landing Page");
    }

    @And("^I click on Sell On Lazada label")
    public void clickOnSellOnLazada() {
        on(Home_Page.class).clickOnSellOnLazada();
    }

    @And("^I click on Customer Care label")
    public void clickOnCustomerCareLabel() {
        on(Home_Page.class).clickOnCustomerCareLabel();
    }

    @Then ("^I should land on Sell On Lazada Page")
    public void verifySellOnLazadaLandingPage() {
        Assert.assertTrue(on(SellOnLazada_LandingPage.class).isSellOnLazadaLandingPage(),"Can't land on Sell On Lazada/Daraz Landing Page");
    }

    @And ("^I click on Help Center label")
    public void clickOnHelpCenterLabel() {
        on(Home_Page.class).clickOnHelpCenterLabel();
    }

    @Then ("^I should land on Help Center Page")
    public void isHelpCenterLandingPage() {
        Assert.assertTrue(on(CustomerCare_LandingPage.class).isHelpCenterLandingPage(),"Can't land on Help Center Landing Page");
    }

    @And ("^I scroll to Just For You part")
    public void scrollToJustForYou() {
        on(Home_Page.class).scrollToJustForYou();
    }

    @Then ("^I should see Just For You module")
    public void isJustForYouDisplayed() {
        on(Home_Page.class).isJustForYouDisplayed();
    }

    @Then("^I should see category tree")
    public void isCategoryTreeDisplayed () {
        Assert.assertTrue(on(Home_Page.class).isCategoryTreeDisplayed(),"No category displayed");
    }

    @And("^I select random category level \"(\\d+)\" on Categories Tree$")
    public void selectRandomCategory(int depth) throws IOException {
        on(Home_Page.class).selectRandomCategoryLevel(depth);
    }

    @Then("^I should see category page that I selected")
    public void isCategoryLevel2LandingPage() throws IOException {
        Assert.assertTrue(on(Home_Page.class).isCategoryLevel2LandingPage(),"Wrong category displayed");
    }
}
