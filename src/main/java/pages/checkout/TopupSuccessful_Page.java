package pages.checkout;

import org.openqa.selenium.By;
import pages.PageObject;


public class TopupSuccessful_Page extends PageObject{

    private By thankYou = By.cssSelector("thank-you-heading");
    private By orderNumber = By.cssSelector("thank-you-order-number");
    private By wait10Sec = By.xpath("//div[contains(string(), 'You will be taken to My Orders after 10 seconds.')]");

    public void checkSuccessful (){
        waitUntilPresentOfElementBy(thankYou);
        findDynamicElement(thankYou);
    }

    public void checkPending (){
        findDynamicElement(wait10Sec);
    }

    public String orderNumber(){
        return findDynamicElement(orderNumber).getText();
    }

    public void checkOrder(String skuName, String phoneNumber){
        By name = By.xpath("//td[contains(string(), '" + skuName + "')]");
        By number = By.xpath("//td[contains(string(), '" + phoneNumber + "')]");
        findDynamicElement(name);
        findDynamicElement(number);
    }

}
