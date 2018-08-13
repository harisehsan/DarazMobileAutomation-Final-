package pages.desktop.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

/**
 * Created by admin.son.ton on 1/25/18.
 */
public class Account_Page extends PageObject {

    public static String page_url = "http://member.lazada.sg/user/profile#/";

    @FindBy(css = "#container") private WebElement mainContainer_element;


    public Account_Page(){ super();}

    public void untilLoaded(){
        waitUntilVisible(mainContainer_element);
    }

}
