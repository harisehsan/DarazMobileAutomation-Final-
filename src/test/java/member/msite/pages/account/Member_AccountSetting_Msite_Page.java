package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_AccountSetting_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/setting";

    @FindBy(className = "logout") private WebElement logout;
    @FindBy(className = "ok") private WebElement okbutton;
    @FindBy(className = "cancel") private WebElement cancelbutton;
    @FindBy(css = "#container > div > ul > li:nth-child(1) > a") private WebElement changePassWord;
    @FindBy(css = "#page-title") private WebElement hasSettingTitle;

    public void logOut(){
        waitUntilPageReady();
        waitUntilClickable(By.className("logout"));
        this.logout.click();
    }

    public void setOkButton(){
        waitUntilPageReady();
        waitUntilClickable(By.className("ok"));
        this.okbutton.click();
    }

    public boolean hasSettingPage(){
        waitUntilPageReady();
        waitUntilVisible(hasSettingTitle);
        return hasSettingTitle.isDisplayed();
    }

    public void changePassWord() {
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("#container > div > ul > li:nth-child(1) > a"));
        this.changePassWord.click();
    }
}