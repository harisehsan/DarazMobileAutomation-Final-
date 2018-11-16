package homepage.desktop.pages;

import base.PageObject;
import com.codeborne.selenide.SelenideElement;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class Checkout_Page extends PageObject {

    @FindBy(xpath = "//*[@id='toPayBtn_10021']/button")
    private WebElement placeOrderBtnWithBuyNow;
    @FindBy(xpath = "//*[text()= 'Cash on Delivery']")
    private WebElement selectCODBtn;
    @FindBy(xpath = "//*[@id='paymentMethodList_10001\']/div[2]/div[2]/button")
    private WebElement confirmOrderBtn;
    //FindBy(css = "#paymentMethodList_10001") private SelenideElement list_payment_method;
    //private SelenideElement list_payment_method = $("#paymentMethodList_10001");

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

        //list_payment_method.find(By.linkText(Global.config.getString("checkout.codText.cod"))).click();
        waitUntilInvisibilityOf(By.id("_x38_0x80-loading-logo"));
    }

    public void confirmOrder() {
        waitUntilInvisibilityOf(By.id("_x38_0x80-loading-logo"));
        confirmOrderBtn.click();
    }


}
