package member.msite.pages.account;

import allure.AllureAttachment;
import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Member_ChangeEmail_Msite_Page extends PageObject {

    public static String page_url = Global.getConfig().getString("member.msite_url") + "/member/account-info";

    @FindBy(xpath = "/html/body/div[2]/div[2]/span[3]")private WebElement changeEmail_btn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/span[2]") private WebElement verifyByEmail_btn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div/div/div/span") private WebElement sendCode_btn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div/div[1]/div/input") private WebElement code_txtField;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div/span") private WebElement verifyCode_btn;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div/input") private WebElement newEmail_txtField;
    @FindBy(css = "body > div:nth-child(11) > div:nth-child(2) > span:nth-child(3)") private WebElement newEmail_lbl;


    private By changeEmail_btn_by = By.xpath("/html/body/div[2]/div[2]/span[3]");
    private By verifyByEmail_btn_by = By.xpath("/html/body/div[2]/div/div/div[1]/span[2]");
    private By newEmail_txtField_by = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div/input");
    private By newEmail_lbl_by = By.cssSelector("body > div:nth-child(11) > div:nth-child(2) > span:nth-child(3)");


    public void clickChangeEmail() {
        waitUntilPageReady();
        waitUntilClickable(changeEmail_btn_by);
        this.changeEmail_btn.click();
        waitUntilClickable(verifyByEmail_btn_by);
        this.verifyByEmail_btn.click();
        this.sendCode_btn.click();
    }

    public void sendCodeToNewEmail(String newEmail) {
        waitUntilPageReady();
        waitUntilVisibility(newEmail_txtField_by);
        this.newEmail_txtField.sendKeys(newEmail);
        this.sendCode_btn.click();
    }

    public boolean hasNewEmail(String newEmail) {
        waitUntilPageReady();
        waitUntilVisibility(newEmail_lbl_by);
        return newEmail_lbl.getText().equals(newEmail);
    }

    public void allureReportCurrentMail(String currentEmail) {
        AllureAttachment.attachURL(currentUrl());
        AllureAttachment.attachComment("Current email",currentEmail);
    }
}