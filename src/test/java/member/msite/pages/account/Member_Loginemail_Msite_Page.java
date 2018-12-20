package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Loginemail_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.msite_url") + "/user/login";

    @FindBy(css = ".mod-input-loginName input") private WebElement email_txtField;
    @FindBy(css = ".mod-input-password input") private WebElement password_txtField;
    @FindBy(css = ".login-btn > button") private WebElement login_btn;
    @FindBy(css = ".login-foot-btn") private WebElement smsLogin_btn;
    @FindBy(css = "div.login-forgot > a") private WebElement forgotPassword_btn;

    private By smsLogin_btn_by = By.cssSelector(".login-foot-btn");

    public void inputEmail(String email) {
        waitUntilPageReady();
        this.email_txtField.sendKeys(email);
    }

    public void inputPass(String pass) {
        waitUntilPageReady();
        this.password_txtField.sendKeys(pass);
    }

    public void clickLoginButton() {
        waitUntilPageReady();
        this.login_btn.click();
    }

    public void clickSMSButton(){
        waitUntilPageReady();
        waitUntilClickable(smsLogin_btn_by);
        this.smsLogin_btn.click();
    }

    public void logInByEmail(String emailAddress,String passWord) {
        waitUntilPageReady();
        waitUntilVisible(email_txtField);
        this.email_txtField.sendKeys(emailAddress);
        this.password_txtField.sendKeys(passWord);
    }

    public boolean hasLoginForm() {
        waitUntilPageReady();
        waitUntilVisible(email_txtField);
        return email_txtField.isDisplayed();
    }
}