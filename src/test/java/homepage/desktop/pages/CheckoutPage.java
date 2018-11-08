package homepage.desktop.pages;

import base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageObject {

    @FindBy(xpath = "//*[@id='toPayBtn_10021']/button")
    private WebElement placeOrderBtn;
    @FindBy(xpath = "//*[@id='automation-payment-method-item-1']")
    private WebElement selectCODBtn;
    @FindBy(xpath = "//*[@id='paymentMethodList_10001\']/div[2]/div[2]/button")
    private WebElement confirmOrderBtn;


    public void placeOrder() {
        waitUntilPageReady();
        placeOrderBtn.click();
    }

    public void selectCOD() {
       /* waitUntilPageReady();
        System.out.println("confirmOrderBtn = " + confirmOrderBtn.getText());
        while(confirmOrderBtn.getText()==null)
            {
        selectCODBtn.click();
            }*/
        waitUntilPageReady();
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        selectCODBtn.click();
    }

    public void confirmOrder() {
        confirmOrderBtn.click();
    }


}
