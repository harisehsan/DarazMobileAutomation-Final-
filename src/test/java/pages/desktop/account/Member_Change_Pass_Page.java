package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class Member_Change_Pass_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/change-password";

    @FindBy(css = ".mod-input-password input") private WebElement currentpass;
    @FindBy(css = ".mod-input-newPassword input") private WebElement newpass;
    @FindBy(css = ".mod-input-re-newPassword input") private WebElement renewpass;
    @FindBy(css = ".next-btn-large") private WebElement savebtn;
    @FindBy(css = ".next-btn-medium") private WebElement okbtn;

    public void resetPass(String x,String y, String z) {
        waitUntilPageReady();
        waitUntilVisible(currentpass);
        this.currentpass.sendKeys(x);
        this.newpass.sendKeys(y);
        this.renewpass.sendKeys(z);
        this.savebtn.click();
        waitUntilVisible(okbtn);
        this.okbtn.click();
    }

}
