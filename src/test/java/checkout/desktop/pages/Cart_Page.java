package checkout.desktop.pages;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class Cart_Page extends PageObject {

    public static String page_url = Global.getConfig().getString("checkout.cart_url") + "/cart";

    @FindBy(css = ".content") private List<WebElement> productlist;
    @FindBy(css = ".automation-checkout-order-total-button-cartButton") private WebElement goToCart_btn;
    @FindBy(css = ".lazada-ic-MyWishlist") private WebElement wishlistIcon;
    @FindBy(xpath = "//*[@class='next-dialog-footer']/button[1]") private WebElement confirmMoveOrRemove_btn;
    @FindBy(css = ".next-feedback-content") private WebElement moveToWishListSuccessMessage;
    @FindBy(css = ".delete") private WebElement deleteItem_icon;
    @FindBy(css = ".cart-empty-text") private WebElement emptyCart_text;
    @FindBy(css = ".automation-checkout-order-total-button-button") private WebElement confirmCart_btn;
    @FindBy(css = ".list-header-checkbox") private WebElement selectAllItems_chkBox;
    @FindBy(css = ".list-header-checkbox input") private WebElement selectAllItemsChecked_chkBox;
    @FindBy(css = ".list-header-operations .automation-btn-delete") private WebElement deleteAllItems_chkBox;
    @FindBy(css = ".ok") private WebElement confirmDeleteAllItems_btn;

    private By deleteAllItems_chkBox_by = By.cssSelector(".list-header-operations .automation-btn-delete");
    private By deleteItem_icon_by = By.cssSelector(".delete");
    private By emptyCart_text_by = By.cssSelector(".cart-empty-text");
    private By loadingIcon_by = By.cssSelector("#Oval");

    public void clickGoToCartButton() {
        waitUntilVisible(goToCart_btn);
        goToCart_btn.click();
    }

    public boolean checkProductExistInTheCart() {
        boolean productExist = false;
        for (WebElement element : productlist) {
            try{
                String myText = element.findElement(By.cssSelector("a[class~=title]")).getText();
                if (myText.equals(Global.getMap().get("currentProductTitle"))) {
                    productExist = true;
                }
            }catch (StaleElementReferenceException ex) {
                productExist = false;
                break;
            }
        }
        return productExist;
    }

    public void clickWishlistIcon() {
        waitUntilVisible(wishlistIcon);
        wishlistIcon.click();
    }

    public void confirmMoveOrRemove() {
        waitUntilVisible(confirmMoveOrRemove_btn);
        confirmMoveOrRemove_btn.click();
        waitUntilInvisibilityOf(loadingIcon_by);
    }

    public boolean checkMoveToWishlistSuccessMessage() {
        waitUntilVisible(moveToWishListSuccessMessage);
        return moveToWishListSuccessMessage.isDisplayed();
    }

    public void clickDeleteIcon() {
        waitUntilVisible(deleteItem_icon);
        deleteItem_icon.click();
        waitUntilInvisibilityOf(loadingIcon_by);
    }

    public boolean checkEmptyCart() {
        waitUntilPageReady();

        //try {
            return (isExist(emptyCart_text_by));
        //}
        /*catch (NoSuchElementException ex) {
            return false;
        }*/
    }

    public boolean isEmptyCartTextDisplayed(){
        return emptyCart_text.isDisplayed();
    }

    public void clickConfirmCart() {
        waitUntilVisible(confirmCart_btn);
        confirmCart_btn.click();
    }

    public void emptyCart() {
        boolean empty = checkEmptyCart();

        if (!empty) {
            if (isExist(deleteAllItems_chkBox_by)) {
                waitUntilVisible(selectAllItems_chkBox);
                if (selectAllItemsChecked_chkBox.getAttribute("aria-checked").equals("false")) {
                    selectAllItems_chkBox.click();
                }

                deleteAllItems_chkBox.click();
                waitUntilVisible(confirmDeleteAllItems_btn);
                confirmDeleteAllItems_btn.click();
            }
            else {
                emptyCartOnDaraz();
            }
        }

    }

    private void emptyCartOnDaraz() {
        waitUntilPageReady();
        do {
            clickDeleteIcon();
            confirmMoveOrRemove();
        } while (isExist(deleteItem_icon_by));
    }


}
