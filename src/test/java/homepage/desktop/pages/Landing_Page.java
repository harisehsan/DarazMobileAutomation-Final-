package homepage.desktop.pages;


import base.*;
import global.Global;
import org.testng.Assert;

import java.util.regex.Pattern;

public class Landing_Page extends PageObject {

    boolean result;
    public void verifyAppLandingPage() {
        String url = currentUrl();
        result = Pattern.compile(Pattern.quote("app"),Pattern.CASE_INSENSITIVE).matcher(url).find();
        Assert.assertTrue(result,"Fail cannot reach App Landing Page");
    }

    public void verifyGoogleLandingPage() {
        String url = currentUrl();
        String site=Global.map.get("whichSite").toString();
        if(site.contains(Global.config.getString("homepage.lazada_name")))
        {
            result = url.contains(Global.config.getString("homepage.lazada_name"));
            Assert.assertTrue(result, "Fail cannot reach Lazada Google Play Store Landing Page");
        }
        else if (site.contains(Global.config.getString("homepage.daraz_name")))
        {
            result = url.contains(Global.config.getString("homepage.daraz_name"));
            Assert.assertTrue(result, "Fail cannot reach Daraz Google Play Store Landing Page");
        }
        else
        {
            result = url.contains(Global.config.getString("homepage.shop_name"));
            Assert.assertTrue(result, "Fail cannot reach Shop Google Play Store Landing Page");
        }
    }

    public void verifyAppStoreLandingPage() {
        String url = currentUrl();
        String site=Global.map.get("whichSite").toString();
        if(site.contains(Global.config.getString("homepage.lazada_name")))
        {
            result = url.contains(Global.config.getString("homepage.lazada_appstore_id"));
            Assert.assertTrue(result, "Fail cannot reach Lazada App Store Landing Page");
        }
        else if (site.contains(Global.config.getString("homepage.daraz_name")))
        {
            result = url.contains(Global.config.getString("homepage.daraz_appstore_id"));
            Assert.assertTrue(result, "Fail cannot reach Daraz App Store Landing Page");
        }
        else
        {
            result = url.contains(Global.config.getString("homepage.shop_appstore_id"));
            Assert.assertTrue(result, "Fail cannot reach Shop App Store Landing Page");
        }
    }

    public boolean verifySellOnLazadaLandingPage() {
        waitUntilPageReady();
        String countryCode = Global.map.get("currentCountry").toString();
        if (isDarazSite()) {
            if (countryCode.contains("mm")) {
                return (currentUrl().contains(countryCode) && currentUrl().contains(Global.config.getString("homepage.sellOn_shop_text")));
            } else if (countryCode.contains("lk")) {
                return (currentUrl().contains(countryCode) && currentUrl().contains("Sell"));
            } else {
                return (currentUrl().contains(countryCode) && currentUrl().contains(Global.config.getString("homepage.sellOn_daraz_text")));
            }
        } else {
            if (countryCode.contains("ph")) {
                return (currentUrl().contains(countryCode) && currentUrl().contains("PHCampaign"));
            } else {
                return (currentUrl().contains(countryCode) && currentUrl().contains(Global.config.getString("homepage.sellOn_lazada_text")));
            }
        }
    }

    private boolean isDarazSite() {
        return currentUrl().contains("daraz") || currentUrl().contains("shop");
    }
}
