package ngoc_checkout_practice.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart_Page extends PageObject {

    @FindBy(css = ".automation-checkout-order-total-button-checkout") private WebElement checkout_btn;
    public void clickCheckout()
    {
        waitUntilVisible(checkout_btn);
        checkout_btn.click();
    }


}
