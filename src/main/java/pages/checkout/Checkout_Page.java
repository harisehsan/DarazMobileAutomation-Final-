package pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base_Page;
import java.lang.*;


public class Checkout_Page extends Base_Page {
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
            browser.waitUntilLocated(By.id("automation-payment-method-item-4"));
            browser.waitUntilClickable(By.id("automation-payment-method-item-4"));
            creditCardMethod.click();
        }catch(Throwable t){}
    }

    public void newCrad() {
        try {
            WebElement web = browser.getWebDriver().findElement(newCard);
            browser.waitUntilInvisibilityOf(By.cssSelector(".next-overlay-backdrop"));
            browser.waitUntilLocated(newCard);
            browser.waitUntilPresentOfElementBy(newCard);
            browser.waitUntilClickable(newCard);
            web.click();
        }catch (Throwable t){ }
    }

    public void enterCardData(String creditCard, String cardName, String expiryDate, String cvv){
        browser.waitUntilLocated(this.creditCard);

        WebElement webCreditCard = browser.getWebDriver().findElement(this.creditCard);
        WebElement webCardName = browser.getWebDriver().findElement(this.cardName);
        WebElement webExpiryDate = browser.getWebDriver().findElement(this.expiryDate);
        WebElement webCvv = browser.getWebDriver().findElement(this.cvv);

        webCreditCard.sendKeys(creditCard);
        webCardName.sendKeys(cardName);
        webExpiryDate.sendKeys(expiryDate);
        webCvv.sendKeys(cvv);
    }

    public void switchSaveCard(){
        try {
            if (!browser.getWebDriver().findElement(saveCard).isSelected()) {
                browser.getWebDriver().findElement(saveCard).click();
            }
        }catch (Throwable t){ }

    }

    public void confirm(){
        browser.waitUntilInvisibilityOf(By.cssSelector(".next-overlay-backdrop"));
        browser.waitUntilLocated(confirmButton);
        browser.getWebDriver().findElement(confirmButton).click();
        browser.waitUntilInvisibilityOf(byLoader);
    }

    public void waitLoader(String STime){
        int time = Integer.parseInt(STime);
        browser.waitUntilLocated(byLoader);
        browser.waitLongUntilInvisibilityOf(byLoader,time);
    }


}
