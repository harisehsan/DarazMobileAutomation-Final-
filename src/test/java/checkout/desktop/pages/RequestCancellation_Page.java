package checkout.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestCancellation_Page extends PageObject {

//    @FindBy(css = ".reason-col") private WebElement cancelReason;
    @FindBy (className = "next-select-inner") private WebElement cancelReason_drpDownList;
    @FindBy (className = "policy-title") private WebElement cancelPolicy_lbl;
    @FindBy (css = ".next-menu-content .next-menu-item:nth-of-type(1)") private WebElement firstReason;
    @FindBy (css = ".check-agreement") private WebElement checkAgreement;
    @FindBy (css = ".next-btn-normal") private WebElement submit;

    public void chooseCancelReason(){
        waitUntilVisible(cancelReason_drpDownList);
        cancelReason_drpDownList.click();
        waitUntilVisible(firstReason);
        firstReason.click();
        waitUntilVisible(checkAgreement);
        checkAgreement.click();
        waitUntilVisible(submit);
        scrollToView(cancelPolicy_lbl);
        clickWithoutException(submit);
    }

}
