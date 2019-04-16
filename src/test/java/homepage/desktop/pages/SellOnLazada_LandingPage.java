package homepage.desktop.pages;

import base.PageObject;
import global.Global;

public class SellOnLazada_LandingPage extends PageObject {
    public boolean isSellOnLazadaLandingPage() {
        waitUntilPageReady();
        return currentUrl().contains(Global.getConfig().getString("homepage.sell_on_site_url"));
    }
}
