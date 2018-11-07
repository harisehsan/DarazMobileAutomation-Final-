package ngoc_checkout_practice.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutSuccess_Page extends PageObject {
    @FindBy (css = ".thank-you-heading") WebElement thankyouTitle;

    public boolean hasThankyouTitle() {
        waitUntilVisible(thankyouTitle);
        return thankyouTitle.isDisplayed();
    }

}
