package member.desktop.pages.account;

import allure.AllureAttachment;
import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class Member_Change_Email_Pass_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/change-password";

    @FindBy(css = ".mod-input-password input") private WebElement currentPass_txtField;
    @FindBy(css = ".mod-input-newPassword input") private WebElement newPass_txtField;
    @FindBy(css = ".mod-input-re-newPassword input") private WebElement reNewPass_txtField;
    @FindBy(css = ".next-btn-large") private WebElement save_btn;
    @FindBy(css = ".next-btn-medium") private WebElement okSaveChangePass_btn;
    @FindBy(css = ".mod-input.mod-input-email input") private WebElement newEmail_txtField;
    @FindBy(className = "mod-sendcode") private WebElement send_btn;
    @FindBy(css = ".fields-footer > button") private WebElement verifyCode_btn;
    @FindBy(css = ".my-profile-bd > div:nth-child(2) > div") private WebElement emailInformation_lbl;

    private By send_btn_by = By.className("mod-sendcode");
    private By newEmail_txtField_by = By.cssSelector(".mod-input.mod-input-email input");


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

    public void sendCodeToMailAfterChanging(String email) {
        waitUntilPageReady();
        waitUntilVisibility(newEmail_txtField_by);
        this.newEmail_txtField.sendKeys(email);
        waitUntilClickable(send_btn_by);
        this.send_btn.click();
    }

    public boolean hasEmailChanging(String email) {
        waitUntilPageReady();
        waitUntilVisible(emailInformation_lbl);
        return this.emailInformation_lbl.getText().equals(email);
    }

    public void allureReportEmailChanging(String currentEmail) {
        AllureAttachment.attachURL(currentUrl());
        AllureAttachment.attachComment("Current email",currentEmail);
    }
}