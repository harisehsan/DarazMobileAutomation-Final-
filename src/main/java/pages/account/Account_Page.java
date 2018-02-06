package pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.PageObject;

import java.util.List;

/**
 * Created by admin.son.ton on 1/25/18.
 */
public class Account_Page extends PageObject {

    public static String page_url = "http://member.lazada.sg/user/profile#/";

    @FindBy(css = "#container") private WebElement mainContainer_element;
    @FindBy(id = "lzd_current_logon_user_name") private List<WebElement> nameofuser;


    public Account_Page(){ super();}

    public void untilLoaded(){
        waitUntilVisible(mainContainer_element);
    }

    public boolean hasName(){
        nameofuser.isEmpty();
        {return false;}}
}
