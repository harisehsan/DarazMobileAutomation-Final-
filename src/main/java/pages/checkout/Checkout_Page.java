package pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;
import java.lang.*;


public class Checkout_Page extends PageObject {
    @FindBy(id = "automation-payment-method-item-4") private WebElement creditCardMethod;

    //private By newCard = By.xpath("//span[contains(string(), 'New Credit/Debit Card')]");
    private By newCard = By.cssSelector(".automation-btn-add-card > div");
    private By creditCard = By.id("creditCard");
    private By cardName = By.id("cardName");
    private By expiryDate = By.id("expiryDate");
    private By cvv = By.id("cvv");
    private By saveCard = By.id("automation-checkbox-save-card");
    private By confirmButton = By.cssSelector(".btn-place-order-wrap > button");
    private By byLoader = By.cssSelector(".loading-wrap");

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
