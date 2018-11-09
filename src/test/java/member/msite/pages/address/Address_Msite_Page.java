package member.msite.pages.address;

import base.PageObject;
import global.Global;
import member.desktop.pages.address.Member_AddressPC_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Random;


public class Address_Msite_Page extends Member_AddressPC_Page {
    public static String page_url = Global.config.getString("member.url") + "/address";

    @FindBy(css = "#container > div > div.mod-tabs > ul > li.mod-tabs-item.active") private WebElement shippingAddd;
    @FindBy(css = "#container > div > div.mod-tabs > ul > li:nth-child(2)") private WebElement billingAdd;
    @FindBy(css = "#container > div > div.address-list > div.address-list-footer > button") private WebElement addnewAddressBtn;
    @FindBy(css = ".mod-input-name input") private WebElement inputName;
    @FindBy(css = ".mod-input-phone input") private WebElement inputPhone;
    @FindBy(css = ".mod-select-location-tree-1") private WebElement locationTree1;
    @FindBy(css = "#container > div > div > div > div.mod-address-form-inputs > div.mod-select.mod-select-location-tree-2") private WebElement locationTree2;
    @FindBy(css = "#container > div > div > div > div.mod-address-form-inputs > div.mod-select.mod-select-location-tree-3") private WebElement locationTree3;
    @FindBy(css = "#container > div > div > div > div.mod-address-form-inputs > div.mod-select.focus.mod-select-location-tree-1 > select > option") private List<WebElement> selectLocation1;
    @FindBy(css = "#container > div > div > div > div.mod-address-form-inputs > div.mod-select.focus.mod-select-location-tree-2 > select > option") private List<WebElement> selectLocation2;
    @FindBy(css = "#container > div > div > div > div.mod-address-form-inputs > div.mod-select.focus.mod-select-location-tree-3 > select > option") private List<WebElement> selectLocation3;
    @FindBy(css = ".mod-input-detailAddress input") private WebElement addDetail;
    @FindBy(className = "mod-radio") private WebElement shippingDefault;
    @FindBy(css = ".mod-address-form-yatra-btn") private WebElement saveAddressBtn;

    public void clickNewAddress() {
        waitUntilPageReady();
        waitUntilVisible(addnewAddressBtn);
        this.addnewAddressBtn.click();
    }

    public void selectTree(List<WebElement> selectTree) {
        if(selectTree.size() > 0 ) {
            WebElement select_random  = selectTree.get(new Random().nextInt(selectTree.size()));
            waitUntilVisible(select_random);
            select_random.click();
        }
    }


    public void setLocation1() {
        waitUntilPageReady();
        waitUntilVisible(locationTree1);
        this.locationTree1.click();
        selectTree(selectLocation1);
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
    }

    public void setLocation2() {
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("#container > div > div > div > div.mod-address-form-inputs > div.mod-select.mod-select-location-tree-2"));
        this.locationTree2.click();
        selectTree(selectLocation2);
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
    }

    public void setLocation3() {
        waitUntilPageReady();
        waitUntilClickable(By.cssSelector("#container > div > div > div > div.mod-address-form-inputs > div.mod-select.mod-select-location-tree-3"));
        this.locationTree3.click();
        selectTree(selectLocation3);
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));

    }



    public void inputAddressDetail(String addName, String addPhone, String addressDetail) {
        waitUntilPageReady();
        waitUntilVisible(addDetail);
        this.inputName.sendKeys(addName);
        this.inputPhone.sendKeys(addPhone);
        setLocation1();
        waitUntilVisible(locationTree2);
        setLocation2();
        waitUntilVisible(locationTree3);
        setLocation3();
        this.addDetail.sendKeys(addressDetail);
    }

    public void clickSaveBtn(){
        waitUntilPageReady();
        waitUntilVisible(saveAddressBtn);
        this.saveAddressBtn.click();
    }


}
