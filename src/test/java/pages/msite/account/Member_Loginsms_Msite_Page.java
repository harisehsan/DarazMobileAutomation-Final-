package pages.msite.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class Member_Loginsms_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/login";

    @FindBy(css = ".mod-input-phone input") private WebElement inputphone;
    @FindBy(className = "mod-sendcode") private WebElement clicksendcode;
    @FindBy(css =".mod-input-sms input") private WebElement inputsmscode;
    @FindBy(className = "login-btn") private WebElement clickloginbtn;

    public void setInputPhone(String p){
        waitUntilPageReady();
        this.inputphone.sendKeys(p);
    }

    public void setClickSendCode() {
        waitUntilPageReady();
        this.clicksendcode.click();
    }

    public void setInputSMSCode(String c){
        waitUntilPageReady();
        this.inputsmscode.sendKeys(c);
    }

    public void setClickLoginbtn(){
        waitUntilPageReady();
        this.clickloginbtn.click();
    }
}
