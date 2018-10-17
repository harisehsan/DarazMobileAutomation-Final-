package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;


/**
 * Created by admin.son.ton on 1/25/18.
 */
public class Account_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/profile";

    @FindBy(css = "#container") private WebElement mainContainer_element;
    @FindBy(id = "Manage-My-Account") private WebElement name_of_user;


    public void untilLoaded(){
        waitUntilVisible(mainContainer_element);
    }
    public boolean hasName(String name) {
        waitUntilPageReady();
        return this.name_of_user.getText().equals(name);
    }
}
