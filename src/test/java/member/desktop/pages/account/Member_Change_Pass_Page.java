package member.desktop.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_Change_Pass_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/change-password";

    @FindBy(css = ".mod-input-password input") private WebElement currentPass;
    @FindBy(css = ".mod-input-newPassword input") private WebElement newPass;
    @FindBy(css = ".mod-input-re-newPassword input") private WebElement reNewPass;
    @FindBy(css = ".next-btn-large") private WebElement saveBtn;
    @FindBy(css = ".next-btn-medium") private WebElement okBtn;

    public void resetPass(String oldPass,String newPass) {
        waitUntilPageReady();
        waitUntilVisible(currentPass);
        this.currentPass.sendKeys(oldPass);
        this.newPass.sendKeys(newPass);
        this.reNewPass.sendKeys(newPass);
        this.saveBtn.click();
        waitUntilVisible(okBtn);
        this.okBtn.click();
    }
}