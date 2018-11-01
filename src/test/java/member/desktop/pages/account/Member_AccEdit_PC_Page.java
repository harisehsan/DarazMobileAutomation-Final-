package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_AccEdit_PC_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/profile#/profile/edit";

    @FindBy(css = ".mod-input-name input") private WebElement editName;
    @FindBy(className = "mod-input-close-icon") private WebElement clearOldname;
    @FindBy(css = ".next-btn-large") private WebElement saveChangesbtn;

    public void setClearOldname(){
        waitUntilPageReady();
        waitUntilVisible(clearOldname);
        this.clearOldname.click();
    }

    public void setEditName(String en) {
        waitUntilPageReady();
        waitUntilVisible(editName);
        this.editName.sendKeys(en);
    }

    public void setSaveChangesbtn() {
        waitUntilPageReady();
        waitUntilVisible(saveChangesbtn);
        this.saveChangesbtn.click();
    }


}
