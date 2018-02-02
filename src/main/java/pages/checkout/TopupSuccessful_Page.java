package pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base_Page;
import java.lang.*;


public class TopupSuccessful_Page extends Base_Page{

    private By thankYou = By.cssSelector("thank-you-heading");
    private By orderNumber = By.cssSelector("thank-you-order-number");

    public void checkSuccessful (){
        browser.getWebDriver().findElement(thankYou);
    }

    public String orderNumber(){
        String orderN = browser.getWebDriver().findElement(orderNumber).getText();
        return orderN;
    }

    public void checkOrder(String skuName, String phoneNumber){
        By name = By.xpath("//td[contains(string(), '" + skuName + "')]");
        By number = By.xpath("//td[contains(string(), '" + phoneNumber + "')]");
        browser.getWebDriver().findElement(name);
        browser.getWebDriver().findElement(number);
    }

}
