package pages.desktop.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class Member_AccEdit_PC_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/profile#/profile/edit";

    @FindBy(css = ".mod-input-name input") private WebElement editName;
    @FindBy(className = "mod-input-close-icon") private WebElement clearOldname;
    @FindBy(css = ".next-btn-large") private WebElement saveChangesbtn;

    public void setClearOldName(){
        waitUntilPageReady();
        waitUntilVisible(clearOldname);
        this.clearOldname.click();
    }

    public void setEditName(String newName) {
        waitUntilPageReady();
        waitUntilVisible(editName);
        this.editName.sendKeys(newName);
    }

    public void setSaveChangesBtn() {
        waitUntilPageReady();
        waitUntilVisible(saveChangesbtn);
        this.saveChangesbtn.click();
    }


}
