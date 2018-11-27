package member.msite.pages.address;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Random;

public class Address_Msite_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/address";

    @FindBy(css = "div.address-list-footer > button") private WebElement addNewAddress_btn;
    @FindBy(css = "div.mod-input-name > input") private WebElement addressName_txtField;
    @FindBy(css = "div.mod-input-phone > input") private WebElement addressPhone_txtField;
    @FindBy(css = "div.mod-select-location-tree-1") private WebElement locationTree1_listBtn;
    @FindBy(css = "div.mod-select.mod-select-location-tree-2") private WebElement locationTree2_listBtn;
    @FindBy(css = "div.mod-select.mod-select-location-tree-3") private WebElement locationTree3_listBtn;
    @FindBy(css = "div.mod-select-location-tree-1 > select > option:nth-child(2)") private List<WebElement> selectLocation1_drpDownList;
    @FindBy(css = "div.mod-select-location-tree-2 > select > option:nth-child(2)") private List<WebElement> selectLocation2_drpDownList;
    @FindBy(css = "div.mod-select-location-tree-3 > select > option:nth-child(2)") private List<WebElement> selectLocation3_drpDownList;
    @FindBy(css = ".mod-input-detailAddress input") private WebElement addressDetail_txtField;
    @FindBy(css = ".mod-address-form-yatra-btn") private WebElement saveAddress_btn;
    @FindBy(css = ".address-list-body > div") private List<WebElement> address_list;
    @FindBy(css = "div > i.address-list-item-edit") private WebElement editAddress_btn;
    @FindBy(css = "div.mod-input-name > div") private WebElement removeAddressName_btn;
    @FindBy(css = "div.mod-input-phone > div") private WebElement removeAddressPhone_btn;
    @FindBy(css = "div.mod-address-item-user") private WebElement addressNameUser_lbl;

    public void clickNewAddress() {
        waitUntilPageReady();
        waitUntilVisible(addNewAddress_btn);
        this.addNewAddress_btn.click();
    }

    public void selectTree(List<WebElement> selectTree) {
        if(selectTree.size() >= 1 ) {
            WebElement select_random  = selectTree.get(new Random().nextInt(selectTree.size()));
            select_random.click();
        }
    }

    public void inputAddressDetail(String addName, String addPhone) {
        waitUntilPageReady();
        waitUntilVisible(locationTree1_listBtn);
        this.addressName_txtField.sendKeys(addName);
        this.addressPhone_txtField.sendKeys(addPhone);
        waitUntilClickable(By.cssSelector(".mod-select-location-tree-1"));
        this.locationTree1_listBtn.click();
        selectTree(selectLocation1_drpDownList);
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        this.locationTree2_listBtn.click();
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        selectTree(selectLocation2_drpDownList);
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        this.locationTree3_listBtn.click();
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        selectTree(selectLocation3_drpDownList);
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
    }

    public void inputAddressContent(String address) {
        waitUntilVisible(addressDetail_txtField);
        this.addressDetail_txtField.sendKeys(address);
    }

    public void clickSaveBtn() {
        waitUntilPageReady();
        waitUntilVisible(saveAddress_btn);
        this.saveAddress_btn.click();
    }

    public void editAddressInformation(String name, String phone) {
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("div > i.address-list-item-edit"));
        this.editAddress_btn.click();
        waitUntilClickable(By.cssSelector("div.mod-input-name > div"));
        this.removeAddressName_btn.click();
        this.removeAddressPhone_btn.click();
        this.addressName_txtField.sendKeys(name);
        this.addressPhone_txtField.sendKeys(phone);
        this.saveAddress_btn.click();
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
    }

    public String hasNewAddressName(){
        waitUntilPageReady();
        waitUntilVisible(addressNameUser_lbl);
        return addressNameUser_lbl.getText();
    }

    public boolean hasAddress() {
        waitUntilPageReady();
        return this.address_list.size() >= 1;
    }

}