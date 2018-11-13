package ngoc_checkout_practice.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPaymentMethod_Page extends PageObject {

    @FindBy (xpath = "//div[@class='title'][contains(.,'Cash on Delivery')]") private WebElement CODPayment;
    @FindBy (css = ".automation-btn-place-order") private WebElement confirmOrder;

    public void selectCOD()
    {
        waitUntilVisible(CODPayment);
        CODPayment.click();
    }

    public void clickConfirmOrderButton()
    {
        waitUntilVisible(confirmOrder);
        confirmOrder.click();
    }

}
