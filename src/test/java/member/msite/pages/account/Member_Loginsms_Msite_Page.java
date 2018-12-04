package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Loginsms_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.msite_url") + "/user/login";

    @FindBy(css = ".mod-input-phone input") private WebElement phone_txtField;
    @FindBy(className = "mod-sendcode") private WebElement sendCode_btn;
    @FindBy(css = ".mod-input-sms input") private WebElement smsCode_txtField;
    @FindBy(className = "login-btn") private WebElement login_btn;

    public void inputPhone(String phone) {
        waitUntilPageReady();
        this.phone_txtField.sendKeys(phone);
    }

    public void clickSendCode() {
        waitUntilPageReady();
        this.sendCode_btn.click();
    }

    public void inputSMSCode(String code ) {
        waitUntilPageReady();
        this.smsCode_txtField.sendKeys(code);
    }

    public void clickLoginBtn() {
        waitUntilPageReady();
        this.login_btn.click();
    }
}