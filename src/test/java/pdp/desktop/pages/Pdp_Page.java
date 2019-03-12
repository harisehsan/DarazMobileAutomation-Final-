package pdp.desktop.pages;

import _base.page_helpers.BuyerSitePageHelper;
import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class Pdp_Page extends PageObject {

    public static String page_url = "";
    @FindBy(css = ".pdp-button_theme_orange") private WebElement addToCart_btn;
    @FindBy(id = "myAccountTrigger") private WebElement myAccount_list;
    @FindBy(css = ".pdp-product-title") private WebElement productTitle_lbl;
    @FindBy(id = "topActionSwitchLang") private WebElement changeLanguage_list;
    @FindBy(css = ".lzd-switch-icon-en") private WebElement englishVersion_listItem;
    @FindBy(css = ".pdp-mod-wishlist") private WebElement wishlist_icon;
    @FindBy(css = ".wishlist-icon") private WebElement wishlistActived_icon;
    @FindBy(css = ".wishlist") private WebElement myWishlist_listItem;
    @FindBy(css = ".sfo") private WebElement shippingFromOversea_popup;
    @FindBy(css = ".sfo__close") private WebElement shippingFromOverseaClose_btn;
    @FindBy(css = ".qna-ask-input") private WebElement openQuestionTextArea_btn;
    @FindBy(css = ".qna-ask-input textarea") private WebElement askQuestion_txtArea;
    @FindBy(css = ".qna-ask-btn") private WebElement askQuestion_btn;
    @FindBy(css = ".qna-ask-box-tips") private WebElement askQuestionTip_lbl;
    @FindBy(css = ".qna-content") private WebElement firstQuestion_lbl;
    @FindBy(css = ".next-feedback-content") private WebElement errorMessageForInvalidQuestion_lbl;
    @FindBy(css = ".seller-im-wrapper") private WebElement chatNow_link;
    @FindBy(css = "[data-lazyload-listened] > div:nth-of-type(1)") private WebElement firstSeller_btn;
    @FindBy(css = ".message-view") private WebElement messageView_popup;
    @FindBy(css = "[rows]") private WebElement messageInput_txtField;
    @FindBy(css = ".message-view-field__send") private WebElement messageSend_btn;
    @FindBy(css = ".message-list") private WebElement messageList_popup;
    @FindBy(xpath = "//*[@id='module_seller_warranty']/div/div[1]") private WebElement returnAndWaranty_lbl;
    @FindBy(xpath = "//div[text()='Delivery Options' or text()='Pilihan pengiriman']") private WebElement leadtimeSection_lbl;
    @FindBy(css = ".next-dialog-close") private WebElement closeLoginForm_btn;
    @FindBy(xpath = "//*[@id='module_add_to_cart']/div/button[1]") private WebElement buyNow_btn;
    @FindBy(css = ".cart-message-text") private WebElement cartMessageText_lbl;
    @FindBy(css = ".next-dialog-close") private WebElement closeCartPopup_btn;
    @FindBy(css = ".next-number-picker-handler-up") private WebElement plus_icon;
    @FindBy(css = ".next-number-picker-handler-down") private WebElement minus_icon;
    @FindBy(css = ".next-number-picker-input input") private WebElement itemQuantity_lbl;
    @FindBy(css = ".location__link-change") private WebElement changeLeadtime_link;
    @FindBy(css = ".automation-location-list-item") private List<WebElement> locationListItems;
    @FindBy(css = ".location__address") private WebElement leadtimeAddress_lbl;
    @FindBy(css = ".location-postcode__input-wrap > span > input[type='text']") private WebElement postCode_txtField;
    @FindBy(css = ".location-postcode__button-save") private WebElement postCodeSave_btn;
    @FindBy(className = "pdp-price") private WebElement productPrice_lbl;

    private By location_loading_icon_by = By.cssSelector(".location-level__loader");
    private By location_overlay_by = By.cssSelector(".location-overlay");
    private By postCodeSave_btn_by = By.cssSelector(".location-postcode__button-save");
    private By messageInput_txtField_by = By.cssSelector("[rows]");
    private By messageLoading_icon_by = By.cssSelector(".next-icon-loading.read-type");
    private By firstSeller_btn_by = By.cssSelector("[data-lazyload-listened] > div:nth-of-type(1)");

    public static void setUrl(String url) {
        page_url = url;
    }

    public String randomAddress = "";

    private float price = 0;

    private int FLAG = 1;

    public String getProductTitle() {
        return productTitle_lbl.getText();
    }

    public void clickAddToCartButton() {
        waitUntilVisible(myAccount_list);
        waitUntilPageReady();
        waitUntilInvisibilityOf(By.cssSelector(".pdp-skeleton__variation-list-wrapper"));
        addToCart_btn.click();
    }

    public void clickAddToCartButtonBeforeLogin() {
        waitUntilVisible(addToCart_btn);
        addToCart_btn.click();
    }

    public void switchToEnglish() {
        BuyerSitePageHelper.switchToEnglish();
    }

    public void addToWishlist() {
        waitUntilVisible(wishlist_icon);
        wishlist_icon.click();
    }

    public String currentWishlistIconColor() {
         return wishlistActived_icon.getCssValue("color");
    }

    public void openWishlistPage() {
        waitUntilVisible(myAccount_list);
        myAccount_list.click();
        waitUntilVisible(myWishlist_listItem);
        myWishlist_listItem.click();
    }

    public void closeShippingFromOverseaPopup() {
        try{
            if (shippingFromOversea_popup.isDisplayed()){
                shippingFromOverseaClose_btn.click();
            }
        }catch (NoSuchElementException ex) {
            System.out.println("There is no ShippingFromOversea popup");
        }
    }

    public void askQuestion(String question) {
        waitUntilVisible(openQuestionTextArea_btn);
        waitUntilInvisibilityOf(By.cssSelector(".next-feedback-content"));
        openQuestionTextArea_btn.click();
        waitUntilVisible(askQuestion_txtArea);
        clearText(askQuestion_txtArea);
        askQuestion_txtArea.sendKeys(question);
        askQuestion_btn.click();
    }

    public String getFirstQuestion() {
        waitUntilPageReady();
        waitUntilQuestionAdded(Global.map.get("Valid_Question").toString());
        waitUntilVisible(firstQuestion_lbl);
        return firstQuestion_lbl.getText();
    }

    public String errorMessageForInvalidQuestion() {
        waitUntilVisible(errorMessageForInvalidQuestion_lbl);
        return errorMessageForInvalidQuestion_lbl.getText() ;
    }

    public void chatNow(){
        try {
            if (chatNow_link.isDisplayed()) {
                scrollToView(returnAndWaranty_lbl);
                chatNow_link.click();
            }
        }
        catch (NoSuchElementException ex) {
            System.out.println("Chat Now feature is not enable for this venture");
        }

    }

    public boolean isMessageViewOpened() {
        return messageView_popup.isDisplayed();
    }

    public boolean isLeadtimeInfoDisplayed() {
        return (leadtimeSection_lbl.isDisplayed());
    }

    public boolean isLoginFormDisplayed() {
        waitUntilVisible(closeLoginForm_btn);
        return closeLoginForm_btn.isDisplayed();
    }

    public void closeLoginForm() {
        closeLoginForm_btn.click();
    }

    public void clickBuyNow() {
        waitUntilInvisibilityOf(By.cssSelector(".next-overlay-backdrop"));
        buyNow_btn.click();
    }

    public boolean addToCartSuccessMessage() {
        waitUntilVisible(cartMessageText_lbl);
        return cartMessageText_lbl.isDisplayed();
    }

    public void closeCartPopup() {
        waitUntilVisible(closeCartPopup_btn);
        closeCartPopup_btn.click();
    }

    public void increaseProductQuantity() {
        waitUntilVisible(plus_icon);
        plus_icon.click();
    }

    public void decreaseProductQuantity() {
        waitUntilVisible(minus_icon);
        minus_icon.click();
    }

    public int getItemQuantity() {
        return Integer.valueOf(itemQuantity_lbl.getAttribute("value"));
    }

    public int getMaxAvailableQuantity() {
        return Integer.valueOf(itemQuantity_lbl.getAttribute("max"));
    }

    public void enterProductQuantity(int itemNumber) {
        itemQuantity_lbl.sendKeys(String.valueOf(itemNumber));
    }

    public void clickChangeLink() {
        waitUntilVisible(changeLeadtime_link);
        changeLeadtime_link.click();
    }

    public void selectRandomAddress() {
        selectRandomLocationListItem();

        randomAddress = randomAddress + ", ";
        selectRandomLocationListItem();

        randomAddress = randomAddress + ", ";
        selectRandomLocationListItem();
    }

    private void selectRandomLocationListItem() {
        waitUntilInvisibilityOf(location_loading_icon_by);
        if (locationListItems.size() > 0) {
            int randomIndex = new Random().nextInt(locationListItems.size());
            WebElement random_element = locationListItems.get(randomIndex);
            randomAddress = randomAddress + random_element.getText();
            waitUntilVisible(random_element);
            random_element.click();
        }
    }

    public void waitUntilAddressChanged(String beforeChangedAddress){
        waitUntilInvisibilityOf(By.xpath(String.format("//div[text()[contains(.,'%s')]]", beforeChangedAddress)));
    }

    public String getCurrentAddress() {
        waitUntilInvisibilityOf(location_loading_icon_by);
        waitUntilInvisibilityOf(location_overlay_by);
        return leadtimeAddress_lbl.getText();
    }

    public void submitPostCode(String postCode) {
        postCode_txtField.click();
        postCode_txtField.sendKeys(postCode);
        postCodeSave_btn.click();
        waitUntilInvisibilityOf(postCodeSave_btn_by);
    }

    public void submitMessageToShop(String message) {
        waitUntilVisibility(firstSeller_btn_by);
        firstSeller_btn.click();
        waitUntilVisibility(messageInput_txtField_by);
        messageInput_txtField.sendKeys(message);
        waitUntilVisible(messageSend_btn);
        messageSend_btn.click();
    }

    public String messageListPopup(){
        waitUntilInvisibilityOf(messageLoading_icon_by);
        waitUntilVisible(messageList_popup);
        return messageList_popup.getText();
    }

    private void waitUntilQuestionAdded(String question){
        waitUntilVisibility(By.xpath(String.format("//div[text() = '%s']", question)));
    }

    public boolean changeProduct() { // I change the Product as per the COD limit rules
        if (page_url.contains(".bd")) {
            while (FLAG <= 5) {
                waitUntilVisible(productPrice_lbl);
                price = Float.parseFloat(productPrice_lbl.getText().replace("৳ ", "").replace(",", ""));
                if (price < 500 || price > 65000) {
                    FLAG++;
                    return true;
                } else {
                    FLAG = 6;
                    return false;
                }
            }
            throw new RuntimeException("There is no COD product available that suits the COD range");
        } if (page_url.contains(".sg")) {
            waitUntilVisible(productPrice_lbl);
            while (FLAG <= 5) {
                waitUntilVisible(productPrice_lbl);
                price = Float.parseFloat(productPrice_lbl.getText().replace("SGD", "").replace(",", ""));
                if (price > 500) {
                    FLAG++;
                    return true;
                } else {
                    FLAG = 6;
                    return false;
                }
            }
            throw new RuntimeException("There is no COD product available that suits the COD range");
        }
        return false;
    }

}
