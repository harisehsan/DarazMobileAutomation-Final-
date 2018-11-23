package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Login_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url")+"/user/login";

    @FindBy(css = ".mod-input-loginName input") private WebElement email;
    @FindBy(css = "[type='password']") private WebElement passWord;
    @FindBy(css = ".mod-login-btn") private WebElement submit;
    @FindBy(className = "mod-login-btn") private WebElement login;
    @FindBy(className = "mod-login-forgot") private WebElement resetPassBtn;

    public void submitButton() {
        waitUntilVisible(submit);
        waitUntilPageReady();
        submit.click();
    }

    public boolean hasID() {
        waitUntilVisible(login);
        return this.login.isEnabled();
    }

    public void clickResetPassBtn() {
        waitUntilPageReady();
        this.resetPassBtn.click();
    }

    public void loginEmailPass(String emailInfo, String newPass) {
        waitUntilPageReady();
        waitUntilVisible(email);
        this.email.sendKeys(emailInfo);
        this.passWord.sendKeys(newPass);
        waitUntilClickable(By.cssSelector(".mod-login-btn"));
        this.submit.click();
        waitUntilInvisibilityOf(By.cssSelector(".mod-login-btn"));
    }
}