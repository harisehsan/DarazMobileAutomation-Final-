package pages.wishlist;

import browser.Browser;
import global.Global;
import model.ProductDetailInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Base_Page;

import java.util.List;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class Wishlist_Page extends Base_Page {

    private static final String page_url = "https://member.lazada.sg/wishlist/index";

    @FindBy(css = ".wishlist-item") private List<WebElement> item_elements;

    public static void visit(){
        Global.browser.goTo(page_url);
    }

    public Wishlist_Page(){
        super();
        PageFactory.initElements(browser.getWebDriver(), this);
    }

    public void addAllToCart(){
    }

    public boolean hasItem(ProductDetailInfo info){
        for(WebElement ele: item_elements){
            if(ele.getText().contains(info.productTitle))return true;
        }
        return false;
    }

    public String getPopUpMessage(){
        return "";
    }

    public boolean has_message(String message){
        return true;
    }



}
