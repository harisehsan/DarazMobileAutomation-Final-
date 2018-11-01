package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Login_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url")+"/user/login";


    @FindBy(css = ".mod-input-loginName input") private WebElement email;
    @FindBy(css = "[type='password']") private WebElement password;
    @FindBy(css = ".mod-login-btn button") private WebElement submit;
    @FindBy(className = "mod-login-btn") private WebElement login;


    public void loginEmail(String emailInfo){
        waitUntilPageReady();
        waitUntilVisible(email);
        this.email.sendKeys(emailInfo);

    }

    public void loginPass(String pass){
        waitUntilPageReady();
        waitUntilVisible(password);
        this.password.sendKeys(pass);
    }

    public void submitButton(){
        waitUntilVisible(submit);
        waitUntilPageReady();
        submit.click();
    }


    public void hasID(){
        waitUntilVisible(login);
    }

    public void loginNewPass(String emailinfo, String newpass){
        waitUntilPageReady();
        waitUntilVisible(email);
        this.email.sendKeys(emailinfo);
        this.password.sendKeys(newpass);
        this.submit.click();

    }


}
