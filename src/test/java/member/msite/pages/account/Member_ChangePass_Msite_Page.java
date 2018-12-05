package member.msite.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_ChangePass_Msite_Page extends PageObject {
    public static String page_url = Global.config.getString("member.msite_url") + "/user/change-password";

    @FindBy(css = ".mod-input-password input") private WebElement oldPass_txtField;
    @FindBy(css = ".mod-input-newPassword input") private WebElement newPass_txtField;
    @FindBy(css = ".mod-input-re-newPassword input") private WebElement reNewPass_txtField;
    @FindBy(css = ".mod-button") private WebElement save_btn;
    @FindBy(css = "div.mod-dialog-ft > button") private WebElement gotIt_btn;

    private By save_btn_by = By.cssSelector(".mod-button");
    private By gotIt_btn_by = By.cssSelector("div.mod-dialog-ft > button");

    public void setNewPassWord(String oldPassWord, String newPassWord) {
        waitUntilPageReady();
        waitUntilVisible(oldPass_txtField);
        this.oldPass_txtField.sendKeys(oldPassWord);
        this.newPass_txtField.sendKeys(newPassWord);
        this.reNewPass_txtField.sendKeys(newPassWord);
    }

    public void saveButton() {
        waitUntilPageReady();
        waitUntilClickable(save_btn_by);
        this.save_btn.click();
    }

    public void gotItButton() {
        waitUntilClickable(gotIt_btn_by);
        this.gotIt_btn.click();
    }
}