package pages;

import browser.Browser;
import global.Global;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by admin.son.ton on 1/23/18.
 */
public abstract class Base_Page {

    protected Browser browser;

    protected Base_Page(){
        browser = Global.browser;
        PageFactory.initElements(browser.getWebDriver(), this);
    }
}
