package homepage.desktop.pages;

import _base.page_helpers.BuyerSitePageHelper;
import base.PageObject;
import global.Global;
import helper.RandomHelper;
import helper.UrlHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;
import java.util.Random;


public class Home_Page extends PageObject {

    public static final String page_url = Global.getConfig().getString("homepage.home_url");
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
    @FindBy(css = (".lzd-site-menu-grand-active > li")) private List<WebElement> categoriesLevel3Tree_list;
    @FindBy(id = "q") private WebElement searchBar;
    @FindBy(className = "search-box__button--1oH7") private WebElement searchBarButton;
    @FindBy(className = "ant-modal-content")  private WebElement ageLimit_popup; //lazada element

    private By categoriesLevel3Tree_by = By.cssSelector(".lzd-site-menu-grand-active");
    private By iAmOver18_btn = By.className("ant-btn-primary");


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
        return customerCare_list.isDisplayed() && customerCare_list.getText().contains(Global.getConfig().getString("homepage.help_center_text"));
    }

    public void switchToEnglish() {
        BuyerSitePageHelper.switchToEnglish();
    }

    private List<WebElement> checkIfExists(By selector) {
        return Global.getBrowser().getWebDriver().findElements(selector);
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

    public void scrollToJustForYou() { }

    public void isJustForYouDisplayed() {
        waitUntilPageReady();
    }

    public boolean isCategoryTreeDisplayed() {
        return categoriesTree_lbl.isDisplayed();
    }

    public void selectRandomCategoryLevel(int depth) throws IOException {
        int randomNumber = RandomHelper.randomNumberInRange(rootCategories_lbl.size() - 1, 0);
        rootCategories_lbl.get(randomNumber).click();
        String currentCssSelect = ("." + rootCategories_lbl.get(randomNumber).getAttribute("id") + " > li");
        By categoriesLevel_2_list_by = By.cssSelector(currentCssSelect);
        waitUntilVisibility(categoriesLevel_2_list_by);
        List<WebElement> categoriesLevel2_list = menu_lbl.findElements(categoriesLevel_2_list_by);
        int randomNumberForCat2 = RandomHelper.randomNumberInRange(categoriesLevel2_list.size() - 1, 0);
        if (depth == 2) {
            selectRandomCategoryLevelTwo(categoriesLevel2_list, currentCssSelect, randomNumberForCat2);
        } else if (depth == 3) {
            selectRandomCategoryLevelThree(categoriesLevel2_list, randomNumberForCat2);
        }
    }

    private void selectRandomCategoryLevelTwo(List<WebElement> categoriesLevel2_list, String currentCssSelect, int randomNumberForCat2) throws IOException {
        if (!isHrefLinkWork(categoriesLevel2_list, currentCssSelect, randomNumberForCat2)) {
            throw new RuntimeException();
        } else categoriesLevel2_list.get(randomNumberForCat2).click();
    }

    private void selectRandomCategoryLevelThree(List<WebElement> categoriesLevel2_list, int randomNumberForCat2) throws IOException {
        hover(categoriesLevel2_list.get(randomNumberForCat2));
        waitUntilVisibility(categoriesLevel3Tree_by);
        int randomNumberForCat3 = RandomHelper.randomNumberInRange(categoriesLevel3Tree_list.size() - 1, 0);
        if (!isHrefLinkWork(randomNumberForCat3)) {
            throw new RuntimeException();
        } else categoriesLevel3Tree_list.get(randomNumberForCat3).click();
    }

    private boolean isHrefLinkWork(List<WebElement> currentCategory, String currentCssSelect, int randomNumber) throws IOException {
        By href = By.cssSelector(currentCssSelect + " > a");
        WebElement hrefLandingPage_String = currentCategory.get(randomNumber).findElement(href);
        String hrefUrl = hrefLandingPage_String.getAttribute("href");
        return UrlHelper.isUrlOK(hrefUrl);
    }

    private boolean isHrefLinkWork(int randomNumber) {
        WebElement hrefLandingPage_String = categoriesLevel3Tree_list.get(randomNumber).findElement(By.cssSelector(".lzd-site-menu-grand-active > li >a"));
        String hrefUrl = hrefLandingPage_String.getAttribute("href");
        return UrlHelper.isUrlOK(hrefUrl);
    }

    public boolean isCategoryLevel2LandingPage() {
        return UrlHelper.isUrlOK(currentUrl());
    }

    public void searchKeyword(String arg0){
        Random random = new Random();
        if(arg0.equalsIgnoreCase("Random")){
            String[] keyWords = {"women dresses","men dresses"};
            int position = random.nextInt(keyWords.length);
            searchBar.sendKeys(keyWords[position]);
        }else {
            searchBar.sendKeys(arg0);
        }
        this.searchBarButton.click();
        ageLimitVerification();
    }

    public void ageLimitVerification(){
        try {
            ageLimit_popup.findElement(iAmOver18_btn).click();
        }catch (Exception e ){
            System.out.println("AGE LIMIT POPUP NOT DISPLAYED");
        }
    }
}



