package homepage.desktop.pages;


import base.*;
import global.Global;
import org.testng.Assert;

import java.util.regex.Pattern;

public class Landing_Page extends PageObject {

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
}
