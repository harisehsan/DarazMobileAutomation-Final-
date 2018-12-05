package member.msite.pages.account;

import allure.AllureAttachment;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

import java.util.Base64;

public class Member_Account_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.msite_url") + "/user/account";

    @FindBy(css = "div.mod-minlogin.member > div") private WebElement accountTittle_lbl;
    @FindBy(css = "div.account-newsletter > div") private WebElement newsletterConfig_btn;
    @FindBy(css = "#address-book > a") private WebElement addressBook_btn;

    private By newsletterConfig_btn_by = By.cssSelector("div.account-newsletter > div");
    private By addressBook_btn_by = By.cssSelector("#address-book > a");

    public boolean hasAccountTittle() {
        waitUntilPageReady();
        waitUntilVisible(accountTittle_lbl);
        return accountTittle_lbl.isDisplayed();
    }

    public void setNewsletterTrigger() {
        waitUntilPageReady();
        waitUntilClickable(newsletterConfig_btn_by);
        this.newsletterConfig_btn.click();
    }

    public String getCurrentNewsletter() {
        return newsletterConfig_btn.getAttribute("class");
    }

    public void clickAddress() {
        waitUntilPageReady();
        waitUntilClickable(addressBook_btn_by);
        this.addressBook_btn.click();
    }

    public void allureMailUrlPass(String email, String pass) {
        AllureAttachment.attachURL(page_url);
        AllureAttachment.attachComment("Email", email);
        AllureAttachment.attachComment("Password", Base64.getEncoder().encodeToString(pass.getBytes()));
    }

    public void allureMobilePhone(String mobile) {
        AllureAttachment.attachComment("Mobile phone", mobile);
    }

    public void allureCurrentUrl() {
        AllureAttachment.attachURL(page_url);
    }

    public void allureConfigNewsletter(String beforeConfigure, String afterConfigure) {
        AllureAttachment.attachComment("Before configure Newsletter", beforeConfigure);
        AllureAttachment.attachComment("After configure Newsletter", afterConfigure);
    }
}