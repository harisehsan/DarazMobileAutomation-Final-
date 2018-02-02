package pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base_Page;
import java.lang.*;


public class Checkout_Page extends Base_Page {
    @FindBy(id = "automation-payment-method-item-5") private WebElement creditCardMethod;

    private By newCard = By.xpath("//span[contains(string(), 'New Credit/Debit Card')]");
    private By creditCard = By.id("creditCard");
    private By cardName = By.id("cardName");
    private By expiryDate = By.id("expiryDate");
    private By cvv = By.id("cvv");
    private By saveCard = By.id("automation-checkbox-save-card");
    private By confirmButton = By.cssSelector(".btn-place-order-wrap > button");

    public void selectCardMethod() {
        try {
            //browser.waitUntilClickable(By.id("automation-payment-method-item-5"));
            creditCardMethod.click();
        }catch(Throwable t){}
    }

    public void newCrad() {
        try {
            WebElement web = browser.getWebDriver().findElement(newCard);
            web.click();
        }catch (Throwable t){ }
    }

    public void enterCardData(String creditCard, String cardName, String expiryDate, String cvv){
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
        browser.waitUntilClickable(confirmButton);
        browser.getWebDriver().findElement(confirmButton).click();
    }


}
