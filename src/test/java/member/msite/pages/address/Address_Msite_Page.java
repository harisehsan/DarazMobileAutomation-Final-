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

    @FindBy(css = "#container > div > div.mod-tabs > ul > li.mod-tabs-item.active") private WebElement shippingAddd;
    @FindBy(css = "#container > div > div.mod-tabs > ul > li:nth-child(2)") private WebElement billingAdd;
    @FindBy(css = "#container > div > div.address-list > div.address-list-footer > button") private WebElement addNewAddressBtn;
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
    @FindBy(css = ".address-list-body > div") private List<WebElement> addressList;

    public void clickNewAddress() {
        waitUntilPageReady();
        waitUntilVisible(addNewAddressBtn);
        this.addNewAddressBtn.click();
    }

    public void selectTree(List<WebElement> selectTree) {
        if(selectTree.size() > 0 ) {
            WebElement select_random  = selectTree.get(new Random().nextInt(selectTree.size()));
            waitUntilVisible(select_random);
            select_random.click();
        }
    }

    public void inputAddressDetail(String addName, String addPhone, String addressDetail) {
        waitUntilPageReady();
        waitUntilVisible(locationTree1);
        this.inputName.sendKeys(addName);
        this.inputPhone.sendKeys(addPhone);
        waitUntilClickable(By.cssSelector(".mod-select-location-tree-1"));
        this.locationTree1.click();
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        selectTree(selectLocation1);
        waitUntilClickable(By.cssSelector("#container > div > div > div > div.mod-address-form-inputs > div.mod-select.mod-select-location-tree-2"));
        this.locationTree2.click();
        selectTree(selectLocation2);
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        this.locationTree3.click();
        selectTree(selectLocation3);
        waitUntilInvisibilityOf(By.id("__react_loading_show__"));
        this.addDetail.sendKeys(addressDetail);
    }

    public void clickSaveBtn() {
        waitUntilPageReady();
        waitUntilVisible(saveAddressBtn);
        this.saveAddressBtn.click();
    }

    public boolean hasAddress() {
        waitUntilPageReady();
        return this.addressList.size() >= 1;
    }
}