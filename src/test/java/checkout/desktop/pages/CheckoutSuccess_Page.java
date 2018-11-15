package checkout.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutSuccess_Page extends PageObject {
    @FindBy (css = ".thank-you-heading") private WebElement thankyouTitle;
    @FindBy (css = ".thank-you-order-number") private WebElement orderNumber;

    public boolean hasThankyouTitle() {
        waitUntilVisible(thankyouTitle);
        return thankyouTitle.isDisplayed();
    }

    public String orderNumber(){
        waitUntilVisible(orderNumber);
        return orderNumber.getText();
    }

    public String currentURL() {
        waitUntilVisible(orderNumber);
        return this.currentUrl();
    }

}
