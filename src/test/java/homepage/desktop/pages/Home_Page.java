package homepage.desktop.pages;

import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Home_Page extends PageObject {

    public static final String page_url = Global.config.getString("homepage.home_url");
    @FindBy(css = "#anonLogin") private WebElement login_btn;
    @FindBy(css = "#topActionDownload") private WebElement appPopup_btn;
    @FindBy(css = ".get-the-app-download-text") private WebElement appLP_lbl;
    @FindBy(css = ".promotion-text") private WebElement promotion_lbl;
    @FindBy(css = ".app-google") private WebElement playStore_icon;
    @FindBy(css = ".app-apple") private WebElement appStore_icon;
    @FindBy(css = ".cyan") private WebElement sellOnLazada_lbl;
    @FindBy(css = "#topActionSell") private WebElement sellOnDaraz_lbl;

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

    private boolean isDarazSite() {
        return currentUrl().contains("daraz") || currentUrl().contains("shop");
    }

    public void clickOnPlayQRCode() {
        waitUntilPageReady();
        if (isDarazSite()) {
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
        if (isDarazSite()) {
            if (currentUrl().contains("daraz"))
                Global.map.put("whichSite", "daraz");
            else
                Global.map.put("whichSite", "shop");
        } else {
            Global.map.put("whichSite", "lazada");
        }
        appStore_icon.click();
    }

    public void clickOnSellOnLazada() {
        waitUntilPageReady();
        getCountryCode();
        if(isDarazSite()) {
            sellOnDaraz_lbl.click();
        }
        else {
            sellOnLazada_lbl.click();
        }
    }

    private void getCountryCode() {
        Pattern pattern = Pattern.compile("\\.([a-z]{2,3})/?$");
        Matcher matcher = pattern.matcher(currentUrl().toString());
        if (matcher.find()) {
            Global.map.put("currentCountry", matcher.group());
        }
    }
}

