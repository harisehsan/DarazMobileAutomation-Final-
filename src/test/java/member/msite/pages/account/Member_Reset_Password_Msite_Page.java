package member.msite.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_Reset_Password_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/forget-password";
    //
//    @FindBy(css = "#container > div > div > div.forgot-form > div > input[type=\"text\"]") private WebElement inputMail_field;
//    @FindBy(css = "#container > div > div > div.forgot-action > button") private WebElement resetPassBtn;
//    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/span[2]") private WebElement verifyByEmailBtn;
//    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div/div/div/span") private WebElement sendCodeBtn;
//    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div/div[1]/div/input") private WebElement inputCodeField;
//    @FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div/span") private WebElement verifyCodeBtn;
//    @FindBy(css = "#container > div > div > div.reset-form > div.mod-input.mod-input-password.mod-input-newPassword > input[type=\"password\"]") private WebElement inputNewPassField;
//    @FindBy(css = "#container > div > div > div.reset-form > div.mod-input.mod-input-password.mod-input-re-newPassword > input[type=\"password\"]") private WebElement inputReNewPassField;
//    @FindBy(css = "#container > div > div > div.reset-foot > div > button") private WebElement submitNewPassBtn;
//    @FindBy(css = "#container > div > div > div.reset-popup > div.reset-status > p") private WebElement getSuccessMessgage;
    @FindBy(css = "div > input[type='text']")
    private WebElement inputMail_field;
    @FindBy(css = "div.forgot-action > button")
    private WebElement resetPassBtn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/span[2]") private WebElement verifyByEmailBtn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div/div/div/span") private WebElement sendCodeBtn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div/div[1]/div/input") private WebElement inputCodeField;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div/span") private WebElement verifyCodeBtn;
    @FindBy(css = "div.mod-input-newPassword > input[type='password']")
    private WebElement inputNewPassField;
    @FindBy(css = "div.mod-input-re-newPassword > input[type='password']")
    private WebElement inputReNewPassField;
    @FindBy(css = "div > button")
    private WebElement submitNewPassBtn;
    @FindBy(css = "div.reset-status > p")
    private WebElement getSuccessMessgage;
    //    waitUntilInvisibilityOf(By.id("__react_loading_show__"));

    public void resetPasswordStep(String mail) {
        waitUntilPageReady();
        waitUntilVisible(inputMail_field);
        this.inputMail_field.sendKeys(mail);
        waitUntilClickable(By.cssSelector("#container > div > div > div.forgot-action > button"));
        this.resetPassBtn.click();
    }

    public void verifyByMail() {
        waitUntilPageReady();
        waitUntilClickable(By.xpath("/html/body/div[2]/div/div/div[1]/span[2]"));
        this.verifyByEmailBtn.click();
        this.sendCodeBtn.click();
    }

    public void inputCode(String smsCode){
        waitUntilVisible(inputCodeField);
        this.inputCodeField.sendKeys(smsCode);
        waitUntilClickable(By.xpath("/html/body/div[2]/div/div/div[3]/div/span"));
        this.verifyCodeBtn.click();
    }

    public void progressNewPass(String newPassWord) {
        waitUntilPageReady();
        waitUntilVisible(inputNewPassField);
        this.inputNewPassField.sendKeys(newPassWord);
        this.inputReNewPassField.sendKeys(newPassWord);
        waitUntilClickable(By.cssSelector("#container > div > div > div.reset-foot > div > button"));
        this.submitNewPassBtn.click();
    }

    public boolean hasSuccessResetMessage(){
        waitUntilPageReady();
        waitUntilVisible(getSuccessMessgage);
        return getSuccessMessgage.isDisplayed();
    }

}