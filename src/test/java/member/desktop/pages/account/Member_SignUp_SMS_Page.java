package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_SignUp_SMS_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/register";

    @FindBy(css = ".mod-input-phone input") private WebElement inputPhone;
    @FindBy(className = "mod-sendcode") private WebElement sendCode;
    @FindBy(css = "[type='number']") private WebElement inputSMSCode;
    @FindBy(css = ".mod-input-password input") private WebElement inputPassWord;
    @FindBy(css = ".mod-input-email input") private WebElement inputEmail;
    @FindBy(className = "mod-login-btn") private WebElement submitBtn;
    @FindBy(css = ".btn_slide") private WebElement sliderBtn;
    @FindBy(css = ".mod-input-name input") private WebElement nameInfo;

    public void signUpBySMS(String smsCode, String passWord, String name, String email){
        waitUntilPageReady();
        waitUntilVisible(sendCode);
        this.sendCode.click();
        this.inputSMSCode.sendKeys(smsCode);
        this.inputPassWord.sendKeys(passWord);
        this.nameInfo.sendKeys(name);
        this.inputEmail.sendKeys(email);
    }

    public void inputPhoneNumber(String phone) {
        waitUntilPageReady();
        waitUntilVisible(inputPhone);
        this.inputPhone.sendKeys(phone);
    }

    public void submitButton(){
        waitUntilPageReady();
        waitUntilVisible(submitBtn);
        this.submitBtn.click();
    }

    public void setSliderbtn(){
        Actions move = new Actions(Global.browser.getWebDriver());
        Action actions = move.clickAndHold(sliderBtn).moveByOffset(500,0).release().build();
        actions.perform();
    }
}