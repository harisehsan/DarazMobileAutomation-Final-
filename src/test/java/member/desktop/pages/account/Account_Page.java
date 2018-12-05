package member.desktop.pages.account;

import allure.AllureAttachment;
import global.Global;
import io.qameta.allure.AllureResultsWriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

import java.util.Base64;

/**
 * Created by admin.son.ton on 1/25/18.
 */

public class Account_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/profile";

    @FindBy(css = "div.breadcrumb > a") private WebElement mainContainer_lbl;
    @FindBy(id = "lzd_current_logon_user_name") private WebElement nameOfUser_lbl;
    @FindBy(id = "myAccountTrigger") private WebElement myAccoutTrigger_btn;
    @FindBy(css = ".account-icon.logout") private WebElement logOut_btn;
    @FindBy(id = "lzd_current_logon_user_isVerified") private WebElement isVerified_lbl;
    @FindBy(css = "div.dashboard-info-item.last > a") private WebElement newsLetter_btn;
    @FindBy(css = ".next-btn-primary") private WebElement okNewsletterConfig_btn;
    @FindBy(css = "div.dashboard-info > div:nth-child(2)") private WebElement emailInformation_lbl;

    private By isVerified_lbl_by = By.cssSelector("div.dashboard-info-item.last > a");
    private By okNewsletterConfig_btn_by = By.cssSelector(".next-btn-primary");
    private By myAccoutTrigger_btn_by = By.id("myAccountTrigger");
    private By logOut_btn_by = By.cssSelector(".account-icon.logout");

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

    public boolean isVerified() {
        waitUntilVisible(isVerified_lbl);
        return this.isVerified_lbl.isDisplayed();
    }

    public boolean isEmail() {
        waitUntilPageReady();
        waitUntilVisible(emailInformation_lbl);
        return emailInformation_lbl.isDisplayed();
    }

    public void setNewsLetter() {
        waitUntilPageReady();
        waitUntilClickable(isVerified_lbl_by);
        this.newsLetter_btn.click();
        waitUntilClickable(okNewsletterConfig_btn_by);
        this.okNewsletterConfig_btn.click();
        waitUntilInvisibilityOf(okNewsletterConfig_btn_by);
    }

    public String hasNewsLetter() {
        waitUntilPageReady();
        waitUntilVisible(newsLetter_btn);
        return newsLetter_btn.getText();
    }

    public void logOut() {
        waitUntilPageReady();
        waitUntilClickable(myAccoutTrigger_btn_by);
        this.myAccoutTrigger_btn.click();
        waitUntilClickable(logOut_btn_by);
        this.logOut_btn.click();
    }

    public void allureMailUrlPass(String pass) {
        AllureAttachment.attachURL(page_url);
        AllureAttachment.attachComment("Email", emailInformation_lbl.getText());
        AllureAttachment.attachComment("Password", Base64.getEncoder().encodeToString(pass.getBytes()));
    }

    public void allureUrl() {
        AllureAttachment.attachURL(page_url);
    }

    public void allureNameAfterChanging(String oldName, String newName) {
        AllureAttachment.attachURL(page_url);
        AllureAttachment.attachComment("Old name", oldName);
        AllureAttachment.attachComment("Current name", newName);
    }

   public void allureMobilePhone(String mobile) {
        AllureAttachment.attachComment("Mobile phone", mobile);
    }

    public void allureConfigNewsletter(String beforeConfigure, String afterConfigure) {
        AllureAttachment.attachComment("Before configure Newsletter", beforeConfigure);
        AllureAttachment.attachComment("After configure Newsletter", afterConfigure);
    }
}