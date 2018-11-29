package homepage.desktop.pages;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.*;
import org.testng.Assert;
import homepage.desktop.pages.BaseHP_Steps;

public class Home_Page extends PageObject {

    public static final String page_url = Global.config.getString("homepage.home_url");
    @FindBy(css = "#anonLogin") private WebElement login_btn;
    @FindBy(css = "#topActionDownload") private WebElement appPopup_btn;
    @FindBy(css = ".get-the-app-download-text") private WebElement appLP_txtArea;
    @FindBy(css = ".promotion-text") private WebElement promotion_txtArea;

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
        if (promotion_txtArea.isDisplayed()) {
            return true;
        } else
            return false;
    }

    public boolean isItDarazSite() {
        if (currentUrl().contains("daraz") || currentUrl().contains("shop")) {
            return true;
        } else
            return false;
    }
}

