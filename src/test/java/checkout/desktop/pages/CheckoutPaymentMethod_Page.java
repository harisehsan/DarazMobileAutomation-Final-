package checkout.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class CheckoutPaymentMethod_Page extends PageObject {

    @FindAll({@FindBy (xpath = "//div[@class='title'][contains(.,'Cash on Delivery')]"),@FindBy (xpath = "//div[@class='title'][contains(.,'Bayar di Tempat')]")}) private WebElement CODPayment_link;
    @FindBy (css = ".automation-btn-place-order") private WebElement confirmOrder;

    public void selectCOD()
    {
        waitUntilVisible(CODPayment_link);
        CODPayment_link.click();
    }

    public void clickConfirmOrderButton()
    {
        waitUntilVisible(confirmOrder);
        confirmOrder.click();
    }

}
