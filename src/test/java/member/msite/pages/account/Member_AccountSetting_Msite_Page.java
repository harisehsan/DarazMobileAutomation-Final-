package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_AccountSetting_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/setting";

    @FindBy(className = "logout") private WebElement logout;
    @FindBy(className = "ok") private WebElement okbutton;
    @FindBy(className = "cancel") private WebElement cancelbutton;
    @FindBy(css = "#container > div > ul > li:nth-child(1) > a") private WebElement changePassWord;


    public void logOut(){
        waitUntilPageReady();
        this.logout.click();
    }

    public void setOkButton(){
        waitUntilPageReady();
        this.okbutton.click();
    }

    public void changePassWord() {
        waitUntilPageReady();
        waitUntilVisible(changePassWord);
        this.changePassWord.click();
    }
}

