package checkout.desktop.pages;

import base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutShipping_Page extends PageObject {

//  @FindBy(css = ".automation-checkout-order-total-button-button") private WebElement placeorder_btn;
    @FindBy (className = "checkout-order-total-button") private WebElement placeorder_btn;
    @FindBy(css = ".address-hat") private WebElement shippingAddressTitle;
    @FindBy(className = "automation-address-edit") private WebElement edit_btn;

    private By placeorder_btn_by = By.cssSelector(".automation-checkout-order-total-button-button");

    public void clickPlaceOrder()
    {
        waitUntilVisible(shippingAddressTitle);
        waitUntilClickable(placeorder_btn_by);
        placeorder_btn.click();
    }

    public boolean isOnCheckoutShipping(){
        waitUntilVisible(shippingAddressTitle);
        return shippingAddressTitle.isDisplayed();
    }

}
