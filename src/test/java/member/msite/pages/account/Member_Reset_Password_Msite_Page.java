package member.msite.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_Reset_Password_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/forget-password";

    @FindBy(css = "div > input[type='text']")
    private WebElement mail_txtField;
    @FindBy(css = "div.forgot-action > button")
    private WebElement resetPass_btn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/span[2]")
    private WebElement verifyByEmail_btn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div/div/div/span")
    private WebElement sendCode_btn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div/div[1]/div/input")
    private WebElement code_txtField;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div/span")
    private WebElement verifyCode_btn;
    @FindBy(css = "div.mod-input-newPassword > input[type='password']")
    private WebElement newPass_txtField;
    @FindBy(css = "div.mod-input-re-newPassword > input[type='password']")
    private WebElement reNewPass_txtField;
    @FindBy(css = "div > button")
    private WebElement submit_btn;
    @FindBy(css = "div.reset-status > p")
    private WebElement getSuccessMessgage_lbl;
    //    waitUntilInvisibilityOf(By.id("__react_loading_show__"));

    public void resetPasswordStep(String mail) {
        waitUntilPageReady();
        waitUntilVisible(mail_txtField);
        this.mail_txtField.sendKeys(mail);
        waitUntilClickable(By.cssSelector("#container > div > div > div.forgot-action > button"));
        this.resetPass_btn.click();
    }

    public void verifyByMail() {
        waitUntilPageReady();
        waitUntilClickable(By.xpath("/html/body/div[2]/div/div/div[1]/span[2]"));
        this.verifyByEmail_btn.click();
        this.sendCode_btn.click();
    }

    public void inputCode(String smsCode){
        waitUntilVisible(code_txtField);
        this.code_txtField.sendKeys(smsCode);
        waitUntilClickable(By.xpath("/html/body/div[2]/div/div/div[3]/div/span"));
        this.verifyCode_btn.click();
    }

    public void progressNewPass(String newPassWord) {
        waitUntilPageReady();
        waitUntilVisible(newPass_txtField);
        this.newPass_txtField.sendKeys(newPassWord);
        this.reNewPass_txtField.sendKeys(newPassWord);
        waitUntilClickable(By.cssSelector("#container > div > div > div.reset-foot > div > button"));
        this.submit_btn.click();
    }

    public boolean hasSuccessResetMessage(){
        waitUntilPageReady();
        waitUntilVisible(getSuccessMessgage_lbl);
        return getSuccessMessgage_lbl.isDisplayed();
    }

}