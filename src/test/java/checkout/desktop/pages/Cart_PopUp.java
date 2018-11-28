package checkout.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart_PopUp extends PageObject {

    @FindBy(css = ".automation-checkout-order-total-button-checkout") private WebElement checkout_btn;
    @FindBy(css = ".cart-item-quantity-value") private WebElement itemQuantity_lbl;

    public void clickCheckout() {
        waitUntilVisible(checkout_btn);
        checkout_btn.click();
    }

    public int checkItemQuantity(){
        waitUntilVisible(itemQuantity_lbl);
        return Integer.valueOf(itemQuantity_lbl.getText());
    }

}
