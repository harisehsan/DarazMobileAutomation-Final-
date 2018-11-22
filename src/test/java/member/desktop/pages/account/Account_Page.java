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

    @FindBy(css = "#container") private WebElement mainContainer;
    @FindBy(id = "lzd_current_logon_user_name") private WebElement nameOfUser;
    @FindBy(id = "myAccountTrigger") private WebElement myAccoutTrigger;
    @FindBy(css = ".account-icon.logout") private WebElement logOut;
    @FindBy(id = "lzd_current_logon_user_isVerified") private WebElement isVerified;
    @FindBy(css = "#container > div > div.dashboard-profile > div.dashboard-info > div.dashboard-info-item.last > a") private WebElement newsLetter;
    @FindBy(css = ".next-btn-primary") private WebElement okBtn;
    @FindBy(css= "#container > div > div.dashboard-profile > div.dashboard-info > div:nth-child(2)") private WebElement emailInformation;

    public void untilLoaded(){
        waitUntilVisible(mainContainer);
    }

    public String hasName() {
        waitUntilPageReady();
        waitUntilVisible(nameOfUser);
        return nameOfUser.getText();
    }

    public String hasEmail() {
        waitUntilPageReady();
        waitUntilVisible(emailInformation);
        return emailInformation.getText();
    }

    public boolean isVerified(){
        waitUntilVisible(isVerified);
        return this.isVerified.isDisplayed();
    }

    public void setNewsLetter(){
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("#container > div > div.dashboard-profile > div.dashboard-info > div.dashboard-info-item.last > a"));
        this.newsLetter.click();
        waitUntilClickable(By.cssSelector(".next-btn-primary"));
        this.okBtn.click();
        waitUntilInvisibilityOf(By.cssSelector(".next-btn-primary"));
    }

    public String hasNewsLetter(){
        waitUntilPageReady();
        waitUntilVisible(newsLetter);
        return newsLetter.getText();
    }

    public void waitUntilResetSmsInvisible(){
        waitUntilPageReady();
        waitUntilInvisibilityOf(By.cssSelector("body > div:nth-child(10) > div > div > div.next-feedback-content"));
    }

    public void logOut() {
        waitUntilPageReady();
        waitUntilVisible(myAccoutTrigger);
        waitUntilClickable(By.id("myAccountTrigger"));
        this.myAccoutTrigger.click();
        this.logOut.click();
    }
}