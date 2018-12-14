package member.msite.step_definitions.address;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import helper.RandomHelper;
import member.msite.pages.address.*;
import org.testng.Assert;

public class AddressMsiteSteps extends BaseSteps {

    @And("^I access to address page")
    public void accessAdress() throws Throwable {
        visit(Address_Msite_Page.class);
    }

    @And("I input content of (.*?)$")
    public void inputAddress(String address) throws Throwable {
        String name = Global.config.getString("member.account.name");
        String mobilephoneTemplate = Global.config.getString("member.phone_number_template");
        String phone = RandomHelper.randomPhoneNumber(mobilephoneTemplate);
        String address_detail = "123 " +  RandomHelper.randomAlphabetString(5);
        Global.map.put("address_detail", address_detail);
        String address_delete = "456 " + RandomHelper.randomAlphabetString(5);
        Global.map.put("address_delete", address_delete);
        visit(Address_Msite_Page.class);
        Global.browser.refresh();
        on(Address_Msite_Page.class).clickNewAddress();
        on(Address_Msite_Page.class).inputAddressDetail(name,phone);
        switch (address) {
            case "address_detail":
                String addressDetail = (String) Global.map.get("address_detail");
                on(Address_Msite_Page.class).inputAddressContent(addressDetail);
                break;
            case "address_delete":
                String addressDelete = (String) Global.map.get("address_delete");
                on(Address_Msite_Page.class).inputAddressContent(addressDelete);
                break;
        }
    }

    @And("^I click save address button")
    public void clickSaveBtn() throws Throwable {
        on(Address_Msite_Page.class).clickSaveBtn();
    }

    @When("^I go to edit address information")
    public void editAddressInformation() throws Throwable {
        String new_name = RandomHelper.randomAlphabetString(6);
        Global.map.put("edit_address_name",new_name);
        String mobilephoneTemplate = Global.config.getString("member.phone_number_template");
        String new_phone = RandomHelper.randomPhoneNumber(mobilephoneTemplate);
        Global.map.put("edit_address_phone",new_phone);
        on(Address_Msite_Page.class).editAddressInformation(new_name,new_phone);
    }

    @And("^I delete address on address book")
    public void deleteAddress() throws Throwable {
        Global.browser.refresh();
        on(Address_Msite_Page.class).deleteAddressProgress();
    }

    @Then("^On Msite I should see the new address name")
    public void hasNewAddressName() throws Throwable {
        String expectAddressName = (String) Global.map.get("edit_address_name");
        String actualAddressName = (on(Address_Msite_Page.class).hasNewAddressName());
        Assert.assertEquals(actualAddressName, expectAddressName, "Checking the current address name after should be same with address name edited");
    }

    @Then("^I should see one address on address page$")
    public void existAddress() throws Throwable {
        Global.browser.refresh();
        Assert.assertTrue(on(Address_Msite_Page.class).hasAddress(), "Checking the address book should have at least one address");
    }
}