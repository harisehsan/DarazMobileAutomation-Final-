package member.desktop.pages.account;

import base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_VerifyEmail_PC_Page extends PageObject {

    @FindBy(css = ".mod-input-sms input") private WebElement smsCode_txtField;
    @FindBy(className = "primary") private WebElement verify_btn;
    @FindBy(className = "mod-sendcode-btn") private WebElement sendCode_btn;

    public void processVerifyEmailBtn() {
        waitUntilPageReady();
        waitUntilVisible(sendCode_btn);
        this.sendCode_btn.click();
    }

    public void inputSMSCode(String smsCode) {
        waitUntilPageReady();
        waitUntilVisible(smsCode_txtField);
        this.smsCode_txtField.sendKeys(smsCode);
    }

    public void clickVerifyCodeBtn() {
        this.verify_btn.click();
    }
}