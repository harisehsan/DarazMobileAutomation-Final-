package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

/**
 * Created by admin.son.ton on 1/25/18.
 */
public class Login_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url")+"/user/login";

    @FindBy(css = ".mod-input-loginName input") private WebElement email;
    @FindBy(css = "[type='password']") private WebElement password;
    @FindBy(css = ".mod-login-btn button") private WebElement submit;

    public void login(String email, String password){
        waitUntilPageReady();
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        submit.click();
        waitUntilPageReady();
    }


}
