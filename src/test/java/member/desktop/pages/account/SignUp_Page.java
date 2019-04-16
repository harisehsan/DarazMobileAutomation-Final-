package member.desktop.pages.account;

import _base.page_helpers.BuyerSitePageHelper;
import com.google.gson.JsonObject;
import global.Global;
import helper.XhrHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

/**
 * Created by admin.son.ton on 1/26/18.
 */

public class SignUp_Page extends PageObject {

    public static String page_url = Global.getConfig().getString("member.url") + "/user/register";
    private static String signUpApiUrl = Global.getConfig().getString("member.url")+"/user/api/register";

    @FindBy(className = "mod-change-register-btn") private WebElement email_btn;
    @FindBy(css = ".mod-input-email input") private WebElement email_txtField;
    @FindBy(css = ".mod-input-password input") private WebElement passWord_txtField;
    @FindBy(css = ".mod-input-name input") private WebElement name_txtField;
    @FindBy(className = "mod-login-btn") private WebElement submit_btn;
    @FindBy(css = ".btn_slide") private WebElement slider_btn;

    public void signEmail() {
        waitUntilPageReady();
        waitUntilVisible(email_btn);
        email_btn.click();
    }

    public void switchToEnglish() {
        BuyerSitePageHelper.switchToEnglish();
    }

    public void signUpByEmail(String emailInfo, String passWord, String nameInfo) {
        waitUntilPageReady();
        waitUntilVisible(email_txtField);
        this.email_txtField.sendKeys(emailInfo);
        this.passWord_txtField.sendKeys(passWord);
        this.name_txtField.sendKeys(nameInfo);
    }

    public void submitButton() {
        waitUntilPageReady();
        waitUntilVisible(submit_btn);
        this.submit_btn.click();
    }

    public void setSliderbtn() {
        Actions move = new Actions(Global.getBrowser().getWebDriver());
        Action actions = move.clickAndHold(slider_btn).moveByOffset(300, 0).release().build();
        actions.perform();
    }

    /**
     *
     * @param userId could be email or phone number
     * @param password
     */
    public void signUpApi(String userId, String password){
        String csrfToken = Global.getBrowser().getCookiesAsMap().get("_tb_token_");
        String name = Global.getConfig().getString("member.account.name");
        String [] args = {signUpApiUrl,userId,password,name,csrfToken};
        JsonObject response = XhrHelper.executeXhrRequest("member_signup.js",args);
        if(!String.valueOf(response.get("success")).equalsIgnoreCase("true")){
            throw new RuntimeException(String.format("Login with credential %s/%s fail . Response from server: %s",userId,password,String.valueOf(response)));
        }
    }
}