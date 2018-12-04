package homepage.desktop.pages;

import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(xpath = "//*[@id='topActionCustomCare']/div/div/ul/li[1]/a") private WebElement helpCenter_lbl;

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
        waitUntilVisible(helpCenter_lbl);
        return (customerCareItems_lbl.isDisplayed() && helpCenter_lbl.getText().equals(Global.config.getString("homepage.help_center_text")) );
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

