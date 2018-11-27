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
}
