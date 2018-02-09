package pages.pdp;

import model.ProductDetailInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.PageObject;
import pages.Base_Page;

import java.util.List;
import java.util.Random;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class Pdp_Page extends PageObject {

    //private static String page_url = "https://www.lazada.sg/google-play-gift-code-sgd-30-51661524.html?pdpVersion=v2";

    @FindBy(css = ".wishlist-icon")
    private WebElement wishlist_element;
    @FindBy(css = ".wishlist-icon.active")
    private WebElement wishlistActive_element;
    @FindBy(css = ".pdp-Cart_Page-concern button")
    private WebElement addToCart_element;
    @FindBy(css = ".pdp-product-title")
    private WebElement productTitle_element;
    @FindBy(css = ".sku-prop-content > span")
    private List<WebElement> variation_elements;

    public Pdp_Page() {
        super();
    }

    public ProductDetailInfo getProductInfo(){
        waitUntilVisible(productTitle_element);
        return new ProductDetailInfo(productTitle_element.getText(),
                                     currentUrl());
    }

    public void selectVariation() {
        if (variation_elements.size() > 0) {
            WebElement random_element = variation_elements.get(new Random().nextInt(variation_elements.size()));
            random_element.click();
            waitUntilVisible(random_element);
        }
    }

    public void addToWishlist(){
        waitUntilVisible(wishlist_element);
        wishlist_element.click();
        waitUntilVisible(wishlistActive_element);
    }

    public void Loaded() {
        waitUntilVisible(productTitle_element);
    }

    public void goToPDP(String url) {
        goTo(url);
    }

    public boolean has_message(String message) {
        return true;
    }
}
