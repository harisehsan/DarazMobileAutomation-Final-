package checkout.desktop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;
import java.lang.*;


public class Checkout_Page extends PageObject {
    @FindBy(id = "automation-payment-method-item-4") private WebElement creditCardMethod;
    @FindBy(xpath = "//div[contains(@class,'pay-method-item') and contains(.,'Cash on Delivery')]") private WebElement cod_method_btn;
    @FindBy(css = ".btn-place-order-wrap > button") private WebElement place_order_btn;
    @FindBy(css = ".thank-you-order-number") private WebElement order_number_field;



    //private By newCard = By.xpath("//span[contains(string(), 'New Credit/Debit Card')]");
    private By newCard = By.cssSelector(".automation-btn-add-card > div");
    private By creditCard = By.id("creditCard");
    private By cardName = By.id("cardName");
    private By expiryDate = By.id("expiryDate");
    private By cvv = By.id("cvv");
    private By saveCard = By.id("automation-checkbox-save-card");
    private By confirmButton = By.cssSelector(".btn-place-order-wrap > button");
    private By byLoader = By.cssSelector(".loading-wrap");
    private By orderNumberField_by = By.cssSelector(".thank-you-order-number");
    private By codMethod_by = By.xpath("//div[contains(@class,'pay-method-item') and contains(.,'Cash on Delivery')]");




    private void waitUntilLoaded(){
        waitUntilPageReady();
    }

    public String placeCODOrder(){
        waitUntilLoaded();
        waitUntilInvisibilityOf(By.cssSelector(".next-overlay-backdrop"));
        waitUntilVisibility(codMethod_by);
        cod_method_btn.click();
        waitUntilVisibility(confirmButton);
        place_order_btn.click();
        waitUntilVisibility(orderNumberField_by);
        return order_number_field.getText();
    }

    public void selectCardMethod() {
        try {
            waitUntilLocated(By.id("automation-payment-method-item-4"));
            waitUntilClickable(By.id("automation-payment-method-item-4"));
            creditCardMethod.click();
        }catch(Throwable t){}
    }

    public void newCrad() {
        try {
            WebElement web = findDynamicElement(newCard);
            waitUntilInvisibilityOf(By.cssSelector(".next-overlay-backdrop"));
            waitUntilLocated(newCard);
            waitUntilPresentOfElementBy(newCard);
            waitUntilClickable(newCard);
            web.click();
        }catch (Throwable t){ }
    }

    public void enterCardData(String creditCard, String cardName, String expiryDate, String cvv){
        waitUntilLocated(this.creditCard);

        WebElement webCreditCard = findDynamicElement(this.creditCard);
        WebElement webCardName = findDynamicElement(this.cardName);
        WebElement webExpiryDate = findDynamicElement(this.expiryDate);
        WebElement webCvv = findDynamicElement(this.cvv);

        webCreditCard.sendKeys(creditCard);
        webCardName.sendKeys(cardName);
        webExpiryDate.sendKeys(expiryDate);
        webCvv.sendKeys(cvv);
    }

    public void switchSaveCard(){
        try {
            if (!findDynamicElement(saveCard).isSelected()) {
                findDynamicElement(saveCard).click();
            }
        }catch (Throwable t){ //Why do nothing in catch ??
            }
    }

    public void confirm(){
        waitUntilInvisibilityOf(By.cssSelector(".next-overlay-backdrop"));
        waitUntilLocated(confirmButton);
        findDynamicElement(confirmButton).click();
        waitUntilInvisibilityOf(byLoader);
    }

    public void waitLoader(String STime){
        int time = Integer.parseInt(STime);
        waitUntilLocated(byLoader);
        waitLongUntilInvisibilityOf(byLoader,time);
    }



}
