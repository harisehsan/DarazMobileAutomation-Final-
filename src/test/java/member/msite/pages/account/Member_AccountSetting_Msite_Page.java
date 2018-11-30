package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_AccountSetting_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/setting";

    @FindBy(className = "logout")
    private WebElement logout_btn;
    @FindBy(className = "ok")
    private WebElement ok_btn;
    @FindBy(className = "cancel")
    private WebElement cancel_btn;
    @FindBy(css = "li:nth-child(1) > a")
    private WebElement changePassWord_btn;
    @FindBy(css = "#page-title")
    private WebElement hasSettingTitle_lbl;

    public void logOut(){
        waitUntilPageReady();
        waitUntilClickable(By.className("logout"));
        this.logout_btn.click();
    }

    public void setOkButton(){
        waitUntilPageReady();
        waitUntilClickable(By.className("ok"));
        this.ok_btn.click();
    }

    public boolean hasSettingPage(){
        waitUntilPageReady();
        waitUntilVisible(hasSettingTitle_lbl);
        return hasSettingTitle_lbl.isDisplayed();
    }

    public void changePassWord() {
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("li:nth-child(1) > a"));
        this.changePassWord_btn.click();
    }
}