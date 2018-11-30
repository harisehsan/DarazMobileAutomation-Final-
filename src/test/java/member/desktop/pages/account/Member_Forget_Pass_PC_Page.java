package member.desktop.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_Forget_Pass_PC_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/forget-password";

    //    @FindBy(css = "#container > div > div > div > div > div.forgot-form > div > input[type=\"text\"]") private WebElement inputEmail;
    @FindBy(css = "div > input[type='text']")
    private WebElement inputEmail;
    @FindBy(css = ".next-btn-large") private WebElement clickSubmitBtn;
    @FindBy(className = "buttons") private WebElement verifyEmailBtn;
    @FindBy(css = ".mod-input-sms") private WebElement inputSMSCode;
    @FindBy(className = "primary") private WebElement verifyBtn;
    @FindBy(className = "mod-sendcode-btn") private WebElement sendCodeBtn;

    public void inputEmail(String email) {
        waitUntilPageReady();
        waitUntilVisible(inputEmail);
        this.inputEmail.sendKeys(email);
        this.clickSubmitBtn.click();
    }

    public void clickVerifyEmailBtn() {
        waitUntilPageReady();
        waitUntilVisible(verifyEmailBtn);
        this.verifyEmailBtn.click();
    }
}