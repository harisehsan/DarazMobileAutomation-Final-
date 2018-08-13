package pages.desktop.wishlist;

import helper.UrlHelper;
import model.ProductDetailInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

import java.util.List;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class Wishlist_Page extends PageObject {

    public static String page_url = "https://member.lazada.sg/wishlist/index";

    @FindBy(css = ".wishlist-item") private List<WebElement> item_elements;

    public Wishlist_Page(){ super();}

    public void addAllToCart(){
    }

    public boolean hasItem(ProductDetailInfo info){
        WebElement ele = getItemElement(info.getProductUrl());
        return ele.getText().contains(info.getProductTitle());
    }

    public WebElement getItemElement(String url){
        String formatedUrl = UrlHelper.removePrefix(url);
        By by = By.xpath(String.format("//*[contains(@href,'%s')]/parent::*/parent::div[contains(@class,'wishlist-item')]",formatedUrl));
        return findDynamicElement(by);
    }

    public boolean deleteItem(ProductDetailInfo info){
        getItemElement(info.getProductUrl());
        return false;
    }

    public String getPopUpMessage(){
        return "";
    }

    public boolean has_message(String message){
        return true;
    }



}
