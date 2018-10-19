package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class Member_AccountSetting_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/setting";

    @FindBy(className = "logout") private WebElement logout;
    @FindBy(className = "ok") private WebElement okbutton;
    @FindBy(className = "cancel") private WebElement cancelbutton;

    public void setLogout(){
        waitUntilPageReady();
        this.logout.click();
    }

    public void setOkbutton(){
        waitUntilPageReady();
        this.okbutton.click();
    }
}

