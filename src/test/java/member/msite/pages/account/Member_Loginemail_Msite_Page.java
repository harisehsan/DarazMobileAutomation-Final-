package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Loginemail_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/login";

    @FindBy(css = ".mod-input-loginName input") private WebElement inputEmail;
    @FindBy(css =".mod-input-password input") private WebElement inputPass;
    //    @FindBy(css = "#container > div > div > div > div > div.login-btn > button") private WebElement clickLoginBtn;
    @FindBy(css = "div.login-btn > button")
    private WebElement clickLoginBtn;
    @FindBy(css = ".login-foot-btn") private WebElement clickSMSBtn;
    //    @FindBy(css = "#container > div > div > div > div > div.login-main > div > div.login-forgot > a") private WebElement forgotPassBtn;
    @FindBy(css = "div.login-forgot > a")
    private WebElement forgotPassBtn;

    public void inputEmail(String email) {
        waitUntilPageReady();
        this.inputEmail.sendKeys(email);
    }

    public void inputPass(String pass) {
        waitUntilPageReady();
        this.inputPass.sendKeys(pass);
    }

    public void clickLoginButton(){
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("div.login-btn > button"));
        this.clickLoginBtn.click();
    }

    public void clickSMSButton(){
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector(".login-foot-btn"));
        this.clickSMSBtn.click();
    }

    public void logInByEmail(String emailAddress,String passWord) {
        waitUntilPageReady();
        waitUntilVisible(inputEmail);
        this.inputEmail.sendKeys(emailAddress);
        this.inputPass.sendKeys(passWord);
    }

    public boolean hasLoginForm() {
        waitUntilPageReady();
        waitUntilVisible(inputEmail);
        return inputEmail.isDisplayed();
    }
}