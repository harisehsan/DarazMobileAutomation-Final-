package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Login_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url")+"/user/login";

    @FindBy(css = ".mod-input-loginName input") private WebElement email_txtField;
    @FindBy(css = "[type='password']") private WebElement passWord_txtField;
    @FindBy(css = ".mod-login-btn") private WebElement submit_btn;
    @FindBy(className = "mod-login-btn") private WebElement login_btn;
    @FindBy(className = "mod-login-forgot") private WebElement resetPass_btn;

    private By submit_btn_by = By.cssSelector(".mod-login-btn");

    public void submitButton() {
        waitUntilVisible(submit_btn);
        waitUntilPageReady();
        submit_btn.click();
    }

    public boolean hasID() {
        waitUntilVisible(login_btn);
        return this.login_btn.isEnabled();
    }

    public void clickResetPassBtn() {
        waitUntilPageReady();
        this.resetPass_btn.click();
    }

    public void loginEmailPass(String emailInfo, String newPass) {
        waitUntilPageReady();
        waitUntilVisible(email_txtField);
        this.email_txtField.sendKeys(emailInfo);
        this.passWord_txtField.sendKeys(newPass);
        waitUntilClickable(submit_btn_by);
        this.submit_btn.click();
        waitUntilInvisibilityOf(submit_btn_by);
    }
}