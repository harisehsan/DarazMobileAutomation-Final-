package member.msite.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_Complete_Your_Profile_Page extends PageObject {

    public static String page_url = Global.getConfig().getString("member.msite_url") + "/user/complete-profile";

    @FindBy(css = ".mod-input-name input") private WebElement name_txtField;
    @FindBy(css = ".mod-input-email input") private WebElement email_txtField;
    @FindBy(css = ".mod-input-password input") private WebElement password_txtField;
    @FindBy(className = "complete-profile-btn") private WebElement complete_btn;

    private By complete_btn_by = By.className("complete-profile-btn");

    public void inputName(String name){
        waitUntilPageReady();
        waitUntilVisible(name_txtField);
        this.name_txtField.sendKeys(name);
    }

    public void inputEmail(String email) {
        waitUntilPageReady();
        waitUntilVisible(email_txtField);
        this.email_txtField.sendKeys(email);
    }

    public void inputPassword(String pass){
        waitUntilPageReady();
        waitUntilVisible(password_txtField);
        this.password_txtField.sendKeys(pass);
    }

    public void completeButton() {
        waitUntilPageReady();
        waitUntilClickable(complete_btn_by);
        this.complete_btn.click();
    }
}