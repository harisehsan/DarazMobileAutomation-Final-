package pages.desktop.asc.orders_management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class Rts_Form extends PageObject {

    @FindBy(css = ".rts-dialog .next-select-inner") private WebElement rts_shipping_provider_button;
    @FindBy(css = ".rts-dialog .next-btn-primary") private WebElement save_button;
    @FindBy(css = ".rts-dialog input[type='text']") private WebElement invoice_input;
    @FindBy(xpath = "//li[contains(.,'Wrong Price or Pricing Error')]") private WebElement price_err_reason_listitem;
    @FindBy(css = ".cancel-dialog .last") private WebElement cancel_info_row;
    @FindBy(css = ".rts-dialog .next-dialog-close") private WebElement close_button;




    private By rtsDialog_by = By.cssSelector(".rts-dialog");
    private By rtsShippingProvider_by = By.cssSelector(".rts-dialog .next-select-inner");
    private By rtsInvoiceInput_by = By.cssSelector(".rts-dialog input[type='text']");
    private By rtsConfirmForm_by = By.cssSelector(".confirmRts");
    private By loadingIcon_by = By.cssSelector(".next-feedback-loading");

    private void waitUntilPageLoaded(){
        waitUntilInvisibilityOf(loadingIcon_by);
    }

    public void performRTS(){
        waitUntilPageReady();
//        rts_reason_dropdown.click();


        waitUntilVisibility(rtsDialog_by);
        waitUntilPageLoaded();
        save_button.click();
        waitUntilPageLoaded();
        save_button.click();
        waitUntilPageLoaded();
//        save_button.click();
//        waitUntilPageLoaded();
//        waitUntilInvisibilityOf(rtsConfirmForm_by);
        close_button.click();
        waitUntilPageLoaded();
        waitUntilInvisibilityOf(rtsDialog_by);
    }





}
