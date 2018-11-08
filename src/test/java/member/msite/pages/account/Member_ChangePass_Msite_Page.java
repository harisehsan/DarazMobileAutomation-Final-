package member.msite.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_ChangePass_Msite_Page extends PageObject {
    public static String page_url = Global.config.getString("member.url1") + "/user/change-password";

    @FindBy(css = ".mod-input-password input") private WebElement oldPass;
    @FindBy(css = ".mod-input-newPassword input") private WebElement newPass;
    @FindBy(css = ".mod-input-re-newPassword input") private WebElement reNewPass;
    @FindBy(css = ".mod-button") private  WebElement saveBtn;
    @FindBy(css = "body > div.ReactModalPortal > div > div > div.mod-dialog-ft > button") private WebElement gotItBtn;

    public void setNewPassWord(String oldPassWord, String newPassWord, String reNewPassWord){
        waitUntilPageReady();
        waitUntilVisible(oldPass);
        this.oldPass.sendKeys(oldPassWord);
        this.newPass.sendKeys(newPassWord);
        this.reNewPass.sendKeys(reNewPassWord);
    }

    public void saveButton(){
        waitUntilPageReady();
        waitUntilVisible(saveBtn);
        this.saveBtn.click();
    }

    public void gotItButton(){
        waitUntilVisible(gotItBtn);
        this.gotItBtn.click();
    }
}
