package ngoc_checkout_practice.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutShipping_Page extends PageObject {

    @FindBy(css = ".automation-checkout-order-total-button-button") private WebElement placeorder_btn;
    @FindBy(css = ".address-hat") private WebElement shippingAddressTitle;

    public void clickPlaceOrder()
    {
        waitUntilVisible(shippingAddressTitle);
        placeorder_btn.click();
    }

}
