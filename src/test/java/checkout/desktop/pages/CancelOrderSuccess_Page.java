package checkout.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CancelOrderSuccess_Page extends PageObject {

    @FindBy(css = ".cancel-success") private WebElement cancelSuccess;

    public boolean hasCancelSuccessTitle() {
        waitUntilVisible(cancelSuccess);
        return cancelSuccess.isDisplayed();
    }
}