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
    @FindBy(css = ".next-menu-content > li") private List<WebElement> selectTree1;
    @FindBy(css = ".mod-select-location-tree-2") private WebElement locationTree2;
    @FindBy(css = ".mod-select-location-tree-3") private WebElement locationTree3;
    @FindBy(css = ".mod-input-detailAddress input") private WebElement inputAddress;
    @FindBy(css =".mod-address-form-btn") private WebElement clickSavebtn;
    @FindBy(className = "mod-address-book-default") private WebElement hasAddress;
    @FindBy(css = ".mod-input-detailAddress input") private WebElement detailAddress;
    @FindBy(css= ".next-table-cell") private WebElement editaddress;
    @FindBy(className = "next-table-cell-wrapper") private WebElement hasNewName;

    public void addNewAddress(){
        waitUntilPageReady();
        waitUntilVisible(addNewAddress);
        this.addNewAddress.click();
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

    public void setEditaddress(){
        waitUntilPageReady();
        waitUntilVisible(editaddress);
        this.editaddress.click();
    }

    public void clearName(){
        waitUntilVisible(inputName);
        this.inputName.clear();
    }

    public void clearPhone(){
        waitUntilVisible(inputPhone);
        this.inputPhone.clear();
    }


    public void selectTree(){
        if(selectTree1.size() > 0){
            WebElement random_element = selectTree1.get(new Random().nextInt(selectTree1.size()));
            waitUntilVisible(random_element);
            random_element.click();
            waitUntilInvisibilityOf(By.id("__react_loading_show__"));
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
    }

    public boolean hasAddress() {
        waitUntilVisible(hasAddress);
        return this.hasAddress.isDisplayed();
    }

    public boolean hasNewName(String newName) {
        waitUntilVisible(hasNewName);
        return this.hasNewName.getText().equals(newName);
    }

    public void setDetailAddress(String da){
        waitUntilVisible(detailAddress);
        this.detailAddress.sendKeys(da);
    }

}
