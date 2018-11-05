package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;


/**
 * Created by admin.son.ton on 1/25/18.
 */
public class Account_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/profile";

    @FindBy(css = "#container") private WebElement mainContainer_element;
    @FindBy(id = "lzd_current_logon_user_name") private WebElement name_of_user;
    @FindBy(id = "myAccountTrigger") private WebElement myAccount_trigger;
    @FindBy(css = ".account-icon.logout") private WebElement logout;
    @FindBy(id = "lzd_current_logon_user_isVerified") private WebElement isVerified;
    @FindBy(id = "My-profile") private WebElement myaccountprofile;
    @FindBy(css = "#container > div > div.dashboard-profile > div.dashboard-info > div.dashboard-info-item.last > a") private WebElement newsLetter;
    @FindBy(css = ".next-btn-primary") private WebElement okBtn;



    public void untilLoaded(){
        waitUntilVisible(mainContainer_element);
    }
    public boolean hasName(String name) {
        waitUntilPageReady();
        waitUntilVisible(name_of_user);
        Global.browser.getWebDriver().findElement(By.id("1234"));
        return this.name_of_user.getText().equals(name);
    }

    public boolean isVerified(){
        waitUntilVisible(isVerified);
        return this.isVerified.isDisplayed();
    }

    public void setMyAccount_trigger() {
        waitUntilPageReady();
        waitUntilVisible(myAccount_trigger);
        this.myAccount_trigger.click();
    }

    public void setMyAccountProfile() {
        waitUntilPageReady();
        waitUntilVisible(myaccountprofile);
        this.myaccountprofile.click();
    }

    public void setNewsLetter(){
        waitUntilPageReady();
        waitUntilVisible(newsLetter);
        this.newsLetter.click();
        waitUntilClickable(By.cssSelector(".next-btn-primary"));
        this.okBtn.click();
    }

    public boolean hasNewsLetter(){
        waitUntilPageReady();
        return this.newsLetter.isDisplayed();
    }

    public void logOut() {
        waitUntilPageReady();
        waitUntilVisible(logout);
        this.logout.click();
    }



}
