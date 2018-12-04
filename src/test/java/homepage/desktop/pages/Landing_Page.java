package homepage.desktop.pages;


import base.*;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.regex.Pattern;

public class Landing_Page extends PageObject {

    @FindBy(xpath = "//*[@id=\'container\']/div/div[1]/div/div[2]/span") private WebElement helpCenterBreadCrum_lbl;

    public boolean isAppLandingPage() {
        String url = currentUrl();
        return Pattern.compile(Pattern.quote("app"),Pattern.CASE_INSENSITIVE).matcher(url).find();
    }

    public boolean isPlayStoreLandingPage() {
        return currentUrl().contains(Global.config.getString("homepage.playstore_url"));
    }

    public boolean isAppStoreLandingPage() {
        return currentUrl().contains(Global.config.getString("homepage.appstore_id"));
    }

    public boolean isSellOnLazadaLandingPage() {
        waitUntilPageReady();
        return currentUrl().contains(Global.config.getString("homepage.sell_on_site_url"));
    }

    public boolean isHelpCenterLandingPage() {
        waitUntilPageReady();
        return (helpCenterBreadCrum_lbl.getText().equals(Global.config.getString("homepage.help_center_text")));
    }
}
