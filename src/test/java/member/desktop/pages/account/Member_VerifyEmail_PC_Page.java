package member.desktop.pages.account;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_VerifyEmail_PC_Page extends PageObject {

    @FindBy(css = ".mod-input-sms input") private WebElement inputSMSCode;
    @FindBy(className = "primary") private WebElement verifyBtn;
    @FindBy(className = "mod-sendcode-btn") private WebElement sendCodeBtn;

    public void processVerifyEmailBtn() {
        waitUntilPageReady();
        waitUntilVisible(sendCodeBtn);
        this.sendCodeBtn.click();
    }

    public void inputSMSCode(String smsCode) {
        waitUntilPageReady();
        waitUntilVisible(inputSMSCode);
        this.inputSMSCode.click();
        this.inputSMSCode.sendKeys(smsCode);
    }

    public void clickVerifyCodeBtn() {
        this.verifyBtn.click();
    }

}
