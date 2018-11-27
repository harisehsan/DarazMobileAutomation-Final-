package homepage.desktop.pages;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.*;

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
    @FindBy(css = ".app-google")
    private WebElement GoogleQR;

    private By PopUpApp_by = By.cssSelector("#top-popup-content lzd-download-content");

    public void clickToLoginPage() {
        waitUntilVisible(LoginBtn);
        LoginBtn.click();
    }

    public void backToHomePage() {
        waitUntilVisible(userName);
    }

    public void clickToAppLandingPage() {
        waitUntilPageReady();
        //waitUntilClickable(PopUpApp_by);
        AppLPTxt.click();
        waitUntilPageReady();
    }

    public void clickToAppPopupBtn() {
        waitUntilPageReady();
        waitUntilVisible(AppPopupBtn);
        AppPopupBtn.click();
        waitUntilVisible(AppLPTxt);

    }

    public boolean verifyAppPopUp() {
        if (PromotionTxt.isDisplayed()) {
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
        GoogleQR.click();
    }
}

