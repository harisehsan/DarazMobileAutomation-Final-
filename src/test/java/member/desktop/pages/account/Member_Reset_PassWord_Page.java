package member.desktop.pages.account;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_Reset_PassWord_Page extends PageObject {

    @FindBy(css =".mod-input-newPassword input") private WebElement inputNewPass;
    @FindBy(css = ".mod-input-re-newPassword input") private WebElement reInputNewPass;
    @FindBy(css = ".next-btn-primary") private WebElement submitBtn;

    public void resetPassword(String newPass){
        waitUntilPageReady();
        waitUntilVisible(inputNewPass);
        this.inputNewPass.sendKeys(newPass);
        this.reInputNewPass.sendKeys(newPass);
        this.submitBtn.click();
    }

}
