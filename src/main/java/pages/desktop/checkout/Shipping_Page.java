package pages.desktop.checkout;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class Shipping_Page extends PageObject {

    public static String page_url = Global.config.getString("member_url")+"/shipping";

    @FindBy(css = ".checkout-order-total-button") private WebElement place_order_btn;

    private void waitUntilLoaded(){
        waitUntilPageReady();
        waitUntilVisible(place_order_btn);
    }

    public void placeOrder(){
        waitUntilLoaded();
        place_order_btn.click();
    }

}
