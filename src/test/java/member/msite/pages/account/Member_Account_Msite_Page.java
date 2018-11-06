package member.msite.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Account_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/account";

    @FindBy(css = "#container > div > div.account-newsletter > div") private WebElement accounttittle;
    @FindBy(css ="#container > div > div.account-newsletter > div") private WebElement newsletterConfig;

    public void setAccountTittle() {
        waitUntilVisible(accounttittle);
    }

    public void setNewsletterTrigger() {
        waitUntilPageReady();
        waitUntilVisible(newsletterConfig);
        this.newsletterConfig.click();
        Global.map.put("current_newsletter",newsletterConfig.getAttribute("class"));

    }

    public String getCurrentNewsletter() {
        String current_news = (String) Global.map.get("current_newsletter");
        return current_news;
    }


    public boolean hasCurrentNewsletter(String name){
        waitUntilPageReady();
        waitUntilVisible(newsletterConfig);
        return this.newsletterConfig.getAttribute("class").equals(name);
    }


}
