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

    @FindBy(css = ".next-btn-normal") private WebElement addNewAddress;
    @FindBy(css = ".mod-input-name input") private WebElement inputName;
    @FindBy(css = ".mod-input-phone input") private WebElement inputPhone;
    @FindBy(css = ".mod-select-location-tree-1") private WebElement locationTree1;
    @FindBy(css = ".next-menu-content > li") private List<WebElement> selectTree;
    @FindBy(css = ".mod-select-location-tree-2") private WebElement locationTree2;
    @FindBy(css = ".mod-select-location-tree-3") private WebElement locationTree3;
    @FindBy(css = ".mod-input-detailAddress input") private WebElement inputAddress;
    @FindBy(css =".mod-address-form-btn") private WebElement clickSavebtn;
    @FindBy(className = "mod-address-book-default") private WebElement hasAddress;
    @FindBy(css = ".mod-input-detailAddress input") private WebElement detailAddress;
    @FindBy(css= ".next-table-cell") private WebElement editAddress;
    @FindBy(css = "#container > div > div > div > div.next-table.only-bottom-border > div > div.next-table-body > table > tbody > tr.next-table-row.first > td.next-table-cell.last > div > button") private WebElement editAddLzd;
    @FindBy(css = "#container > div > div > div > div.next-table.only-bottom-border > div > div.next-table-body > table > tbody > tr.next-table-row.first > td:nth-child(2) > div") private WebElement hasNewNameDrz;
    @FindBy(css="#container > div > div > div > div.next-table.only-bottom-border > div > div.next-table-body > table > tbody > tr > td.next-table-cell.first > div") private WebElement hasNewNameLzd;
    @FindBy(css = "#container > div > div > div > div.next-table.only-bottom-border > div > div.next-table-body > table > tbody > tr:nth-child(2) > td.next-table-cell.first > div > button") private WebElement accessDeleteAddDrz;
    @FindBy(css="#container > div > div > div > div.next-table.only-bottom-border > div > div.next-table-body > table > tbody > tr.next-table-row.last > td.next-table-cell.last > div > button") private WebElement accessDeleteAddLzd;
    @FindBy(className = "mod-address-update-hd") private WebElement deleteBtn;
    @FindBy(css = "#dialog-footer-2 > button.next-btn.next-btn-primary.next-btn-medium") private WebElement deleteConfirm;
    @FindBy(css = "#container > div > div > div > div.next-table.only-bottom-border > div > div.next-table-body > table > tbody > tr.next-table-row") private List<WebElement> addressLevel;

    public void addNewAddress(){
        waitUntilPageReady();
        waitUntilVisible(addNewAddress);
        this.addNewAddress.click();
    }

    public void accessDeleteAddressDrz(){
        waitUntilPageReady();
        waitUntilVisible(accessDeleteAddDrz);
        this.accessDeleteAddDrz.click();
    }

    public void accessDeleteAddressLzd(){
        waitUntilPageReady();
        waitUntilVisible(accessDeleteAddLzd);
        this.accessDeleteAddLzd.click();
    }

    public void inputName(String name){
        waitUntilPageReady();
        waitUntilVisible(inputName);
        this.inputName.sendKeys(name);
    }

    public void inputPhone(String phone){
        waitUntilPageReady();
        waitUntilVisible(inputPhone);
        this.inputPhone.sendKeys(phone);
    }

    public void setLocationTree1(){
        waitUntilPageReady();
        waitUntilVisible(locationTree1);
        this.locationTree1.click();

    }

    public void editAddDrz(){
        waitUntilPageReady();
        waitUntilVisible(editAddress);
        this.editAddress.click();
    }

    public void editAddLzd(){
        waitUntilPageReady();
        waitUntilVisible(editAddLzd);
        this.editAddLzd.click();
    }

    public void deleteBtn() {
        waitUntilPageReady();
        waitUntilVisible(deleteBtn);
        this.deleteBtn.click();
        waitUntilClickable(By.cssSelector("#dialog-footer-2 > button.next-btn.next-btn-primary.next-btn-medium"));
        this.deleteConfirm.click();
        waitUntilInvisibilityOf(By.className("mod-address-update-hd"));
    }

    public int getAddressListSize() {
        waitUntilPageReady();
        return addressLevel.size();
    }

    public void clearName(){
        waitUntilPageReady();
        waitUntilVisible(inputName);
        this.inputName.clear();
    }

    public void clearPhone(){
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        waitUntilPageReady();
        waitUntilVisible(inputPhone);
        this.inputPhone.clear();
    }


    public void selectTree(){
        if(selectTree.size() > 0){
            WebElement random_element = selectTree.get(new Random().nextInt(selectTree.size()));
            waitUntilVisible(random_element);
            random_element.click();
        }
    }

    public void setLocationTree2(){
        waitUntilPageReady();
        waitUntilVisible(locationTree2);
        this.locationTree2.click();
    }

    public void setLocationTree3(){
        waitUntilPageReady();
        waitUntilVisible(locationTree3);
        this.locationTree3.click();
    }

    public void inputAddress(String address){
        waitUntilPageReady();
        waitUntilVisible(inputAddress);
        this.inputAddress.sendKeys(address);
    }

    public void clickSaveBtn(){
        waitUntilPageReady();
        waitUntilVisible(clickSavebtn);
        this.clickSavebtn.click();
        waitUntilInvisibilityOf(By.cssSelector(".mod-address-form-btn"));
    }

    public boolean hasAddress() {
        waitUntilVisible(hasAddress);
        return this.hasAddress.isDisplayed();
    }

    public String hasNewNameDrz() {
        waitUntilVisible(hasNewNameDrz);
        return hasNewNameDrz.getText();
    }

    public String hasNewNameLzd() {
        waitUntilVisible(hasNewNameLzd);
        return hasNewNameLzd.getText();
    }

    public void setDetailAddress(String da){
        waitUntilVisible(detailAddress);
        this.detailAddress.sendKeys(da);
    }

    public void createFastNewAddress(String phone, String detailAddress){
        waitUntilVisible(inputPhone);
        this.inputPhone.sendKeys(phone);
        waitUntilVisible(locationTree1);
        waitUntilClickable(By.cssSelector(".mod-select-location-tree-1"));
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        this.locationTree1.click();
        selectTree();
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        waitUntilClickable(By.cssSelector(".mod-select-location-tree-2"));
        this.locationTree2.click();
        waitUntilVisibility(By.cssSelector(".next-menu-content > li"));
        selectTree();
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        waitUntilClickable(By.cssSelector(".mod-select-location-tree-3"));
        this.locationTree3.click();
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        waitUntilVisibility(By.cssSelector(".next-menu-content > li"));
        selectTree();
        this.inputAddress.sendKeys(detailAddress);
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        waitUntilClickable(By.cssSelector(".mod-address-form-btn"));
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        this.clickSavebtn.click();
        waitUntilInvisibilityOf(By.cssSelector(".mod-address-form-btn"));
    }
}