package member.msite.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Member_Mailinator_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.account.mailinator_mail");

    @FindBy(css = "#inboxfield") private WebElement mail_txtField;
    @FindBy(css = ".btn-dark") private WebElement go_btn;
    @FindBy(xpath = "//*[starts-with(@id,'row_lazadatest_1111')]/div") private WebElement email_list;
    @FindBy(css = "div.verify-code-container > span") private WebElement smsCodeDetail_lbl;
    @FindBy(id = "msg_body") private WebElement msgBody_btn;

    public void inputMail(String mail) {
        waitUntilPageReady();
        waitUntilVisible(mail_txtField);
        this.mail_txtField.sendKeys(mail);
        this.go_btn.click();
    }

    public void goToMailDetail() {
        waitUntilPageReady();
        waitUntilVisible(email_list);
        this.email_list.click();
    }

    public String getSMSCodeDetail() {
        switchToFrame(msgBody_btn);
        waitUntilPageReady();
        waitUntilVisible(smsCodeDetail_lbl);
        return smsCodeDetail_lbl.getText();
    }
}