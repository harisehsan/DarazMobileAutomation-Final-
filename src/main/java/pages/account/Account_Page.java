package pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Base_Page;

import java.util.List;

/**
 * Created by admin.son.ton on 1/25/18.
 */
public class Account_Page extends Base_Page {

    private static final String page_url = "http://member.lazada.sg/user/profile#/";

    public static void visit(){
        Global.browser.goTo(page_url);
    }

    @FindBy(css = "#container") private WebElement mainContainer_element;


    public Account_Page(){
        super();
        PageFactory.initElements(browser.getWebDriver(),this);
    }

    public void untilLoaded(){
        browser.waitUntilVisible(mainContainer_element);
    }

}
