package pages.wishlist;

import browser.Browser;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Base_Page;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class Wishlist_Page extends Base_Page {

    private static final String page_url = "https://member.lazada.sg/wishlist/index";
    private Browser browser;

    @FindBy(css = ".addAll") private WebElement addAllToCart_element;

    @FindBy(css = ".popup") private WebElement popUpAddToCart_element;

    public static void visit(){
        Global.browser.goTo(page_url);
    }

    public Wishlist_Page(){
        PageFactory.initElements(Global.browser.getWebDriver(), this);
        this.browser = Global.browser;
    }

    public void addAllToCart(){
        browser.waitUntilVisible(addAllToCart_element);
        browser.click(addAllToCart_element);
    }

    public String getPopUpMessage(){
        return browser.textOf(popUpAddToCart_element);
    }

    public boolean has_message(String message){
        return true;
    }



}
