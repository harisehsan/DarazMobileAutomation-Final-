package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

/**
 * Created by admin.son.ton on 1/26/18.
 */

public class SignUp_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/register";

    @FindBy(className = "mod-change-register-btn")
    private WebElement emailbutton;
    @FindBy(css = ".mod-input-email input")
    private WebElement email;
    @FindBy(css = ".mod-input-password input")
    private WebElement password;
    @FindBy(css = ".mod-input-name input")
    private WebElement name;
    @FindBy(className = "mod-login-btn")
    private WebElement submit;

    public void signEmail() {
        waitUntilPageReady();
        emailbutton.click();
    }

    public void emailTextFiel(String emailinfo) {
        waitUntilPageReady();
        waitUntilVisible(email);
        this.email.sendKeys(emailinfo);
    }

    public void passwordfield(String pass) {
        waitUntilPageReady();
        waitUntilVisible(password);
        this.password.sendKeys(pass);
    }


    public void namefield(String nameinfo) {
        waitUntilPageReady();
        waitUntilVisible(name);
        this.name.sendKeys(nameinfo);
    }

    public void submitButton() {
        waitUntilPageReady();
        waitUntilVisible(submit);
        this.submit.click();

    }
}
