package checkout.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetails_Page extends PageObject {

    @FindBy(css = ".link.bold") private WebElement cancelOrder;

    public void clickCancelOrder(){
        waitUntilVisible(cancelOrder);
        cancelOrder.click();
    }
}
