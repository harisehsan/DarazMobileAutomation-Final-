package homepage.desktop.pages;


import base.*;
import global.Global;

import java.util.regex.Pattern;

public class Landing_Page extends PageObject {
    public boolean isAppLandingPage() {
        String url = currentUrl();
        return Pattern.compile(Pattern.quote("app"),Pattern.CASE_INSENSITIVE).matcher(url).find();
    }

    public boolean isPlayStoreLandingPage() {
        return currentUrl().contains(Global.getConfig().getString("homepage.playstore_url"));
    }

    public boolean isAppStoreLandingPage() {
        return currentUrl().contains(Global.getConfig().getString("homepage.appstore_id"));
    }
}
