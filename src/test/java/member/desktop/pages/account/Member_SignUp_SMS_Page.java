package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_SignUp_SMS_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/register";

    @FindBy(css = ".mod-input-phone input")
    private WebElement phone_txtField;
    @FindBy(className = "mod-sendcode")
    private WebElement sendCode_btn;
    @FindBy(css = "[type='number']")
    private WebElement smsCode_txtField;
    @FindBy(css = ".mod-input-password input")
    private WebElement passWord_txtField;
    @FindBy(css = ".mod-input-email input")
    private WebElement email_txtField;
    @FindBy(className = "mod-login-btn")
    private WebElement submit_btn;
    @FindBy(css = ".btn_slide")
    private WebElement slider_btn;
    @FindBy(css = ".mod-input-name input")
    private WebElement name_txtField;

    public void signUpBySMS(String smsCode, String passWord, String name, String email){
        waitUntilPageReady();
        waitUntilVisible(sendCode_btn);
        this.sendCode_btn.click();
        this.smsCode_txtField.sendKeys(smsCode);
        this.passWord_txtField.sendKeys(passWord);
        this.name_txtField.sendKeys(name);
        this.email_txtField.sendKeys(email);
    }

    public void inputPhoneNumber(String phone) {
        waitUntilPageReady();
        waitUntilVisible(phone_txtField);
        this.phone_txtField.sendKeys(phone);
    }

    public void submitButton(){
        waitUntilPageReady();
        waitUntilVisible(submit_btn);
        this.submit_btn.click();
    }

    public void setSliderbtn(){
        Actions move = new Actions(Global.browser.getWebDriver());
        Action actions = move.clickAndHold(slider_btn).moveByOffset(500, 0).release().build();
        actions.perform();
    }
}