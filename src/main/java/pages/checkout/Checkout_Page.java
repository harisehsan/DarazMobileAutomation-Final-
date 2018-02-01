package pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout_Page {
    @FindBy(id = ".automation-payment-method-item-5") private WebElement creditCard;

    private By helloMessage = By.xpath("//span[contains(string(), 'New Credit/Debit Card')]");
    private By numberfield = By.id("creditCard");
    private By cardName = By.id("cardName");
    private By expiryDate = By.id("expiryDate");
    private By cvv = By.id("cvv");
    private By saveCard = By.id("automation-checkbox-save-card");
    private By confirmButton = By.cssSelector(".btn-place-order-wrap > button");

}
