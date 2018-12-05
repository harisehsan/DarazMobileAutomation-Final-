package member.desktop.pages.account;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_Reset_PassWord_Page extends PageObject {

    @FindBy(css = ".mod-input-newPassword input") private WebElement newPass_txtField;
    @FindBy(css = ".mod-input-re-newPassword input") private WebElement reNewPass_txtField;
    @FindBy(css = ".next-btn-primary") private WebElement submit_btn;

    public void resetPassword(String newPass) {
        waitUntilPageReady();
        waitUntilVisible(newPass_txtField);
        this.newPass_txtField.sendKeys(newPass);
        this.reNewPass_txtField.sendKeys(newPass);
        this.submit_btn.click();
    }
}