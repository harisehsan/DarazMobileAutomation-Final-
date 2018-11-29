package homepage.desktop.pages;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.*;

public class Home_Page extends PageObject {

    public static final String page_url = Global.config.getString("homepage.home_url");
    @FindBy(css = "#anonLogin") private WebElement login_btn;
    @FindBy(css = "#topActionDownload") private WebElement appPopup_btn;
    @FindBy(css = ".get-the-app-download-text") private WebElement appLP_txtArea;
    @FindBy(css = ".promotion-text") private WebElement promotion_txtArea;
    @FindBy(css = ".app-google") private WebElement playStore_icon;
    @FindBy(css = ".app-apple") private WebElement appStore_icon;
    private By PopUpApp_by = By.cssSelector("#top-popup-content lzd-download-content");

    public void clickToLoginPage() {
        waitUntilVisible(login_btn);
        login_btn.click();
    }

    public void clickToAppLandingPage() {
        waitUntilPageReady();
        appLP_txtArea.click();
        waitUntilPageReady();
    }

    public void clickToAppPopupBtn() {
        waitUntilPageReady();
        waitUntilVisible(appPopup_btn);
        appPopup_btn.click();
        waitUntilVisible(appLP_txtArea);
    }

    public boolean verifyAppPopUp() {
        return promotion_txtArea.isDisplayed();
    }

    public boolean isItDarazSite() {
        if (currentUrl().contains("daraz") || currentUrl().contains("shop")) {
            return true;
        } else
            return false;
    }


    public void clickOnPlayQRCode() {
        waitUntilPageReady();
        if (isItDarazSite()) {
            if (currentUrl().contains("daraz"))
                Global.map.put("whichSite", "daraz");
            else
                Global.map.put("whichSite", "shop");
        } else {
            Global.map.put("whichSite", "lazada");
        }
        playStore_icon.click();
    }

    public void clickOnAppStoreIcon() {
        waitUntilPageReady();
        if (isItDarazSite()) {
            if (currentUrl().contains("daraz"))
                Global.map.put("whichSite", "daraz");
            else
                Global.map.put("whichSite", "shop");
        } else {
            Global.map.put("whichSite", "lazada");
        }
        appStore_icon.click();
    }
}

