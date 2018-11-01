package pages.msite.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class Member_Loginemail_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/login";

    @FindBy(css = ".mod-input-loginName input") private WebElement inputemail;
    @FindBy(css =".mod-input-password input") private WebElement inputpass;
    @FindBy(className = "login-btn") private WebElement clickloginbutton;
    @FindBy(css = ".login-foot-btn") private WebElement clicksmsbutton;


    public void setInputEmail(String e) {
        waitUntilPageReady();
        this.inputemail.sendKeys(e);
    }

    public void setInputPass(String p) {
        waitUntilPageReady();
        this.inputpass.sendKeys(p);
    }

    public void setClickLoginButton(){
        waitUntilPageReady();
        this.clickloginbutton.click();
    }

    public void setClickSMSButton(){
        waitUntilPageReady();
        this.clicksmsbutton.click();
    }

    public void waitUnstillVisible(){
        waitUntilPageReady();
        waitUntilVisible(clickloginbutton);
    }


}
