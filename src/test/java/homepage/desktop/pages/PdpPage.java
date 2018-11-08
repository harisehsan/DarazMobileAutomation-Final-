package homepage.desktop.pages;

import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class PdpPage extends PageObject {

    public static final String page_url = Global.config.getString("homepage.pdp_url");

    @FindBy(xpath="//*[@id='module_add_to_cart']/div/button[1]") private WebElement btnBuyNow;

    @FindBy(xpath="//*[@id=\'module_add_to_cart\']/div/button[2]") private WebElement btnAddToCart;

    @FindBy(xpath="//*[@id=\'dialog-body-1\']/div/div[1]/div/div[1]/div[1]/span[1]") private WebElement txtSuccess;

    @FindBy(xpath="//*[@id=\'dialog-body-1\']/div/div[1]/div/div[2]/div/div[2]/div/div[2]/button[2]") private WebElement btnGoToCart;

    public void clickToBuyNow ()
    {
        waitUntilVisible(btnBuyNow);
        btnBuyNow.click();
    }
    public void clickAddToCart ()
    {
        waitUntilVisible(btnAddToCart);
        btnAddToCart.click();
    }

    public void addToCartSuccess () {
        waitUntilVisible(txtSuccess);

    }

    public void goToCart() {
        btnGoToCart.click();

    }
}
