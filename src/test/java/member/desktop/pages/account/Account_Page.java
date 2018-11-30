package member.desktop.pages.account;

import allure.AllureAttachment;
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

    @FindBy(css = "div.breadcrumb > a")
    private WebElement mainContainer_lbl;
    @FindBy(id = "lzd_current_logon_user_name")
    private WebElement nameOfUser_lbl;
    @FindBy(id = "myAccountTrigger")
    private WebElement myAccoutTrigger_btn;
    @FindBy(css = ".account-icon.logout")
    private WebElement logOut_btn;
    @FindBy(id = "lzd_current_logon_user_isVerified")
    private WebElement isVerified_lbl;
    @FindBy(css = "div.dashboard-info-item.last > a")
    private WebElement newsLetter_btn;
    @FindBy(css = ".next-btn-primary")
    private WebElement okNewsletterConfig_btn;
    @FindBy(css = "div.dashboard-info > div:nth-child(2)")
    private WebElement emailInformation_lbl;

    public void untilLoaded(){
        waitUntilVisible(mainContainer_lbl);
    }

    public String hasName() {
        waitUntilPageReady();
        waitUntilVisible(nameOfUser_lbl);
        return nameOfUser_lbl.getText();
    }

    public String hasEmail() {
        waitUntilPageReady();
        waitUntilVisible(emailInformation_lbl);
        return emailInformation_lbl.getText();
    }

    public boolean isVerified(){
        waitUntilVisible(isVerified_lbl);
        return this.isVerified_lbl.isDisplayed();
    }

    public void setNewsLetter(){
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("div.dashboard-info-item.last > a"));
        this.newsLetter_btn.click();
        waitUntilClickable(By.cssSelector(".next-btn-primary"));
        this.okNewsletterConfig_btn.click();
        waitUntilInvisibilityOf(By.cssSelector(".next-btn-primary"));
    }

    public String hasNewsLetter(){
        waitUntilPageReady();
        waitUntilVisible(newsLetter_btn);
        return newsLetter_btn.getText();
    }

    public void logOut() {
        waitUntilPageReady();
        waitUntilClickable(By.id("myAccountTrigger"));
        this.myAccoutTrigger_btn.click();
        waitUntilClickable(By.cssSelector(".account-icon.logout"));
        this.logOut_btn.click();
    }

    public void allureMailUrlPass(String pass) {
        AllureAttachment.attachURL(page_url);
        AllureAttachment.attachComment("Email", emailInformation_lbl.getText());
        AllureAttachment.attachComment("Password", pass);
    }

    public void allureMobilePhone(String mobile) {
        AllureAttachment.attachComment("Mobile phone", mobile);
    }
}