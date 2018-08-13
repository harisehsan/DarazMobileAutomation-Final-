package pages.asc.orders_management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class Cancel_Form extends PageObject {

    @FindBy(css = ".cancel-dialog .next-select-placeholder") private WebElement cancel_reason_dropdown;
    @FindBy(css = ".cancel-dialog .next-btn-primary") private WebElement save_button;
    @FindBy(xpath = "//li[contains(.,'Out of Stock')]") private WebElement oos_reason_listitem;
    @FindBy(xpath = "//li[contains(.,'Wrong Price or Pricing Error')]") private WebElement price_err_reason_listitem;
    @FindBy(css = ".cancel-dialog .last") private WebElement cancel_info_row;
    @FindBy(css = ".cancel-dialog .next-dialog-close") private WebElement close_button;


    private By cancelDialog_by = By.cssSelector(".cancel-dialog");
    private By cancelReasonList_by = By.cssSelector(".expandInDown");
    private By cancelSuccessfull_by = By.xpath("//div[@class='next-feedback-content' and contains(.,'Cancellation is successful')]");
    private By loadingIcon_by = By.cssSelector(".next-feedback-loading");
    private By cancelInfoRow_by = By.cssSelector(".cancel-dialog .last");

    private void waitUntilPageLoaded(){
        waitUntilPageReady();
        waitUntilInvisibilityOf(loadingIcon_by);
    }

    public void performCancel(){
        waitUntilPageLoaded();
        cancel_reason_dropdown.click();
        waitUntilVisibility(cancelReasonList_by);
        price_err_reason_listitem.click();
        save_button.click();
        waitUntilPageLoaded();
        waitUntilVisibility(cancelSuccessfull_by);
        cancel_info_row.getText();
        waitUntilPageLoaded();
        save_button.click();
        waitUntilPageLoaded();
    }





}
