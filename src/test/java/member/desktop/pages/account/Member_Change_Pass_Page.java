package member.desktop.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_Change_Pass_Page extends PageObject {

    public static String page_url = Global.getConfig().getString("member.url") + "/user/change-password";

    @FindBy(css = ".mod-input-password input") private WebElement currentPass_txtField;
    @FindBy(css = ".mod-input-newPassword input") private WebElement newPass_txtField;
    @FindBy(css = ".mod-input-re-newPassword input") private WebElement reNewPass_txtField;
    @FindBy(css = ".next-btn-large") private WebElement save_btn;
    @FindBy(css = ".next-btn-medium") private WebElement okSaveChangePass_btn;

    public void resetPass(String oldPass,String newPass) {
        waitUntilPageReady();
        waitUntilVisible(currentPass_txtField);
        this.currentPass_txtField.sendKeys(oldPass);
        this.newPass_txtField.sendKeys(newPass);
        this.reNewPass_txtField.sendKeys(newPass);
        this.save_btn.click();
        waitUntilVisible(okSaveChangePass_btn);
        this.okSaveChangePass_btn.click();
    }
}