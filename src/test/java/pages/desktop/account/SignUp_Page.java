package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.*;
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
    @FindBy(css = ".btn_slide") private WebElement sliderbtn;


    public void signEmail() {
        waitUntilPageReady();
        waitUntilVisible(emailbutton);
        emailbutton.click();
    }

    public void emailTextField(String emailInfo) {
        waitUntilPageReady();
        waitUntilVisible(email);
        this.email.sendKeys(emailInfo);
    }

    public void passWordField(String pass) {
        waitUntilPageReady();
        waitUntilVisible(password);
        this.password.sendKeys(pass);
    }


    public void nameField(String nameInfo) {
        waitUntilPageReady();
        waitUntilVisible(name);
        this.name.sendKeys(nameInfo);
    }

    public void submitButton() {
        waitUntilPageReady();
        waitUntilVisible(submit);
        this.submit.click();

    }

    public void setSliderbtn(){
        Actions move = new Actions(Global.browser.getWebDriver());
        Action actions = move.clickAndHold(sliderbtn).moveByOffset(300,0).release().build();
        actions.perform();
    }
}
