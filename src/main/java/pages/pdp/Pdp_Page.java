package pages.pdp;

import global.Global;
import model.ProductDetailInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

import java.util.List;
import java.util.Random;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class Pdp_Page extends PageObject {

    public static String page_url = "https://p.daraz.com.bd/-i1646886-s31627922.html";

    @FindBy(css = ".wishlist-icon") private WebElement wishlist_element;
    @FindBy(css = ".wishlist-icon.active") private WebElement wishlistActive_element;
    @FindBy(css = ".pdp-Cart_Page-concern button") private WebElement addToCart_element;
    @FindBy(css = ".pdp-product-title") private WebElement productTitle_element;
    @FindBy(css = ".sku-prop-content > span") private List<WebElement> variation_elements;
    @FindBy(css = ".pdp-button_theme_yellow") private WebElement buy_now_btn;
    @FindBy(css = ".next-number-picker-input input") private WebElement number_of_item_input;
    @FindBy(css = ".next-number-picker-handler-up") private WebElement increase_item_quantity_btn;

    private By pdpTitle_by = By.cssSelector(".pdp-product-title");
    private By buyNow_by = By.cssSelector(".pdp-button_theme_yellow");
    private By numberOfItems_by = By.cssSelector(".next-number-picker-input input");
    private By increaseItemQuantity_by = By.cssSelector(".next-number-picker-handler-up");
    private By loadingSkeleton_by = By.cssSelector(".pdp-skeleton__product-info");

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

    public void waitUntilLoaded() {
        waitUntilPageReady();
        waitUntilInvisibilityOf(loadingSkeleton_by);
        waitUntilVisibility(pdpTitle_by);
    }

    public void openBuyNowPage(){
        waitUntilLoaded();
        waitUntilClickable(buyNow_by);
        buy_now_btn.click();
    }

    public void selectNumberOfItem(String numberOfItems){
        waitUntilLoaded();
        waitUntilVisibility(numberOfItems_by,180);
        number_of_item_input.sendKeys(numberOfItems);
    }

    public boolean has_message(String message) {
        return true;
    }
}
