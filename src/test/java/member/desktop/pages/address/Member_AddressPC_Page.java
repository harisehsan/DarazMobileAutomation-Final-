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

    @FindBy(css = ".next-btn-normal")
    private WebElement addNewAddress_btn;
    @FindBy(css = ".mod-input-name input")
    private WebElement name_txtField;
    @FindBy(css = ".mod-input-phone input")
    private WebElement phone_txtField;
    @FindBy(css = ".mod-select-location-tree-1")
    private WebElement locationTree1_listBtn;
    @FindBy(css = ".next-menu-content > li")
    private List<WebElement> selectTree_listItem;
    @FindBy(css = ".mod-select-location-tree-2")
    private WebElement locationTree2_listBtn;
    @FindBy(css = ".mod-select-location-tree-3")
    private WebElement locationTree3_listBtn;
    @FindBy(css = ".mod-input-detailAddress > input")
    private WebElement address_txtField;
    @FindBy(css = ".mod-input-postCode > input[type='number']")
    private WebElement postCode_txtField;
    @FindBy(css = ".mod-address-form-btn")
    private WebElement save_btn;
    @FindBy(className = "mod-address-book-default")
    private WebElement hasAddress_lbl;
    @FindBy(css = ".mod-input-detailAddress input")
    private WebElement detailAddress_txtField;
    @FindBy(css = ".next-table-cell")
    private WebElement editAddress_btn;
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[6]/div/button")
    private WebElement editAddLzd_btn;
    @FindBy(css = "tr > td:nth-child(2) > div")
    private WebElement hasNewNameDrz_lbl;
    @FindBy(css = "tr > td.next-table-cell.first > div")
    private WebElement hasNewNameLzd_lbl;
    @FindBy(css = "tbody > tr:nth-child(2) > td > div > button")
    private WebElement accessDeleteAddDrz_btn;
    @FindBy(css = " tbody > tr.next-table-row.last > td.next-table-cell.last > div > button")
    private WebElement accessDeleteAddLzd_btn;
    @FindBy(className = "mod-address-update-hd")
    private WebElement delete_btn;
    @FindBy(css = "div.mod-input-name > div")
    private WebElement clearName_btn;
    @FindBy(css = "div.mod-input-phone > div")
    private WebElement clearPhone_btn;
    @FindBy(css = "#dialog-footer-2 > button.next-btn-medium")
    private WebElement deleteConfirm_btn;
    @FindBy(css = "tbody > tr.next-table-row")
    private List<WebElement> addressLevel_list;
    @FindBy(css = "div.next-table-body > table > tbody")
    private List<WebElement> address_list;

    public void addNewAddress(){
        waitUntilPageReady();
        waitUntilVisible(addNewAddress_btn);
        this.addNewAddress_btn.click();
    }

    public void accessDeleteAddressDrz(){
        waitUntilPageReady();
        waitUntilVisible(accessDeleteAddDrz_btn);
        this.accessDeleteAddDrz_btn.click();
    }

    public void accessDeleteAddressLzd(){
        waitUntilPageReady();
        waitUntilVisible(accessDeleteAddLzd_btn);
        this.accessDeleteAddLzd_btn.click();
    }

    public void inputName(String name){
        waitUntilPageReady();
        waitUntilVisible(name_txtField);
        this.name_txtField.sendKeys(name);
    }

    public void inputPhone(String phone){
        waitUntilPageReady();
        waitUntilVisible(phone_txtField);
        this.phone_txtField.sendKeys(phone);
    }

    public void setLocationTree1(){
        waitUntilPageReady();
        waitUntilVisible(editAddress_btn);
        this.editAddress_btn.click();
    }

    public void editAddLzd(){
        waitUntilPageReady();
        waitUntilClickable(By.xpath("//*[@id=\"container\"]/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[6]/div/button"));
        this.editAddLzd_btn.click();
    }

    public void editAddDrz(){
        waitUntilPageReady();
        waitUntilVisible(editAddress_btn);
        this.editAddress_btn.click();
    }
    public void deleteBtn() {
        waitUntilPageReady();
        waitUntilVisible(delete_btn);
        this.delete_btn.click();
        waitUntilClickable(By.cssSelector("#dialog-footer-2 > button.next-btn-medium"));
        this.deleteConfirm_btn.click();
        waitUntilInvisibilityOf(By.className("mod-address-update-hd"));
    }

    public int getAddressListSize() {
        waitUntilPageReady();
        return addressLevel_list.size();
    }

    public void clearName(){
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("div.mod-input-name > div"));
        this.clearName_btn.click();
    }

    public void clearPhone(){
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("div.mod-input-phone > div"));
        this.clearPhone_btn.click();
    }


    public void selectTree(){
        if (selectTree_listItem.size() > 0) {
            WebElement random_element = selectTree_listItem.get(new Random().nextInt(selectTree_listItem.size()));
            waitUntilVisible(random_element);
            waitUntilClickable(By.cssSelector(".next-menu-content > li"));
            random_element.click();
        }
    }

    public void setLocationTree2(){
        waitUntilPageReady();
        waitUntilVisible(locationTree2_listBtn);
        this.locationTree2_listBtn.click();
    }

    public void setLocationTree3(){
        waitUntilPageReady();
        waitUntilVisible(locationTree3_listBtn);
        this.locationTree3_listBtn.click();
    }

    public void inputAddress(String address){
        waitUntilPageReady();
        waitUntilVisible(address_txtField);
        this.address_txtField.sendKeys(address);
    }

    public void clickSaveBtn(){
        waitUntilPageReady();
        waitUntilVisible(save_btn);
        this.save_btn.click();
        waitUntilInvisibilityOf(By.cssSelector(".mod-address-form-btn"));
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

    public void setDetailAddress(String da){
        waitUntilVisible(detailAddress_txtField);
        this.detailAddress_txtField.sendKeys(da);
    }

    public void createFastNewAddress(String phone, String detailAddress){
        waitUntilVisible(phone_txtField);
        this.phone_txtField.sendKeys(phone);
        waitUntilVisible(locationTree1_listBtn);
        waitUntilClickable(By.cssSelector(".mod-select-location-tree-1"));
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        this.locationTree1_listBtn.click();
        selectTree();
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        waitUntilClickable(By.cssSelector(".mod-select-location-tree-2"));
        this.locationTree2_listBtn.click();
        waitUntilVisibility(By.cssSelector(".next-menu-content > li"));
        selectTree();
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        waitUntilClickable(By.cssSelector(".mod-select-location-tree-3"));
        this.locationTree3_listBtn.click();
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        waitUntilVisibility(By.cssSelector(".next-menu-content > li"));
        selectTree();
        this.address_txtField.sendKeys(detailAddress);
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        waitUntilClickable(By.cssSelector(".mod-address-form-btn"));
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        this.save_btn.click();
        waitUntilInvisibilityOf(By.cssSelector(".mod-address-form-btn"));
    }

    public void createAddressSg(String phone, String postCode, String detailAdd) {
        waitUntilVisible(phone_txtField);
        this.phone_txtField.sendKeys(phone);
        this.postCode_txtField.sendKeys(postCode);
        this.phone_txtField.click();
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        waitUntilVisible(detailAddress_txtField);
        this.detailAddress_txtField.sendKeys(detailAdd);
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        this.save_btn.click();
        waitUntilInvisibilityOf(By.cssSelector(".mod-address-form-btn"));
    }

    public boolean hasNoAddressDeleted() {
        waitUntilPageReady();
        waitUntilVisible(editAddLzd_btn);
        return this.address_list.size() == 1;
    }
}