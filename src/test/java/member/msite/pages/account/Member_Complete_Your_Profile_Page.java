package member.msite.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_Complete_Your_Profile_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/complete-profile";

    @FindBy(css = ".mod-input-name input") private WebElement inputName;
    @FindBy(css = ".mod-input-email input") private WebElement inputEmail;
    @FindBy(css = ".mod-input-password input") private WebElement inputPassWord;
    @FindBy(className = "complete-profile-btn") private WebElement completeBtn;

    public void inputName(String name){
        waitUntilPageReady();
        waitUntilVisible(inputName);
        this.inputName.sendKeys(name);
    }

    public void inputEmail(String email) {
        waitUntilPageReady();
        waitUntilVisible(inputEmail);
        this.inputEmail.sendKeys(email);
    }

    public void inputPassword(String pass){
        waitUntilPageReady();
        waitUntilVisible(inputPassWord);
        this.inputPassWord.sendKeys(pass);
    }

    public void completeButton() {
        waitUntilPageReady();
        waitUntilClickable(By.className("complete-profile-btn"));
        this.completeBtn.click();
    }
}