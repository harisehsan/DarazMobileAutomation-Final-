package member.desktop.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_Forget_Pass_PC_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/forget-password";

    @FindBy(css = "div > input[type='text']")
    private WebElement email_txtField;
    @FindBy(css = ".next-btn-large")
    private WebElement submit_btn;
    @FindBy(className = "buttons")
    private WebElement verifyEmail_btn;
    @FindBy(css = ".mod-input-sms")
    private WebElement smsCode_txtField;
    @FindBy(className = "primary")
    private WebElement verifyCode_btn;
    @FindBy(className = "mod-sendcode-btn")
    private WebElement sendCode_btn;

    public void inputEmail(String email) {
        waitUntilPageReady();
        waitUntilVisible(email_txtField);
        this.email_txtField.sendKeys(email);
        this.submit_btn.click();
    }

    public void clickVerifyEmailBtn() {
        waitUntilPageReady();
        waitUntilVisible(verifyEmail_btn);
        this.verifyEmail_btn.click();
    }
}