package pages.desktop.address;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

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


    public void setAddNewAddress(){
        waitUntilPageReady();
        this.addNewAddress.click();
    }

    public void setInputName(String name){
        waitUntilPageReady();
        this.inputName.sendKeys(name);
    }

    public void setInputPhone(String ph){
        waitUntilPageReady();
        this.inputPhone.sendKeys(ph);
    }

    public void setLocationTree1(){
        waitUntilPageReady();
        this.locationTree1.click();

    }

    public void setSelectTree(){
        if(selectTree1.size() > 0){
            WebElement random_element = selectTree1.get(new Random().nextInt(selectTree1.size()));
            random_element.click();
            waitUntilVisible(random_element);
        }
    }


    public void setLocationTree2(){
        waitUntilPageReady();
        this.locationTree2.click();
    }

    public void setLocationTree3(){
        waitUntilPageReady();
        this.locationTree3.click();
    }

    public void setInputAddress(String add){
        waitUntilPageReady();
        this.inputAddress.sendKeys(add);
    }

    public void setClickSavebtn(){
        waitUntilPageReady();
        this.clickSavebtn.click();
    }

    public boolean sethasAddress() {
        waitUntilVisible(hasAddress);
        return this.hasAddress.isDisplayed();
    }

}
