package checkout.desktop.pages;

import base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetails_Page extends PageObject {

//    @FindBy(css = ".link.bold") private WebElement cancelOrder;
    @FindBy (css = "div#container a > p") private WebElement cancelOrder_link;
    @FindBy(className = "progress-info-division") private WebElement process_lbl;

    private By cancelOrder_link_by = By.cssSelector("div#container a > p");

    public void clickCancelOrder(){
        waitUntilPageReady();
        waitUntilVisibility(cancelOrder_link_by,5);
        scrollToView(process_lbl);
        clickWithoutException(cancelOrder_link);
    }
}
