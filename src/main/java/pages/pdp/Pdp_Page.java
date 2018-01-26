package pages.pdp;
import browser.Browser;
import global.Global;
import model.ProductDetailInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Base_Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class Pdp_Page extends Base_Page {

    private static final String page_url = "https://pdp-p.lazada.sg/97287339.html";

    @FindBy(css = ".wishlist-icon") private WebElement wishlist_element;
    @FindBy(css = ".wishlist-icon.active") private WebElement wishlistActive_element;
    @FindBy(css = ".pdp-Cart_Page-concern button") private WebElement addToCart_element;
    @FindBy(css = ".pdp-product-title") private WebElement productTitle_element;
    @FindBy(css = ".sku-prop-content > span") private List<WebElement> variation_elements;

    public static void visit(){
        Global.browser.goTo(page_url);
    }

    public Pdp_Page(){ super();}

    public ProductDetailInfo getProductInfo(){
        browser.waitUntilVisible(productTitle_element);
        return new ProductDetailInfo(productTitle_element.getText(),
                                     browser.currentUrl());
    }

    public void selectVariation(){
        if(variation_elements.size()>0) {
            WebElement random_element = variation_elements.get(new Random().nextInt(variation_elements.size()));
            random_element.click();
            browser.waitUntilVisible(random_element);
        }
    }

    public void addToWishlist(){
        browser.waitUntilVisible(wishlist_element);
        wishlist_element.click();
        browser.waitUntilVisible(wishlistActive_element);
    }

    public boolean has_message(String message){
        return true;
    }
}
