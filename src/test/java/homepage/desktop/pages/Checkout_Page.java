package homepage.desktop.pages;

import base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageObject {

    @FindBy(xpath = "//*[@id='toPayBtn_10021']/button")
    private WebElement placeOrderBtnWithBuyNow;
    @FindBy(xpath = "//*[text()= 'Cash on Delivery']")
    private WebElement selectCODBtn;
    @FindBy(xpath = "//*[@id='paymentMethodList_10001\']/div[2]/div[2]/button")
    private WebElement confirmOrderBtn;

    @FindBy(xpath="//*[@id='rightContainer_CR']/div[2]/div[2]/div/div[3]/button") private WebElement placeOrderBtnNormal;
    public void placeOrder() {
        waitUntilPageReady();

        placeOrderBtnWithBuyNow.click();
        waitUntilInvisibilityOf(By.id("_x38_0x80-loading-logo"));
    }

    public void selectCOD() {

        waitUntilPageReady();
        waitUntilInvisibilityOf(By.id("_x38_0x80-loading-logo"));
        selectCODBtn.click();
        waitUntilInvisibilityOf(By.id("_x38_0x80-loading-logo"));
    }

    public void confirmOrder() {
        waitUntilInvisibilityOf(By.id("_x38_0x80-loading-logo"));
        confirmOrderBtn.click();
    }


}
