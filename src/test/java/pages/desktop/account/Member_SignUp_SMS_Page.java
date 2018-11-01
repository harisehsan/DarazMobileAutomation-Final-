package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
    @FindBy(css = ".btn_slide") private WebElement sliderbtn;

    public void inputPhone(String phone) {
        waitUntilPageReady();
        waitUntilVisible(inputphone);
        this.inputphone.sendKeys(phone);
    }

    public void sendCode(){
        waitUntilPageReady();
        waitUntilVisible(sendcode);
        this.sendcode.click();
    }

    public void inputSMSCode(String smsCode){
        waitUntilPageReady();
        waitUntilVisible(inputsmscode);
        this.inputsmscode.sendKeys(smsCode);
    }

    public void inputPassword(String passWord){
        waitUntilPageReady();
        waitUntilVisible(inputpassword);
        this.inputpassword.sendKeys(passWord);

    }

    public void inputEmail(String email){
        waitUntilPageReady();
        waitUntilVisible(inputemail);
        this.inputemail.sendKeys(email);
    }

    public void submitButton(){
        waitUntilPageReady();
        waitUntilVisible(submitbutton);
        this.submitbutton.click();
    }

    public void setSliderbtn(){
        Actions move = new Actions(Global.browser.getWebDriver());
        Action actions = move.clickAndHold(sliderbtn).moveByOffset(500,0).release().build();
        actions.perform();
    }

}
