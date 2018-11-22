package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Account_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/account";

    @FindBy(css = "#container > div > div.mod-minlogin.member > div") private WebElement accountTittle;
    @FindBy(css ="#container > div > div.account-newsletter > div") private WebElement newsletterConfig;
    @FindBy(css="#address-book > a") private WebElement addressBook;

    public void getAccountTittle() {
        waitUntilPageReady();
        waitUntilVisible(accountTittle);
        this.accountTittle.isDisplayed();
    }

    public boolean hasAccountTittle() {
        waitUntilPageReady();
        waitUntilVisible(accountTittle);
        return  accountTittle.isDisplayed();
    }

    public void setNewsletterTrigger() {
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("#container > div > div.account-newsletter > div"));
        this.newsletterConfig.click();
    }

    public String getCurrentNewsletter() {
        return newsletterConfig.getAttribute("class");
    }

    public void clickAddress(){
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("#address-book > a\""));
        this.addressBook.click();
    }
}