package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;


public class Member_Login_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url")+"/user/login";


    @FindBy(css = ".mod-input-loginName input") private WebElement email;
    @FindBy(css = "[type='password']") private WebElement password;
    @FindBy(css = ".mod-login-btn button") private WebElement submit;

    public void loginEmail(String email){
        waitUntilPageReady();
        this.email.sendKeys(email);
        waitUntilPageReady();
    }

    public void loginPass(String password){
        waitUntilPageReady();
        this.password.sendKeys(password);
        waitUntilPageReady();
    }

    public void submitButton(){
        waitUntilPageReady();
        submit.click();
        waitUntilPageReady();
    }


}
