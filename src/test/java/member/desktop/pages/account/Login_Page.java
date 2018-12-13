package member.desktop.pages.account;

import com.google.gson.JsonObject;
import global.Global;
import helper.XhrHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

/**
 * Created by admin.son.ton on 1/25/18.
 */

public class Login_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") +"/user/login";
    private static String loginApiUrl = Global.config.getString("member.url")+"/user/api/login";

    @FindBy(css = ".mod-input-loginName input") private WebElement email_txtField;
    @FindBy(css = "[type='password']") private WebElement password_txtField;
    @FindBy(css = ".mod-login-btn button") private WebElement submit_btn;

    public void logIn(String email, String password) {
        waitUntilPageReady();
        this.email_txtField.sendKeys(email);
        this.password_txtField.sendKeys(password);
        submit_btn.click();
        waitUntilPageReady();
    }

    /**
     *
     * @param userId could be email or phone number
     * @param password
     */
    public void loginApi(String userId, String password){
        String csrfToken = Global.browser.getCookiesAsMap().get("_tb_token_");
        String [] args = {loginApiUrl,userId,password,csrfToken};
        JsonObject response = XhrHelper.executeXhrRequest("member_login.js",args);
        if(!String.valueOf(response.get("success")).equalsIgnoreCase("true")){
            throw new RuntimeException(String.format("Login with credential %s/%s fail . Response from server: %s",userId,password,String.valueOf(response)));
        }
    }
}