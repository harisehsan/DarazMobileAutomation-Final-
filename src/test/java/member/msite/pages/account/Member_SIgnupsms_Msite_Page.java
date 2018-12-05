package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_SIgnupsms_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.msite_url") + "/user/register";

    @FindBy(css = ".mod-input-phone input") private WebElement phone_txtField;
    @FindBy(className = "mod-sendcode-btn") private WebElement send_btn;
    @FindBy(css = ".mod-input-sms input") private WebElement smsCode_txtField;
    @FindBy(className = "signup-by-mobile-btn") private WebElement continue_btn;

    private By send_btn_by = By.className("mod-sendcode-btn");
    private By continue_btn_by = By.className("signup-by-mobile-btn");

    public void inputPhone(String phone) {
        waitUntilPageReady();
        this.phone_txtField.sendKeys(phone);
    }

    public void clickSend() {
        waitUntilPageReady();
        waitUntilClickable(send_btn_by);
        this.send_btn.click();
    }

    public void inputSMSCode(String smsCode) {
        waitUntilPageReady();
        this.smsCode_txtField.sendKeys(smsCode);
    }

    public void clickContinue() {
        waitUntilPageReady();
        waitUntilClickable(continue_btn_by);
        this.continue_btn.click();
    }
}