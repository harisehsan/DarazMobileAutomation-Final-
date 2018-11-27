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

    @FindBy(css = "")
    public WebElement SupportPopUp;
    @FindBy(css = "#anonLogin")
    private WebElement LoginBtn;
    @FindBy(css = "#myAccountTrigger")
    private WebElement userName;
    @FindBy(css = "#topActionDownload")
    private WebElement AppPopupBtn;
    @FindBy(css = ".get-the-app-download-text")
    private WebElement AppLPTxt;
    @FindBy(css = ".promotion-text")
    private WebElement PromotionTxt;

    private By PopUpApp_by = By.cssSelector("#top-popup-content lzd-download-content");

    public void clickToLoginPage() {
        waitUntilVisible(LoginBtn);
        LoginBtn.click();
    }

    public void backToHomePage() {
        waitUntilVisible(userName);
    }

    public void clickToAppLandingPage() {
        if (isItDarazSite()) {
            waitUntilPageReady();
        } else {
            waitUntilPageReady();
            //waitUntilClickable(PopUpApp_by);
            AppLPTxt.click();
            waitUntilPageReady();
        }

    }

    public void clickToAppPopupBtn() {
        waitUntilPageReady();
        waitUntilVisible(AppPopupBtn);
        AppPopupBtn.click();
        if(isItDarazSite())
        {
            waitUntilPageReady();
        }
            else
        {
            waitUntilVisible(AppLPTxt);
        }
    }

    public boolean verifyAppPopUp() {
        if(isItDarazSite()) {
            return true;
        }
        else if (PromotionTxt.isDisplayed()) {
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

