package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

/**
 * Created by admin.son.ton on 1/26/18.
 */

public class SignUp_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/register";

    @FindBy(className = "mod-change-register-btn") private WebElement emailBtn;
    @FindBy(css = ".mod-input-email input") private WebElement email;
    @FindBy(css = ".mod-input-password input") private WebElement passWord;
    @FindBy(css = ".mod-input-name input") private WebElement name;
    @FindBy(className = "mod-login-btn") private WebElement submit;
    @FindBy(css = ".btn_slide") private WebElement sliderBtn;

    public void signEmail() {
        waitUntilPageReady();
        waitUntilVisible(emailBtn);
        emailBtn.click();
    }

    public void signUpByEmail(String emailInfo, String passWord, String nameInfo) {
        waitUntilPageReady();
        waitUntilVisible(email);
        this.email.sendKeys(emailInfo);
        this.passWord.sendKeys(passWord);
        this.name.sendKeys(nameInfo);
    }

    public void submitButton() {
        waitUntilPageReady();
        waitUntilVisible(submit);
        this.submit.click();
    }

    public void setSliderbtn(){
        Actions move = new Actions(Global.browser.getWebDriver());
        Action actions = move.clickAndHold(sliderBtn).moveByOffset(300,0).release().build();
        actions.perform();
    }
}