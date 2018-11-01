package member.msite.pages.msite.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Loginemail_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/login";

    @FindBy(css = ".mod-input-loginName input") private WebElement inputemail;
    @FindBy(css =".mod-input-password input") private WebElement inputpass;
    @FindBy(className = "login-btn") private WebElement clickloginbutton;
    @FindBy(css = ".login-foot-btn") private WebElement clicksmsbutton;


    public void setInputemail(String e) {
        waitUntilPageReady();
        this.inputemail.sendKeys(e);
    }

    public void setInputpass(String p) {
        waitUntilPageReady();
        this.inputpass.sendKeys(p);
    }

    public void setClickloginbutton(){
        waitUntilPageReady();
        this.clickloginbutton.click();
    }

    public void setClicksmsbutton(){
        waitUntilPageReady();
        this.clicksmsbutton.click();
    }

    public void waitUnstillVisible(){
        waitUntilPageReady();
        waitUntilVisible(clickloginbutton);
    }


}
