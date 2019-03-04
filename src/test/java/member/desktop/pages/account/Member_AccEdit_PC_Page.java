package member.desktop.pages.account;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;
import java.util.List;

public class Member_AccEdit_PC_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/user/profile#/profile/edit";

    @FindBy(css = ".mod-input-name input") private WebElement editName_txtField;
    @FindBy(className = "mod-input-close-icon") private WebElement clearOldName_btn;
    @FindBy(css = ".next-btn-large") private WebElement saveChanges_btn;
    @FindBy(css = "div > div:nth-child(2) > h3 > a") private WebElement changeEmail_btn;
    @FindBy(className = "buttons") private WebElement verifyEmail_btn;
    @FindBy(className = "mod-sendcode") private WebElement sendCode_btn;
    @FindBy(css = "span#month > span") private WebElement month_drpDownList;
    @FindBy (css = "span#day > span") private WebElement day_drpDownList;
    @FindBy (css = "span#year > span") private WebElement year_drpDownList;
    @FindBy(css = "span#gender > span")  private WebElement gender_drpDownList;
    @FindBy(css = "ul > li.next-menu-item") private List <WebElement> Selector_listItem;
    @FindBy(css = "div#container div:nth-child(6) > div > div > input[type='text']") private WebElement editTaxId_txtField;
    @FindBy(css = ".mod-input-branchId input") private WebElement editBranchId_txtField;
    @FindBy(css = "div#container div:nth-child(6) > div > div > div") private WebElement clearTaxId_btn;
    @FindBy(css = "div#container div:nth-child(7) > div > div > div") private WebElement clearBrnachId_btn;

    private int random;
    private String day = "";
    private int size = 0;

    private By Selector_listItem_by = By.cssSelector("ul > li.next-menu-item");
    private By changeEmail_btn_by = By.cssSelector("div > div:nth-child(2) > h3 > a");
    private By verifyEmail_btn_by = By.className("buttons");
    private By sendCode_btn_by = By.className("mod-sendcode");

    public void clearOldName() {
        waitUntilPageReady();
        waitUntilVisible(clearOldName_btn);
        this.clearOldName_btn.click();
    }

    public void editName(String newName) {
        waitUntilPageReady();
        waitUntilVisible(editName_txtField);
        this.editName_txtField.sendKeys(newName);
    }

    public void saveChangesBtn() {
        waitUntilPageReady();
        waitUntilVisible(saveChanges_btn);
        this.saveChanges_btn.click();
    }

    public void sendCodeToInboxMail() {
        waitUntilPageReady();
        waitUntilClickable(changeEmail_btn_by);
        this.changeEmail_btn.click();
        waitUntilClickable(verifyEmail_btn_by);
        this.verifyEmail_btn.click();
        waitUntilClickable(sendCode_btn_by);
        this.sendCode_btn.click();
    }

    public void clearOldTaxId() // This method clears the already existed Tax code on edit profile page (if available)
    {   if (page_url.contains(".th") || page_url.contains(".vn"))
    {
        waitUntilPageReady();
        waitUntilVisible(editTaxId_txtField);
        if(!(editTaxId_txtField.getAttribute("value").equalsIgnoreCase("")))
        {
            waitUntilVisible(clearTaxId_btn);
            this.clearTaxId_btn.click();
        }
    }
    }

    public void clearBranchId() // This method clears the already existed branch id on edit profile page (if available)
    { if (page_url.contains(".th"))
    {
        waitUntilPageReady();
        waitUntilVisible(editBranchId_txtField);
        if(!(editBranchId_txtField.getAttribute("value").equalsIgnoreCase("")))
        {
            waitUntilVisible(clearBrnachId_btn);
            this.clearBrnachId_btn.click();
        }
    }
    }

    public String changeTaxCode(String code) { // This method changes the branch id on edit profile page (if available)
        if (page_url.contains(".th") || page_url.contains(".vn")) {
            waitUntilPageReady();
            waitUntilVisible(editTaxId_txtField);
            editTaxId_txtField.clear();
            this.editTaxId_txtField.sendKeys(code);
            return code;
        }
        else {
            return "";
        }
    }
    public String changeBranchId(String code) { // This method changes the branch id on edit profile page (if available)
        if (page_url.contains(".th")) {
            waitUntilPageReady();
            waitUntilVisible(editBranchId_txtField);
            editBranchId_txtField.clear();
            this.editBranchId_txtField.sendKeys(code);
            return code;
        }
        else
            return "";
    }

    public String changeMonth() { // This method changes the month of date of birth on edit profile page
        waitUntilVisible(month_drpDownList);
        month_drpDownList.click();
        size = Selector_listItem.size();
        if (size > 12) {size = 12;}
        random = getRandom(size);
        waitUntilLocated(Selector_listItem_by);
        clickWithoutException(Selector_listItem.get(random));
        return (Integer.toString((random+1)));
    }

    public String changeDay() { // This method changes the day of date of birth on edit profile page
        waitUntilVisible(day_drpDownList);
        day_drpDownList.click();
        size = Selector_listItem.size();
        if (size > 28) {size = 28;}
        random = getRandom(size);
        waitUntilLocated(Selector_listItem_by);
        Selector_listItem.get(random).click();
        day = day_drpDownList.getText();
        if (Integer.parseInt(day) < 10) {day = day.replace("0", "");}
        return day;
    }

    public String changeYear() { // This method changes the year of date of birth on edit profile page
        waitUntilVisible(year_drpDownList);
        year_drpDownList.click();
        size = Selector_listItem.size();
        if (size > 120) {size = 120;}
        waitUntilLocated(Selector_listItem_by);
        random = getRandom(size);
        clickWithoutException(Selector_listItem.get(random));
        return year_drpDownList.getText();
    }

    public String changeGender() { // This method changes the gender on edit profile page
        waitUntilPageReady();
        waitUntilVisible(gender_drpDownList);
        if (gender_drpDownList.getText().equalsIgnoreCase("male") || gender_drpDownList.getText().equalsIgnoreCase("Male")) {
            gender_drpDownList.click();
            Selector_listItem.get(1).click();
        } else if (gender_drpDownList.getText().equalsIgnoreCase("female") || gender_drpDownList.getText().equalsIgnoreCase("Female")) {
            gender_drpDownList.click();
            Selector_listItem.get(0).click();
        } else {
            gender_drpDownList.click();
            Selector_listItem.get(0).click();
        }
        return this.gender_drpDownList.getText();
    }
}