package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_Complete_Your_Profile_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/complete-profile";

    @FindBy(css = ".mod-input-name input") private WebElement inputname;
    @FindBy(css = ".mod-input-email input") private WebElement inputemail;
    @FindBy(css = ".mod-input-password input") private WebElement inputpassword;
    @FindBy(className = "complete-profile-btn") private WebElement completebutton;



    public void setInputname(String n){
        waitUntilPageReady();
        waitUntilVisible(inputname);
        this.inputname.sendKeys(n);
    }

    public void setInputemail(String e) {
        waitUntilPageReady();
        waitUntilVisible(inputemail);
        this.inputemail.sendKeys(e);
    }

    public void setInputpassword(String p){
        waitUntilPageReady();
        waitUntilVisible(inputpassword);
        this.inputpassword.sendKeys(p);
    }

    public void setCompletebutton() {
        waitUntilPageReady();
        waitUntilVisible(completebutton);
        this.completebutton.click();
    }

}
