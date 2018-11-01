package member.msite.pages.msite.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_SIgnupsms_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/register";

    @FindBy(css = ".mod-input-phone input") private WebElement inputphone;
    @FindBy(className = "mod-sendcode-btn") private WebElement clicksend;
    @FindBy(css = ".mod-input-sms input") private WebElement inputsmscode;
    @FindBy(className = "signup-by-mobile-btn") private WebElement clickcontinue;

    public void setInputphone(String p){
        waitUntilPageReady();
        this.inputphone.sendKeys(p);
    }

    public void setClicksend() {
        waitUntilPageReady();
        this.clicksend.click();
    }

    public void setInputsmscode(String s) {
        waitUntilPageReady();
        this.inputsmscode.sendKeys(s);
    }

    public void setClickcontinue() {
        waitUntilPageReady();
        this.clickcontinue.click();
    }
}
