package asc.desktop.pages;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Seller_Login_Page extends PageObject {

    public static final String page_url = Global.config.getString("asc.home_url");

    @FindBy(css = ".input-account input") private WebElement email_input;
    @FindBy(css = ".input-password input") private WebElement pass_input;
    @FindBy(css = ".button-submit button") private  WebElement submit_button;

    private void waitUntilLoaded(){
        waitUntilPageReady();
        waitUntilVisible(email_input);
    }

    public void login(String userEmail, String passWord){
        waitUntilLoaded();
        email_input.sendKeys(userEmail);
        pass_input.sendKeys(passWord);
        waitUntilPageReady();
        submit_button.click();
    }
}
