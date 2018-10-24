package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

import javax.xml.bind.Element;
import java.util.List;



/**
 * Created by admin.son.ton on 1/25/18.
 */
public class Account_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/profile";

    @FindBy(css = "#container") private WebElement mainContainer_element;
    @FindBy(id = "lzd_current_logon_user_name") private WebElement name_of_user;
    @FindBy(id = "myAccountTrigger") private WebElement myAccount_trigger;
    @FindBy(css = ".account-icon.logout") private WebElement logout;
    @FindBy(className = "dashboard-address-item shipping") private WebElement shippingdefault;

    public void untilLoaded(){
        waitUntilVisible(mainContainer_element);
    }
    public boolean hasName(String name) {
        waitUntilPageReady();
        return this.name_of_user.getText().equals(name);
    }

    public void setMyAccount_trigger() {
        waitUntilPageReady();
        this.myAccount_trigger.click();
    }

    public void setLogout() {
        waitUntilPageReady();
        this.logout.click();
    }

    public boolean hasAddressName(String addressname){
        waitUntilPageReady();
        return this.shippingdefault.getText().equals(addressname);
    }


}
