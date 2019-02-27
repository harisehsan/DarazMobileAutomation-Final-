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
    @FindBy(css = "span#month > span") private WebElement monthPicker;
    @FindBy (css = "span#day > span") private WebElement dayPicker;
    @FindBy (css = "span#year > span") private WebElement yearPicker;
    @FindBy(css = "span#gender > span")  private WebElement genderPicker;
    @FindBy(css = "ul > li.next-menu-item") private List <WebElement> listSelector;
    @FindBy(css = "div#container div:nth-child(6) > div > div > input[type='text']") private WebElement editTaxId_txtField;
    @FindBy(css = ".mod-input-branchId input") private WebElement editBranchId_txtField;
    @FindBy(css = "div#container div:nth-child(6) > div > div > div") private WebElement clearOldTaxId_btn;
    @FindBy(css = "div#container div:nth-child(7) > div > div > div") private WebElement clearOldBrnachId_btn;

    private int random;
    private String day = "";
    private int size = 0;

    private By listSelection_by  = By.cssSelector("ul > li.next-menu-item");
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
            waitUntilVisible(clearOldTaxId_btn);
            this.clearOldTaxId_btn.click();
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
            waitUntilVisible(clearOldBrnachId_btn);
            this.clearOldBrnachId_btn.click();
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
        waitUntilVisible(monthPicker);
        monthPicker.click();
        size = listSelector.size();
        if (size > 12) {size = 12;}
        random = getRandom(size);
        waitUntilLocated(listSelection_by);
        clickWithoutException(listSelector.get(random));
        return (Integer.toString((random+1)));
    }

    public String changeDay() { // This method changes the day of date of birth on edit profile page
        waitUntilVisible(dayPicker);
        dayPicker.click();
        size = listSelector.size();
        if (size > 30) {size = 30;}
        random = getRandom(size);
        waitUntilLocated(listSelection_by);
        listSelector.get(random).click();
        day = dayPicker.getText();
        if (Integer.parseInt(day) < 10) {day = day.replace("0", "");}
        return day;
    }

    public String changeYear() { // This method changes the year of date of birth on edit profile page
        waitUntilVisible(yearPicker);
        yearPicker.click();
        size = listSelector.size();
        if (size > 120) {size = 120;}
        waitUntilLocated(listSelection_by);
        random = getRandom(size);
        clickWithoutException(listSelector.get(random));
        return yearPicker.getText();
    }

    public String changeGender() { // This method changes the gender of birth on edit profile page
        waitUntilPageReady();
        waitUntilVisible(genderPicker);
        if (genderPicker.getText().equalsIgnoreCase("male") || genderPicker.getText().equalsIgnoreCase("Male")) {
            genderPicker.click();
            listSelector.get(1).click();
        } else if (genderPicker.getText().equalsIgnoreCase("female") || genderPicker.getText().equalsIgnoreCase("Female")) {
            genderPicker.click();
            listSelector.get(0).click();
        } else {
            genderPicker.click();
            listSelector.get(0).click();
        }
        return this.genderPicker.getText();
    }
}