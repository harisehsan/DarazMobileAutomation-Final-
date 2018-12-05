package homepage.desktop.pages;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
    @FindBy(css = ".care-item-anchor") private WebElement customerCareItems_lbl;
    @FindBy(css = "#topActionCustomCare a[href*='helpcenter'] span.help-center") private WebElement helpCenter_lbl;
    @FindBy(css = ".lzd-switch-item.currentSelected") private WebElement currentLanguage_lbl;
    @FindBy(css = "#topActionSwitchLang") private WebElement switchLanguage_lbl;
    @FindBy(css = "[data-lang=en]") private WebElement switchToEnglishLanguage_lbl;
    @FindBy(css = "#topActionCustomCare .care-list") private WebElement customerCare_list;

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

    public boolean switchLanguage() {
        waitUntilPageReady();
        List<WebElement> elements = checkIfExists(swithLanguage_lbl_by);
        if (elements.size() > 0) {
                if (currentLanguage_lbl.getAttribute("data-lang").equals("vi") || currentLanguage_lbl.getAttribute("data-lang").equals("th")) {
                    switchLanguage_lbl.click();
                    waitUntilVisible(switchToEnglishLanguage_lbl);
                    switchToEnglishLanguage_lbl.click();
                    waitUntilPageReady();
                    return checkPageSwitchSuccessful();
                }
                return true;
        }
        return true;
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
}

