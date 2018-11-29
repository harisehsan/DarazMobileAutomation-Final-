package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_SIgnupsms_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/register";

    @FindBy(css = ".mod-input-phone input") private WebElement inputphone;
    @FindBy(className = "mod-sendcode-btn") private WebElement clicksend;
    @FindBy(css = ".mod-input-sms input") private WebElement inputsmscode;
    @FindBy(className = "signup-by-mobile-btn") private WebElement clickcontinue;

    public void inputPhone(String phone){
        waitUntilPageReady();
        this.inputphone.sendKeys(phone);
    }

    public void clickSend() {
        waitUntilPageReady();
        waitUntilClickable(By.className("mod-sendcode-btn"));
        this.clicksend.click();
    }

    public void inputSMSCode(String smsCode) {
        waitUntilPageReady();
        this.inputsmscode.sendKeys(smsCode);
    }

    public void clickContinue() {
        waitUntilPageReady();
        waitUntilClickable(By.className("signup-by-mobile-btn"));
        this.clickcontinue.click();
    }
}