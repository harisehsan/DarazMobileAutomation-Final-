package homepage.desktop.pages;

import _base.page_helpers.BuyerSitePageHelper;
import base.PageObject;
import global.Global;
import helper.RandomHelper;
import helper.HttpHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;



public class Home_Page extends PageObject {

    public static final String page_url = Global.config.getString("homepage.home_url");
    @FindBy(css = "#anonLogin") private WebElement login_btn;
    @FindBy(css = "#topActionDownload") private WebElement appPopup_btn;
    @FindBy(css = ".get-the-app-download-text") private WebElement appLP_lbl;
    @FindBy(css = ".promotion-text") private WebElement promotion_lbl;
    @FindBy(css = ".app-google") private WebElement playStore_icon;
    @FindBy(css = ".app-apple") private WebElement appStore_icon;
    @FindBy(css = "#topActionCustomCare") private WebElement customerCare_lbl;
    @FindBy(css = "#topActionSell") private WebElement sellOnSite_lbl;
    @FindBy(css = "#topActionCustomCare a[href*='helpcenter'] span.help-center") private WebElement helpCenter_lbl;
    @FindBy(css = ".lzd-switch-item.currentSelected") private WebElement currentLanguage_lbl;
    @FindBy(css = "#topActionCustomCare .care-list") private WebElement customerCare_list;
    @FindBy(css = "#hp-just-for-your") private WebElement justForYou_lbl;
    @FindBy(css = ".lzd-site-nav-menu-dropdown") private WebElement categoriesTree_lbl;
    @FindBy(css = ".lzd-site-menu-root-item") private List<WebElement> rootCategories_lbl;
    @FindBy(css = ".lzd-site-menu-root") private WebElement menu_lbl;
    @FindBy(xpath = "//*[@id=\'J_breadcrumb\']/li[3]/span") private WebElement categoryLevel2_lbl;


    private By swithLanguage_lbl_by = By.cssSelector("#topActionSwitchLang");

    public void clickToLoginPage() {
        waitUntilVisible(login_btn);
        login_btn.click();
    }

    public void clickToAppLandingPage() {
        waitUntilPageReady();
        appLP_lbl.click();
        waitUntilPageReady();
    }

    public void clickToAppPopupBtn() {
        waitUntilPageReady();
        waitUntilVisible(appPopup_btn);
        appPopup_btn.click();
        waitUntilVisible(appLP_lbl);
    }

    public boolean verifyAppPopUp() {
        return promotion_lbl.isDisplayed();
    }

    public boolean isCustomerCarePopUpDisplayed() {
        waitUntilPageReady();
        return customerCare_list.isDisplayed() && customerCare_list.getText().contains(Global.config.getString("homepage.help_center_text"));
    }

    public void switchToEnglish() {
        BuyerSitePageHelper.switchToEnglish();
    }

    private List<WebElement> checkIfExists(By selector) {
        return Global.browser.getWebDriver().findElements(selector);
    }

    private boolean checkPageSwitchSuccessful() {
        return !currentLanguage_lbl.getAttribute("data-lang").equals("vi") && !currentLanguage_lbl.getAttribute("data-lang").equals("th");
    }

    public void clickOnPlayQRCode() {
        waitUntilPageReady();
        playStore_icon.click();
    }

    public void clickOnAppStoreIcon() {
        waitUntilPageReady();
        appStore_icon.click();
    }

    public void clickOnCustomerCareLabel() {
        waitUntilPageReady();
        customerCare_lbl.click();
        waitUntilPageReady();
    }

    public void clickOnSellOnLazada() {
        waitUntilPageReady();
        sellOnSite_lbl.click();
        waitUntilPageReady();
    }

    public void clickOnHelpCenterLabel() {
        waitUntilPageReady();
        helpCenter_lbl.click();
    }

    public void scrollToJustForYou() {

    }

    public void isJustForYouDisplayed() {
        waitUntilPageReady();

    }

    public boolean isCategoryTreeDisplayed() {
        waitUntilPageReady();
        return categoriesTree_lbl.isDisplayed();
    }

    public void selectRandomCategoryLevel(int depth) throws IOException {
        int randomNumber = RandomHelper.randomNumberInRange(rootCategories_lbl.size()-1,0);
        rootCategories_lbl.get(randomNumber).click();
        if (depth > 1) {
            selectRandomCategoryLevelTwo(randomNumber);
            if (depth > 2){
                selectRandomCategoryLevelThree();
            }
        }
    }

    public void selectRandomCategoryLevelTwo (int randomNumber) throws IOException {
        String currentCssSelect = ("." + rootCategories_lbl.get(randomNumber).getAttribute("id") +" > li") ;
        By categoryLevel_2_list_by = By.cssSelector(currentCssSelect);
        waitUntilVisibility(categoryLevel_2_list_by);
        List<WebElement> categoryLevel2_list = menu_lbl.findElements(categoryLevel_2_list_by);
        int randomNumberForCat2 = RandomHelper.randomNumberInRange(categoryLevel2_list.size() - 1, 0);
        By href = By.cssSelector(currentCssSelect + " > a");
        WebElement hrefLandingPage_String = menu_lbl.findElement(href);
        if (HttpHelper.checkHttpResponseCode(hrefLandingPage_String.getAttribute("href")) != 200) {
            throw new RuntimeException();
        } else categoryLevel2_list.get(randomNumberForCat2).click();
    }

    public void selectRandomCategoryLevelThree() {

    }

    public boolean isCategoryLevel2LandingPage() throws IOException {
        return (HttpHelper.checkHttpResponseCode(currentUrl()) == 200);
    }
}

