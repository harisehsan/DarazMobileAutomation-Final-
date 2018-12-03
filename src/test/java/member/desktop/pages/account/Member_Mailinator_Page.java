package member.desktop.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class Member_Mailinator_Page extends PageObject {

    public static String page_url = Global.config.getString("member.account.mailinator_mail");

    @FindBy(css = "#inboxfield")
    private WebElement email_txtField;
    @FindBy(css = ".btn-dark")
    private WebElement go_btn;
    @FindBy(css = "#inboxpane > div > div > div > table > tbody > tr")
    private List<WebElement> email_list;
    @FindBy(css = "div.verify-code-container > span")
    private WebElement smsCodeDetail_lbl;
    @FindBy(id = "msg_body") private WebElement msgBody;

    public void inputMail(String mail){
        waitUntilPageReady();
        waitUntilVisible(email_txtField);
        this.email_txtField.sendKeys(mail);
        this.go_btn.click();
    }

    public void clickGoMailDetail(){
        waitUntilPageReady();
        this.email_list.get(0).click();
    }

    public String getSMSCodeDetail() {
        switchToFrame(msgBody);
        waitUntilPageReady();
        waitUntilVisible(smsCodeDetail_lbl);
        return smsCodeDetail_lbl.getText();
    }

}