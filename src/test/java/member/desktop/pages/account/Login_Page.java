package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

/**
 * Created by admin.son.ton on 1/25/18.
 */

public class Login_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") +"/user/login";

    @FindBy(css = ".mod-input-loginName input")
    private WebElement email_txtField;
    @FindBy(css = "[type='password']")
    private WebElement password_txtField;
    @FindBy(css = ".mod-login-btn button")
    private WebElement submit_btn;

    public void logIn(String email, String password){
        waitUntilPageReady();
        this.email_txtField.sendKeys(email);
        this.password_txtField.sendKeys(password);
        submit_btn.click();
        waitUntilPageReady();
    }
}