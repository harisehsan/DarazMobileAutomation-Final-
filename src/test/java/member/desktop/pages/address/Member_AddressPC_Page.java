package member.desktop.pages.address;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;
import java.util.List;
import java.util.Random;

public class Member_AddressPC_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/address";

    @FindBy(css = ".next-btn-normal") private WebElement addNewAddress_btn;
    @FindBy(css = ".mod-input-name input") private WebElement name_txtField;
    @FindBy(css = ".mod-input-phone input") private WebElement phone_txtField;
    @FindBy(css = ".mod-select-location-tree-1") private WebElement locationTree1_listBtn;
    @FindBy(css = ".next-menu-content > li") private List<WebElement> selectTree_listItems;
    @FindBy(css = ".mod-select-location-tree-2") private WebElement locationTree2_listBtn;
    @FindBy(css = ".mod-select-location-tree-3") private WebElement locationTree3_listBtn;
    @FindBy(css = ".mod-input-detailAddress > input") private WebElement address_txtField;
    @FindBy(css = ".mod-input-postCode > input[type='number']") private WebElement postCode_txtField;
    @FindBy(xpath = "//button[contains(.,'SAVE')]") private WebElement savesg_btn;
    @FindBy(css = "div.mod-address-form-action > button") private WebElement save_btn;
    @FindBy(className = "mod-address-book-default") private WebElement hasAddress_lbl;
    @FindBy(css = ".mod-input-detailAddress input") private WebElement detailAddress_txtField;
    @FindBy(css = ".next-table-cell") private WebElement editAddress_btn;
    @FindBy(xpath = "//*[@id='container']/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[6]/div/button") private WebElement editAddLzd_btn;
    @FindBy(css = "tr > td:nth-child(2) > div") private WebElement hasNewNameDrz_lbl;
    @FindBy(css = "tr > td.next-table-cell.first > div") private WebElement hasNewNameLzd_lbl;
    @FindBy(css = "tbody > tr:nth-child(2) > td > div > button") private WebElement accessDeleteAddDrz_btn;
    @FindBy(css = "tbody > tr:nth-child(2) > td > div > button") private WebElement accessDeleteAddLzd_btn;
    @FindBy(className = "mod-address-update-hd") private WebElement delete_btn;
    @FindBy(css = "div.mod-input-name > div") private WebElement clearName_btn;
    @FindBy(css = "div.mod-input-phone > div") private WebElement clearPhone_btn;
    @FindBy(css = "#dialog-footer-2 > button.next-btn-medium") private WebElement deleteConfirm_btn;
    @FindBy(css = "tbody > tr.next-table-row") private List<WebElement> addressLevel_listItems;
    @FindBy(css = "div.next-table-body > table > tbody") private List<WebElement> address_listItems;

    private By loadingicon_by = By.id("__react_loading_show__");
    private By locationTree1_listBtn_by = By.cssSelector(".mod-select-location-tree-1");
    private By locationTree2_listBtn_by = By.cssSelector(".mod-select-location-tree-2");
    private By locationTree3_listBtn_by = By.cssSelector(".mod-select-location-tree-3");
    private By editAddLzd_btn_by = By.xpath("//*[@id='container']/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[6]/div/button");
    private By deleteConfirm_btn_by = By.cssSelector("#dialog-footer-2 > button.next-btn-medium");
    private By delete_btn_by = By.className("mod-address-update-hd");
    private By clearName_btn_by = By.cssSelector("div.mod-input-name > div");
    private By clearPhone_btn_by = By.cssSelector("div.mod-input-phone > div");
    private By selectTree_listItems_by = By.cssSelector(".next-menu-content > li");
    private By savesg_btn_by = By.xpath("//button[contains(.,'SAVE')]"); // checking
    private By save_btn_by = By.cssSelector("div.mod-address-form-action > button");

    public void addNewAddress() {
        waitUntilPageReady();
        waitUntilVisible(addNewAddress_btn);
        this.addNewAddress_btn.click();
    }

    public void accessDeleteAddressDrz() {
        waitUntilPageReady();
        waitUntilVisible(accessDeleteAddDrz_btn);
        this.accessDeleteAddDrz_btn.click();
    }

    public void accessDeleteAddressLzd() {
        waitUntilPageReady();
        waitUntilVisible(accessDeleteAddLzd_btn);
        this.accessDeleteAddLzd_btn.click();
    }

    public void inputName(String name) {
        waitUntilPageReady();
        waitUntilVisible(name_txtField);
        this.name_txtField.sendKeys(name);
    }

    public void inputPhone(String phone) {
        waitUntilPageReady();
        waitUntilVisible(phone_txtField);
        this.phone_txtField.sendKeys(phone);
    }

    public void setLocationTree1() {
        waitUntilPageReady();
        waitUntilVisible(editAddress_btn);
        this.editAddress_btn.click();
    }

    public void editAddLzd() {
        waitUntilPageReady();
        waitUntilClickable(editAddLzd_btn_by);
        this.editAddLzd_btn.click();
    }

    public void editAddDrz() {
        waitUntilPageReady();
        waitUntilVisible(editAddress_btn);
        this.editAddress_btn.click();
    }
    public void deleteBtn() {
        waitUntilPageReady();
        waitUntilVisible(delete_btn);
        this.delete_btn.click();
        waitUntilClickable(deleteConfirm_btn_by);
        this.deleteConfirm_btn.click();
        waitUntilInvisibilityOf(delete_btn_by);
    }

    public int getAddressListSize() {
        waitUntilPageReady();
        return addressLevel_listItems.size();
    }

    public void clearName() {
        waitUntilPageReady();
        waitUntilClickable(clearName_btn_by);
        this.clearName_btn.click();
    }

    public void clearPhone() {
        waitUntilPageReady();
        waitUntilClickable(clearPhone_btn_by);
        this.clearPhone_btn.click();
    }

    public void selectTree() {
        if(selectTree_listItems.size() > 0) {
            WebElement random_element = selectTree_listItems.get(new Random().nextInt(selectTree_listItems.size()));
            waitUntilVisible(random_element);
            waitUntilClickable(selectTree_listItems_by);
            random_element.click();
        }
    }

    public void setLocationTree2() {
        waitUntilPageReady();
        waitUntilVisible(locationTree2_listBtn);
        this.locationTree2_listBtn.click();
    }

    public void setLocationTree3() {
        waitUntilPageReady();
        waitUntilVisible(locationTree3_listBtn);
        this.locationTree3_listBtn.click();
    }

    public void inputAddress(String address) {
        waitUntilPageReady();
        waitUntilVisible(address_txtField);
        this.address_txtField.sendKeys(address);
    }

    public void clickSaveBtn() {
        waitUntilPageReady();
        waitUntilClickable(save_btn_by);
        this.save_btn.click();
        waitUntilInvisibilityOf(save_btn_by);
    }

    public boolean hasAddress() {
        waitUntilVisible(hasAddress_lbl);
        return this.hasAddress_lbl.isDisplayed();
    }

    public String hasNewNameDrz() {
        waitUntilVisible(hasNewNameDrz_lbl);
        return hasNewNameDrz_lbl.getText();
    }

    public String hasNewNameLzd() {
        waitUntilVisible(hasNewNameLzd_lbl);
        return hasNewNameLzd_lbl.getText();
    }

    public void setDetailAddress(String da) {
        waitUntilVisible(detailAddress_txtField);
        this.detailAddress_txtField.sendKeys(da);
    }

    public void createFastNewAddress(String phone, String detailAddress) {
        waitUntilVisible(phone_txtField);
        this.phone_txtField.sendKeys(phone);
        waitUntilVisible(locationTree1_listBtn);
        waitUntilClickable(locationTree1_listBtn_by);
        waitUntilInvisibilityOf(loadingicon_by);
        this.locationTree1_listBtn.click();
        selectTree();
        waitUntilInvisibilityOf(loadingicon_by);
        waitUntilClickable(locationTree2_listBtn_by);
        this.locationTree2_listBtn.click();
        waitUntilVisibility(selectTree_listItems_by);
        selectTree();
        waitUntilInvisibilityOf(loadingicon_by);
        waitUntilClickable(locationTree3_listBtn_by);
        this.locationTree3_listBtn.click();
        waitUntilInvisibilityOf(loadingicon_by);
        waitUntilVisibility(selectTree_listItems_by);
        selectTree();
        this.address_txtField.sendKeys(detailAddress);
        waitUntilInvisibilityOf(loadingicon_by);
        waitUntilClickable(save_btn_by);
        waitUntilInvisibilityOf(loadingicon_by);
        this.save_btn.click();
        waitUntilInvisibilityOf(save_btn_by);
    }

    public void createAddressSg(String phone, String postCode, String detailAdd) {
        waitUntilVisible(phone_txtField);
        this.phone_txtField.sendKeys(phone);
        this.postCode_txtField.sendKeys(postCode);
        this.phone_txtField.click();
        waitUntilInvisibilityOf(loadingicon_by);
        waitUntilVisible(detailAddress_txtField);
        this.detailAddress_txtField.sendKeys(detailAdd);
        waitUntilInvisibilityOf(loadingicon_by);
        waitUntilClickable(save_btn_by);
        this.savesg_btn.click();
        waitUntilInvisibilityOf(savesg_btn_by);
    }

    public boolean hasNoAddressDeleted() {
        waitUntilPageReady();
        waitUntilVisible(editAddress_btn);
        return address_listItems.size() == 1;
    }
}