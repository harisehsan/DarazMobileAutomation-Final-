package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_AccEdit_PC_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/profile#/profile/edit";

    @FindBy(css = ".mod-input-name input") private WebElement editName_txtField;
    @FindBy(className = "mod-input-close-icon") private WebElement clearOldName_btn;
    @FindBy(css = ".next-btn-large") private WebElement saveChanges_btn;
    @FindBy(css = "div > div:nth-child(2) > h3 > a") private WebElement changeEmail_btn;
    @FindBy(className = "buttons") private WebElement verifyEmail_btn;
    @FindBy(className = "mod-sendcode") private WebElement sendCode_btn;

    private By changeEmail_btn_by = By.cssSelector("div > div:nth-child(2) > h3 > a");
    private By verifyEmail_btn_by = By.className("buttons");
    private By sendCode_btn_by = By.className("mod-sendcode");

    public void clearOldName() {
        waitUntilPageReady();
        waitUntilVisible(clearOldName_btn);
        this.clearOldName_btn.click();
    }

    public void editName(String newName) {
        waitUntilPageReady();
        waitUntilVisible(editName_txtField);
        this.editName_txtField.sendKeys(newName);
    }

    public void saveChangesBtn() {
        waitUntilPageReady();
        waitUntilVisible(saveChanges_btn);
        this.saveChanges_btn.click();
    }

    public void sendCodeToInboxMail() {
        waitUntilPageReady();
        waitUntilClickable(changeEmail_btn_by);
        this.changeEmail_btn.click();
        waitUntilClickable(verifyEmail_btn_by);
        this.verifyEmail_btn.click();
        waitUntilClickable(sendCode_btn_by);
        this.sendCode_btn.click();
    }
}