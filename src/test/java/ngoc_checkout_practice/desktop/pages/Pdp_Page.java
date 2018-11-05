package ngoc_checkout_practice.desktop.pages;

import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pdp_Page extends PageObject {

    public static String page_url = "";
    @FindBy(css = ".pdp-button_theme_orange") private WebElement add_to_cart_btn;
    @FindBy(id = "myAccountTrigger") private WebElement myAccountmenu;
    @FindBy(css = ".pdp-product-title") private WebElement productTitle;

    public static void setUrl(String url)
    {
        page_url = url;
    }

    public void getProductTitle(){
        Global.map.put("ProductTitle", productTitle);

    }

    public void clickAddToCartButton()
    {
        waitUntilVisible(myAccountmenu);
        waitUntilPageReady();
        add_to_cart_btn.click();
    }

}
