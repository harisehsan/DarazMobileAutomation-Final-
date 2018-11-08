package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Account_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/account";

    @FindBy(css = "#container > div > div.mod-minlogin.member") private WebElement accounttittle;
    @FindBy(css ="#container > div > div.account-newsletter > div") private WebElement newsletterConfig;
    @FindBy(css="#address-book > a") private WebElement addressBook;


    public void setAccountTittle() {
        waitUntilVisible(accounttittle);
    }

    public void setNewsletterTrigger() {
        waitUntilPageReady();
        waitUntilVisible(newsletterConfig);
        this.newsletterConfig.click();
    }

    public String getCurrentNewsletter() {
        return newsletterConfig.getAttribute("class");
    }

    public void clickAddress(){
        waitUntilPageReady();
        waitUntilVisible(addressBook);
        this.addressBook.click();

    }

}
