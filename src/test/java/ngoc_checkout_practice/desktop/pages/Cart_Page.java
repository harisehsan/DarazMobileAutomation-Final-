package ngoc_checkout_practice.desktop.pages;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class Cart_Page extends PageObject {
    @FindBy(css = ".content") private List<WebElement> productlist;
    @FindBy(css = ".automation-checkout-order-total-button-cartButton") private WebElement goToCart_btn;
    @FindBy(css = ".lazada-ic-MyWishlist") private WebElement wishlistIcon;
    @FindBy(xpath = "//*[@class='next-dialog-footer']/button[1]") private WebElement confirmMoveOrRemove_btn;
    @FindBy(css = ".next-feedback-content") private WebElement moveToWishListSuccessMessage;
    @FindBy(css = ".lazada-ic-Delete") private WebElement delete_icon;
    @FindBy(css = ".cart-empty-text") private WebElement emptyCart;
    @FindBy(css = ".automation-checkout-order-total-button-button") private WebElement confirmCart_btn;

    public void clickGoToCartButton() {
        waitUntilVisible(goToCart_btn);
        goToCart_btn.click();
    }

    public boolean checkProductExistInTheCart() {
        boolean productExist = false;
        for (WebElement element : productlist) {
            try{
                String myText = element.findElement(By.cssSelector("a[class~=title]")).getText();
                if (myText.equals(Global.map.get("currentProductTitle"))) {
                    productExist = true;
                }
            }catch (StaleElementReferenceException ex){
                productExist = false;
                break;
            }
        }
        return productExist;
    }

    public void clickWishlistIcon(){
        waitUntilVisible(wishlistIcon);
        wishlistIcon.click();
    }

    public void confirmMoveOrRemove(){
        waitUntilVisible(confirmMoveOrRemove_btn);
        confirmMoveOrRemove_btn.click();
        waitUntilInvisibilityOf(By.cssSelector(".Oval"));
    }

    public boolean checkMoveToWishlistSuccessMessage(){
        waitUntilVisible(moveToWishListSuccessMessage);
        return moveToWishListSuccessMessage.isDisplayed();
    }

    public void clickDeleteIcon(){
        waitUntilVisible(delete_icon);
        delete_icon.click();
    }

    public boolean checkEmptyCart(){
        waitUntilVisible(emptyCart);
        return emptyCart.isDisplayed();
    }

    public void clickConfirmCart(){
        waitUntilVisible(confirmCart_btn);
        confirmCart_btn.click();
    }

}
