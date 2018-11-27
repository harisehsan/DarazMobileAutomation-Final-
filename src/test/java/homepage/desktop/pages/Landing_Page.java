package homepage.desktop.pages;


import base.*;
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
        result = url.contains("lazada");
        Assert.assertTrue(result,"Fail cannot reach Google Play Landing Page");
    }
}
