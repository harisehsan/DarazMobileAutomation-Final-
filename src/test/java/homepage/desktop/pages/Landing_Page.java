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
}
