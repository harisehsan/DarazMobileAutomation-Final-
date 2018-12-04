package member.msite.pages.account;

import allure.AllureAttachment;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_AccountSetting_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.msite_url") + "/user/setting";

    @FindBy(className = "logout") private WebElement logout_btn;
    @FindBy(className = "ok") private WebElement ok_btn;
    @FindBy(className = "cancel") private WebElement cancel_btn;
    @FindBy(css = "li:nth-child(1) > a") private WebElement changePassWord_btn;
    @FindBy(css = "#page-title") private WebElement hasSettingTitle_lbl;

    private By logout_btn_by = By.className("logout");
    private By ok_btn_by = By.className("ok");
    private By changePassWord_btn_by = By.cssSelector("li:nth-child(1) > a");

    public void logOut() {
        waitUntilPageReady();
        waitUntilClickable(logout_btn_by);
        this.logout_btn.click();
    }

    public void setOkButton() {
        waitUntilPageReady();
        waitUntilClickable(ok_btn_by);
        this.ok_btn.click();
    }

    public boolean hasSettingPage() {
        waitUntilPageReady();
        waitUntilVisible(hasSettingTitle_lbl);
        return hasSettingTitle_lbl.isDisplayed();
    }

    public void changePassWord() {
        waitUntilPageReady();
        waitUntilClickable(changePassWord_btn_by);
        this.changePassWord_btn.click();
    }

    public void allureUrlSettingPage() {
        AllureAttachment.attachURL(page_url);
    }
}