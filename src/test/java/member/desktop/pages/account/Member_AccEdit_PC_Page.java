package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Member_AccEdit_PC_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/profile#/profile/edit";

    @FindBy(css = ".mod-input-name input") private WebElement editName;
    @FindBy(className = "mod-input-close-icon") private WebElement clearOldName;
    @FindBy(css = ".next-btn-large") private WebElement saveChangesBtn;

    public void clearOldName(){
        waitUntilPageReady();
        waitUntilVisible(clearOldName);
        this.clearOldName.click();
    }

    public void editName(String newName) {
        waitUntilPageReady();
        waitUntilVisible(editName);
        this.editName.sendKeys(newName);
    }

    public void saveChangesBtn() {
        waitUntilPageReady();
        waitUntilVisible(saveChangesBtn);
        this.saveChangesBtn.click();
    }
}