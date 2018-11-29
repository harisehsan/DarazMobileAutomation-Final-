package member.desktop.pages.account;

import base.PageObject;
import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class Member_Mailinator_Page extends PageObject {

    public static String page_url = Global.config.getString("member.account.mailinator_mail");

    @FindBy(css = "#inboxfield") private WebElement inputMail;
    @FindBy(css = ".btn-dark") private WebElement goBtn;
    @FindBy(css = "#inboxpane > div > div > div > table > tbody > tr") private List<WebElement> emailList;
    @FindBy(css = "body > table > tbody > tr > td > center > table > tbody > tr > td > div > div.verify-code-container > span") private WebElement smsCodeDetail;
    @FindBy(id = "msg_body") private WebElement msgBody;

    public void inputMail(String mail){
        waitUntilPageReady();
        waitUntilVisible(inputMail);
        this.inputMail.sendKeys(mail);
        this.goBtn.click();
    }

    public void clickGoMailDetail(){
        waitUntilPageReady();
        this.emailList.get(0).click();
    }

    public String getSMSCodeDetail() {
        switchToFrame(msgBody);
        waitUntilPageReady();
        waitUntilVisible(smsCodeDetail);
        return smsCodeDetail.getText();
    }

}