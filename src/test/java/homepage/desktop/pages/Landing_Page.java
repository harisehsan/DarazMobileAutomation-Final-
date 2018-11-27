package homepage.desktop.pages;


import base.*;
import org.testng.Assert;

public class Landing_Page extends PageObject {

    boolean result;

    public void verifyAppLandingPage() {
        String url = currentUrl();
        result = url.contains("app");
        Assert.assertTrue(result,"Fail cannot reach App Landing Page");
    }

    public void verifyGoogleLandingPage() {
        String url = currentUrl();
        result = url.contains("lazada");
        Assert.assertTrue(result,"Fail cannot reach Google Play Landing Page");
    }
}
