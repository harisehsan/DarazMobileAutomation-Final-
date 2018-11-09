package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Loginemail_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/login";

    @FindBy(css = ".mod-input-loginName input") private WebElement inputemail;
    @FindBy(css =".mod-input-password input") private WebElement inputpass;
    @FindBy(css = "#container > div > div > div > div > div.login-btn > button") private WebElement clickloginbutton;
    @FindBy(css = ".login-foot-btn") private WebElement clicksmsbutton;


    public void inputEmail(String email) {
        waitUntilPageReady();
        this.inputemail.sendKeys(email);
    }

    public void inputPass(String pass) {
        waitUntilPageReady();
        this.inputpass.sendKeys(pass);
    }

    public void clickLoginButton(){
        waitUntilPageReady();
        this.clickloginbutton.click();
    }

    public void clickSMSButton(){
        waitUntilPageReady();
        this.clicksmsbutton.click();
    }

    public void waitUnstillVisible(){
        waitUntilPageReady();
        waitUntilVisible(clickloginbutton);
    }


}
