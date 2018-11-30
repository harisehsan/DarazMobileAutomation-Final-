package member.msite.pages.account;

import allure.AllureAttachment;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Account_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/account";

    @FindBy(css = "div.mod-minlogin.member > div")
    private WebElement accountTittle_lbl;
    @FindBy(css = "div.account-newsletter > div")
    private WebElement newsletterConfig_btn;
    @FindBy(css = "#address-book > a")
    private WebElement addressBook_btn;

    public boolean hasAccountTittle() {
        waitUntilPageReady();
        waitUntilVisible(accountTittle_lbl);
        return accountTittle_lbl.isDisplayed();
    }

    public void setNewsletterTrigger() {
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("div.account-newsletter > div"));
        this.newsletterConfig_btn.click();
    }

    public String getCurrentNewsletter() {
        return newsletterConfig_btn.getAttribute("class");
    }

    public void clickAddress(){
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("#address-book > a\""));
        this.addressBook_btn.click();
    }

    public void allureMailUrlPass(String email, String pass) {
        AllureAttachment.attachURL(page_url);
        AllureAttachment.attachComment("Email", email);
        AllureAttachment.attachComment("Password", pass);
    }

    public void allureMobilePhone(String mobile) {
        AllureAttachment.attachComment("Mobile phone", mobile);
    }
}