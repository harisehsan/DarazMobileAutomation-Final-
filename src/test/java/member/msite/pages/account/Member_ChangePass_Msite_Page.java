package member.msite.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_ChangePass_Msite_Page extends PageObject {
    public static String page_url = Global.config.getString("member.url1") + "/user/change-password";

    @FindBy(css = ".mod-input-password input") private WebElement oldPass;
    @FindBy(css = ".mod-input-newPassword input") private WebElement newPass;
    @FindBy(css = ".mod-input-re-newPassword input") private WebElement reNewPass;
    @FindBy(css = ".mod-button") private  WebElement saveBtn;
    //    @FindBy(css = "body > div.ReactModalPortal > div > div > div.mod-dialog-ft > button") private WebElement gotItBtn;
    @FindBy(css = "div.mod-dialog-ft > button")
    private WebElement gotItBtn;

    public void setNewPassWord(String oldPassWord, String newPassWord){
        waitUntilPageReady();
        waitUntilVisible(oldPass);
        this.oldPass.sendKeys(oldPassWord);
        this.newPass.sendKeys(newPassWord);
        this.reNewPass.sendKeys(newPassWord);
    }

    public void saveButton(){
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector(".mod-button"));
        this.saveBtn.click();
    }

    public void gotItButton(){
        waitUntilClickable(By.cssSelector("div.mod-dialog-ft > button"));
        this.gotItBtn.click();
    }
}
