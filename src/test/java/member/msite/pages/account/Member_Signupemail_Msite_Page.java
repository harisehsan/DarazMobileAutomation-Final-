package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Signupemail_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/register";

    @FindBy(css = "#container > div > div > div > div > div.signup-by-mobile-foot > div > button")
    private WebElement signUpEmail;
    @FindBy(css = ".mod-input-name input")
    private WebElement inputName;
    @FindBy(css = ".mod-input-email input")
    private WebElement inputEmail;
    @FindBy(css = ".mod-input-password input")
    private WebElement inputPassWord;
    @FindBy(className = "signup-by-email-btn")
    private WebElement signupBtn;

    public void signUpEmail() {
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("#container > div > div > div > div > div.signup-by-mobile-foot > div > button"));
        this.signUpEmail.click();
    }

    public void inputName(String name) {
        waitUntilPageReady();
        this.inputName.sendKeys(name);
    }

    public void inputEmail(String email) {
        waitUntilPageReady();
        this.inputEmail.sendKeys(email);
    }

    public void inputPassword(String pass) {
        waitUntilPageReady();
        this.inputPassWord.sendKeys(pass);
    }

    public void signUpButton() {
        waitUntilPageReady();
        this.signupBtn.click();
    }

    public void signUpByEmail(String name, String email, String pass) {
        waitUntilPageReady();
        waitUntilVisible(inputEmail);
        this.inputName.sendKeys(name);
        this.inputEmail.sendKeys(email);
        this.inputPassWord.sendKeys(pass);
    }
}