package pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

/**
 * Created by admin.son.ton on 1/26/18.
 */
public class SignUp_Page extends PageObject {

    private static final String page_url = "https://member.lazada.sg/user/register";

    @FindBy(css = ".mod-input-email input") private WebElement email;
    @FindBy(css = ".mod-input-password input") private WebElement password;
    @FindBy(css = ".mod-input-re-password input") private WebElement reinpassword;
    @FindBy(css = ".mod-input-name input") private WebElement name;
    @FindBy(css = ".mod-login-btn button") private WebElement submmit;

    public SignUp_Page(){
        super();
    }

    public void emailtextfiel(String email){
        this.email.sendKeys(email); }

    public void passwordfield(String password,String repo){
        this.password.sendKeys(password);
        this.reinpassword.sendKeys(repo); }

    public void namefield(String name){
        this.name.sendKeys(name);
        submmit.click();}

}


