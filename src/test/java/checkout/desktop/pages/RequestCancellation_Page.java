package checkout.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestCancellation_Page extends PageObject {

    @FindBy(css = ".reason-col") private WebElement cancelReason;
    @FindBy (css = ".next-menu-content .next-menu-item:nth-of-type(1)") private WebElement firstReason;
    @FindBy (css = ".check-agreement") private WebElement checkAgreement;
    @FindBy (css = ".next-btn-normal") private WebElement submit;

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

}
