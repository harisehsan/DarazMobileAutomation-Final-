package pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

/**
 * Created by admin.son.ton on 1/25/18.
 */
public class Login_Page extends PageObject {

    public static String page_url = "http://member.lazada.sg/user/login";

    @FindBy(css = ".mod-input-email input") private WebElement email;
    @FindBy(css = "[type='password']") private WebElement password;
    @FindBy(css = ".mod-login-btn button") private WebElement submit;


    public Login_Page(){ super();}

    public void login(String email, String password){
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        submit.click();
    }


}
