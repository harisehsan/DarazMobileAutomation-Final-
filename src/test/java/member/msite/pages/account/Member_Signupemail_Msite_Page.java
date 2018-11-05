package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Signupemail_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/register";

    @FindBy(css = ".signup-by-mobile-foot-btn") private WebElement signupemail;
    @FindBy(css = ".mod-input-name input") private WebElement inputname;
    @FindBy(css = ".mod-input-email input") private WebElement inputemail;
    @FindBy(css = ".mod-input-password input") private WebElement inputpassword;
    @FindBy(className = "signup-by-email-btn") private WebElement signupbutton;


    public void signUpEmail(){
        waitUntilPageReady();
        this.signupemail.click();
    }

    public void inputName(String name){
        waitUntilPageReady();
        this.inputname.sendKeys(name);
    }

    public void inputEmail(String email) {
        waitUntilPageReady();
        this.inputemail.sendKeys(email);
    }

    public void inputPassword(String pass){
        waitUntilPageReady();
        this.inputpassword.sendKeys(pass);
    }

    public void signUpButton() {
        waitUntilPageReady();
        this.signupbutton.click();
    }

}