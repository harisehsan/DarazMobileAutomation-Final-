package pages.pdp;

import model.ProductDetailInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base_Page;

import java.util.List;
import java.util.Random;

/**
 * Created by admin.son.ton on 1/16/18.
 */
public class Pdp_Page extends Base_Page {

    private static String page_url = "https://www.lazada.sg/google-play-gift-code-sgd-30-51661524.html?pdpVersion=v2";

    //Specific PDPs:
    private static String page_url_digital = "https://www.lazada.sg/google-play-gift-code-sgd-30-51661524.html?pdpVersion=v2";
    private static String page_url_multisource = "https://www.lazada.sg/samsung-galaxy-a7-a7000-4g-lte-smart-phone-dual-sim-black-export-424495.html?pdpVersion=v2";
    private static String page_url_oos = "https://www.lazada.sg/waterproof-sports-action-camera-dv-dvr-20x9d-sj4000-rose-9511662.html?pdpVersion=v2";
    private static String page_url_grouping = "https://www.lazada.sg/xianglong-test-pls-dont-buy-lots-of-sku-97287329.html?pdpVersion=v2";
    private static String page_url_service = "https://www.lazada.sg/longs-test-service-product-pls-dont-buy-166912032.html?pdpVersion=v2";
    private static String page_url_tbc = "https://www.lazada.sg/living-room-entrance-meter-box-decorative-painting-61767783.html?pdpVersion=v2";
    private static String page_url_voucher = "https://www.lazada.sg/anello-x-legato-largo-original-japan-3-way-tote-bag-should-bag-crossbody-baglarge-size-8006854.html?pdpVersion=v2";
    private static String page_url_seller_promotion = "https://www.lazada.sg/anello-x-legato-largo-original-japan-3-way-tote-bag-should-bag-crossbody-baglarge-size-8006854.html?pdpVersion=v2";
    private static String page_url_shipped_from_overseas = "https://www.lazada.sg/voyager-test-product-test-cb-product-with-fbl-stock-94140529.html?pdpVersion=v2";
    private static String page_url_many_pictures = "https://www.lazada.sg/wd06-c-mobile-phone-charging-base-mobile-phone-charging-bracket-three-bracket-with-bamboo-wood-charging-function-intl-61802881.html?pdpVersion=v2";


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

    public ProductDetailInfo getProductInfo() {
        browser.waitUntilVisible(productTitle_element);
        return new ProductDetailInfo(productTitle_element.getText(),
                browser.currentUrl());
    }

    public void selectVariation() {
        if (variation_elements.size() > 0) {
            WebElement random_element = variation_elements.get(new Random().nextInt(variation_elements.size()));
            random_element.click();
            browser.waitUntilVisible(random_element);
        }
    }

    public void addToWishlist() {
        browser.waitUntilVisible(wishlist_element);
        wishlist_element.click();
        browser.waitUntilVisible(wishlistActive_element);
    }

    public void Loaded() {
        browser.waitUntilVisible(productTitle_element);
    }

    public void goToPDP(String url) {
        browser.goTo(url);
    }

    public void goToSpecificPDP(String PDPType) {
        switch (PDPType) {
            case "digital":
                goToPDP(page_url_digital);
                break;

            case "multisource":
                goToPDP(page_url_multisource);
                break;

            case "oos":
                goToPDP(page_url_oos);
                break;

            case "grouping":
                goToPDP(page_url_grouping);
                break;

            case "service":
                goToPDP(page_url_service);
                break;

            case "tbc":
                goToPDP(page_url_tbc);
                break;

            case "voucher":
                goToPDP(page_url_voucher);
                break;

            case "seller promotion":
                goToPDP(page_url_seller_promotion);
                break;

            case "shipped from overseas":
                goToPDP(page_url_shipped_from_overseas);
                break;

            case "many pictures":
                goToPDP(page_url_many_pictures);
                break;

            default:
                goToPDP(page_url);
                break;
        }

    }


    public boolean has_message(String message) {
        return true;
    }
}
