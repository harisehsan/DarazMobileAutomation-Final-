package member.desktop.pages.account;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_MyOrder_Page extends PageObject {

    @FindBy (css = ".link.bold") private WebElement cancelOrder;
    @FindBy (css = ".reason-col") private WebElement cancelReason;
    @FindBy (css = ".next-menu-content .next-menu-item:nth-of-type(1)") private WebElement firstReason;
    @FindBy (css = ".check-agreement") private WebElement checkAgreement;
    @FindBy (css = ".next-btn-normal") private WebElement submit;
    @FindBy (css = ".cancel-success") private WebElement cancelSuccess;


    public void clickCancelOrder(){
        waitUntilVisible(cancelOrder);
        cancelOrder.click();
    }

    public void chooseCancelReason(){
        waitUntilVisible(cancelReason);
        cancelReason.click();
        waitUntilVisible(firstReason);
        firstReason.click();
        waitUntilVisible(checkAgreement);
        checkAgreement.click();
        waitUntilVisible(submit);
        submit.click();
    }

    public boolean hasCancelSuccessTitle() {
        waitUntilVisible(cancelSuccess);
        return cancelSuccess.isDisplayed();
    }
}
