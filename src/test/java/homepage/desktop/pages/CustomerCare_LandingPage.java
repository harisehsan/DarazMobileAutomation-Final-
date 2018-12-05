package homepage.desktop.pages;

import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerCare_LandingPage extends PageObject {

    @FindBy(css = "[data-spm=helpcenter]") private WebElement helpCenter_lbl;

    public boolean isHelpCenterLandingPage() {
        waitUntilPageReady();
        return (helpCenter_lbl.isDisplayed());
    }
}
