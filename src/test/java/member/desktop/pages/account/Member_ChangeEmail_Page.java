package member.desktop.pages.account;

import allure.AllureAttachment;
import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class Member_ChangeEmail_Page extends PageObject {

    @FindBy(css = ".mod-input.mod-input-email input") private WebElement newEmail_txtField;
    @FindBy(className = "mod-sendcode") private WebElement send_btn;
    @FindBy(css = ".fields-footer > button") private WebElement verifyCode_btn;
    @FindBy(css = ".my-profile-bd > div:nth-child(2) > div") private WebElement emailInformation_lbl;

    private By send_btn_by = By.className("mod-sendcode");
    private By newEmail_txtField_by = By.cssSelector(".mod-input.mod-input-email input");

    public void sendCodeToMailAfterChanging(String email) throws InterruptedException {
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