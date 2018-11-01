package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Loginsms_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/login";

    @FindBy(css = ".mod-input-phone input") private WebElement inputphone;
    @FindBy(className = "mod-sendcode") private WebElement clicksendcode;
    @FindBy(css =".mod-input-sms input") private WebElement inputsmscode;
    @FindBy(className = "login-btn") private WebElement clickloginbtn;

    public void inputPhone(String phone){
        waitUntilPageReady();
        this.inputphone.sendKeys(phone);
    }

    public void clickSendCode() {
        waitUntilPageReady();
        this.clicksendcode.click();
    }

    public void inputSMSCode(String code){
        waitUntilPageReady();
        this.inputsmscode.sendKeys(code);
    }

    public void clickLoginBtn(){
        waitUntilPageReady();
        this.clickloginbtn.click();
    }
}
