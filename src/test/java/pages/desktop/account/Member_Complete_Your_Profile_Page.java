package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class Member_Complete_Your_Profile_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url1") + "/user/complete-profile";

    @FindBy(css = ".mod-input-name input") private WebElement inputname;
    @FindBy(css = ".mod-input-email input") private WebElement inputemail;
    @FindBy(css = ".mod-input-password input") private WebElement inputpassword;
    @FindBy(className = "complete-profile-btn") private WebElement completebutton;



    public void setInputName(String name){
        waitUntilPageReady();
        waitUntilVisible(inputname);
        this.inputname.sendKeys(name);
    }

    public void setInputEmail(String email) {
        waitUntilPageReady();
        waitUntilVisible(inputemail);
        this.inputemail.sendKeys(email);
    }

    public void setInputPassword(String pass){
        waitUntilPageReady();
        waitUntilVisible(inputpassword);
        this.inputpassword.sendKeys(pass);
    }

    public void setCompleteButton() {
        waitUntilPageReady();
        waitUntilVisible(completebutton);
        this.completebutton.click();
    }

}
