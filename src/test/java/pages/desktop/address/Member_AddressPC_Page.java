package pages.desktop.address;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class Member_AddressPC_Page extends PageObject {

    public static String page_url = Global.config.getString("member.url") + "/address";

    @FindBy(css = ".next-btn-large") private WebElement addNewAddress;
    @FindBy(css = ".mod-input-name input") private WebElement inputName;
    @FindBy(css = ".mod-input-phone input") private WebElement inputPhone;
    @FindBy(css = ".mod-select-location-tree-1") private WebElement locationTree1;
    @FindBy(id = "R5996473") private WebElement tree1;
    @FindBy(css = ".mod-select-location-tree-2") private WebElement locationTree2;
    @FindBy(id = "R80302242") private WebElement tree2;
    @FindBy(css = ".mod-select-location-tree-3") private WebElement locationTree3;
    @FindBy(id = "R5996579") private WebElement tree3;
    @FindBy(css = ".mod-input-detailAddress input") private WebElement inputAddress;
    @FindBy(css =".mod-address-form-btn") private WebElement clickSavebtn;

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
        this.tree1.click();

    }

    public void setLocationTree2(){
        waitUntilPageReady();
        this.locationTree2.click();
        this.tree2.click();
    }

    public void setLocationTree3(){
        waitUntilPageReady();
        this.locationTree3.click();
        this.tree3.click();
    }

    public void setInputAddress(String add){
        waitUntilPageReady();
        this.inputAddress.sendKeys(add);
    }

    public void setClickSavebtn(){
        waitUntilPageReady();
        this.clickSavebtn.click();
    }
}
