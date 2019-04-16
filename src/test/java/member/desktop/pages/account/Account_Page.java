package member.desktop.pages.account;

import allure.AllureAttachment;
import com.google.gson.JsonObject;
import com.typesafe.config.Config;
import global.Global;
import helper.XhrHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

import java.util.Base64;

/**
 * Created by admin.son.ton on 1/25/18.
 */

public class Account_Page extends PageObject {

    public static String page_url = Global.getConfig().getString("member.url") + "/user/profile";
    private static String create_address_api_url = Global.getConfig().getString("member.url")+"/address/api/createAddress";
    private static String getIpAddress_api_url = Global.getConfig().getString("member.url") + "/address/api/listAddress";
    private static String deleteAddress_api_url = Global.getConfig().getString("member.url") + "/address/api/deleteAddress";

    @FindBy(css = "div.breadcrumb > a") private WebElement mainContainer_lbl;
    @FindBy(id = "lzd_current_logon_user_name") private WebElement nameOfUser_lbl;
    @FindBy(id = "myAccountTrigger") private WebElement myAccoutTrigger_btn;
    @FindBy(css = ".account-icon.logout") private WebElement logOut_btn;
    @FindBy(id = "lzd_current_logon_user_isVerified") private WebElement isVerified_lbl;
    @FindBy(css = "div.dashboard-info-item.last > a") private WebElement newsLetter_btn;
    @FindBy(css = ".next-btn-primary") private WebElement okNewsletterConfig_btn;
    @FindBy(css = "div.dashboard-info > div:nth-child(2)") private WebElement emailInformation_lbl;
    @FindBy(css = "div#container div:nth-child(4) > div") private WebElement dateOfBirth_lbl;
    @FindBy(css = "div#container div:nth-child(5) > div") private WebElement gender_lbl;
    @FindBy(css = "div#container div:nth-child(6) > div") private WebElement taxcode_lbl;
    @FindBy(css = "div#container div:nth-child(7) > div") private WebElement branchid_lbl;
    @FindBy (css = "div#container button[type='a']") private WebElement editProfile_btn;

    private By isVerified_lbl_by = By.cssSelector("div.dashboard-info-item.last > a");
    private By okNewsletterConfig_btn_by = By.cssSelector(".next-btn-primary");
    private By myAccoutTrigger_btn_by = By.id("myAccountTrigger");
    private By logOut_btn_by = By.cssSelector(".account-icon.logout");

    public void untilLoaded(){
        waitUntilVisible(editProfile_btn);
    }

    public String hasName() {
        waitUntilPageReady();
        waitUntilVisible(nameOfUser_lbl);
        return nameOfUser_lbl.getText();
    }

    public String hasEmail() {
        waitUntilPageReady();
        waitUntilVisible(emailInformation_lbl);
        return emailInformation_lbl.getText();
    }

    public String hasDateOfBirth() { //This method return the DOB value on personal profile page
        waitUntilPageReady();
        untilLoaded();
        waitUntilVisible(dateOfBirth_lbl);
        return dateOfBirth_lbl.getText();
    }

    public String hasGender() { //This method return the gender value on personal profile page
        waitUntilPageReady();
        untilLoaded();
        waitUntilVisible(gender_lbl);
        return gender_lbl.getText();
    }

    public String hasTaxCode() //This method return the tax code value on personal profile page (if available)
    {
        if (page_url.contains(".th") || page_url.contains(".vn"))
        {
            waitUntilPageReady();
            waitUntilVisible(taxcode_lbl);
            return taxcode_lbl.getText();
        }
        return "";
    }

    public String hasBranchId() //This method return the branch id value on personal profile page (if available)
    {
        if (page_url.contains(".th"))
        {
            waitUntilPageReady();
            waitUntilVisible(branchid_lbl);
            return branchid_lbl.getText();
        }
        return "";
    }

    public boolean isVerified() {
        waitUntilVisible(isVerified_lbl);
        return this.isVerified_lbl.isDisplayed();
    }

    public boolean isEmail() {
        waitUntilPageReady();
        waitUntilVisible(emailInformation_lbl);
        return emailInformation_lbl.isDisplayed();
    }

    public void setNewsLetter() {
        waitUntilPageReady();
        waitUntilClickable(isVerified_lbl_by);
        this.newsLetter_btn.click();
        waitUntilClickable(okNewsletterConfig_btn_by);
        this.okNewsletterConfig_btn.click();
        waitUntilInvisibilityOf(okNewsletterConfig_btn_by);
    }

    public String hasNewsLetter() {
        waitUntilPageReady();
        waitUntilVisible(newsLetter_btn);
        return newsLetter_btn.getText();
    }

    public void logOut() {
        waitUntilPageReady();
        waitUntilClickable(myAccoutTrigger_btn_by);
        this.myAccoutTrigger_btn.click();
        waitUntilClickable(logOut_btn_by);
        this.logOut_btn.click();
    }

    public void allureMailUrlPass(String pass) {
        AllureAttachment.attachURL(page_url);
        AllureAttachment.attachComment("Email", emailInformation_lbl.getText());
        AllureAttachment.attachComment("Password", Base64.getEncoder().encodeToString(pass.getBytes()));
    }

    public void allureUrl() {
        AllureAttachment.attachURL(page_url);
    }

    public void allureNameAfterChanging(String oldName, String newName) {
        AllureAttachment.attachURL(page_url);
        AllureAttachment.attachComment("Old name", oldName);
        AllureAttachment.attachComment("Current name", newName);
    }

    public void allureMobilePhone(String mobile) {
        AllureAttachment.attachComment("Mobile phone", mobile);
    }

    public void allureConfigNewsletter(String beforeConfigure, String afterConfigure) {
        AllureAttachment.attachComment("Before configure Newsletter", beforeConfigure);
        AllureAttachment.attachComment("After configure Newsletter", afterConfigure);
    }

    public void createAddressByApi(Config address,String phone,String name){
        String csrfToken = Global.getBrowser().getCookiesAsMap().get("_tb_token_");
        String locationTreeAddressArray=address.getString("locationTreeAddressArray");
        String locationTreeAddressId=address.getString("locationTreeAddressId");
        String locationTreeAddressName=address.getString("locationTreeAddressName");
        String [] args = {create_address_api_url,name,phone,locationTreeAddressArray,locationTreeAddressId,locationTreeAddressName,csrfToken};
        JsonObject response = XhrHelper.executeXhrRequest("member_create_address.js",args);
        if(!String.valueOf(response.get("success")).equalsIgnoreCase("true")){
            throw new RuntimeException(String.format("Create address fail . Response from server: %s",String.valueOf(response)));
        }
    }

    public String getSecondAddressID() {
        String csrfToken = Global.getBrowser().getCookiesAsMap().get("_tb_token_");
        String[] args = {getIpAddress_api_url, csrfToken};
        JsonObject response = XhrHelper.executeXhrRequest("member_getList_address.js", args);
        if (!String.valueOf(response.get("success")).equalsIgnoreCase("true")) {
            throw new RuntimeException(String.format("Get list address fail . Response from server: %s", String.valueOf(response)));
        }
        String address_id = response.getAsJsonArray("module").get(1).getAsJsonObject().getAsJsonPrimitive("id").getAsString();
        return address_id;
    }

    public void deleteAddressByApi(String addressId) {
        String csrfToken = Global.getBrowser().getCookiesAsMap().get("_tb_token_");
        String[] args = {deleteAddress_api_url, csrfToken, addressId};
        JsonObject response = XhrHelper.executeXhrRequest("member_delete_address.js", args);
        if (!String.valueOf(response.get("success")).equalsIgnoreCase("true")) {
            throw new RuntimeException(String.format("Delete address fail . Response from server: %s", String.valueOf(response)));
        }
    }
}
