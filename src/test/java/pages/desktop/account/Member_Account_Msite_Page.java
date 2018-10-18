package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class Member_Account_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/account";

    @FindBy(id = "title-wrap") private WebElement accounttittle;

    public void setAccounttittle() throws Throwable{
        waitUntilVisible(accounttittle);
    }
}
