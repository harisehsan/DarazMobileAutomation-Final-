package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class Member_SignUp_SMS_Page extends PageObject {
    public static String page_url = Global.config.getString("member.url") + "/user/register";

    @FindBy(css = ".mod-input-phone input") private WebElement inputphone;
    @FindBy(className = "mod-sendcode") private WebElement sendcode;
    @FindBy(css = "[type='number']") private WebElement inputsmscode;
    @FindBy(css = ".mod-input-password input") private WebElement inputpassword;
    @FindBy(css = "[type='text']") private WebElement inputemail;
    @FindBy(className = "mod-login-btn") private WebElement submitbutton;

    public void setInputphone(String s) {
        waitUntilPageReady();
        waitUntilVisible(inputphone);
        this.inputphone.sendKeys(s);
    }

    public void setSendcode(){
        waitUntilPageReady();
        waitUntilVisible(sendcode);
        this.sendcode.click();
    }

    public void setInputsmscode(String m){
        waitUntilPageReady();
        waitUntilVisible(inputsmscode);
        this.inputsmscode.sendKeys(m);
    }

    public void setInputpassword(String p){
        waitUntilPageReady();
        waitUntilVisible(inputpassword);
        this.inputpassword.sendKeys(p);

    }

    public void setInputemail(String e){
        waitUntilPageReady();
        waitUntilVisible(inputemail);
        this.inputemail.sendKeys(e);
    }

    public void setSubmitbutton(){
        waitUntilPageReady();
        waitUntilVisible(submitbutton);
        this.submitbutton.click();
    }

}
