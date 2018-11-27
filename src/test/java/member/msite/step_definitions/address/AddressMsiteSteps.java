package member.msite.step_definitions.address;

import base.BaseSteps;
import com.typesafe.config.Config;
import cucumber.api.java.en.*;
import global.Global;
import member.msite.pages.account.*;
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
        String phone = Global.config.getString("member.phone_number_login");
        visit(Address_Msite_Page.class);
        Global.browser.refresh();
        on(Address_Msite_Page.class).clickNewAddress();
        on(Address_Msite_Page.class).inputAddressDetail(name,phone);
        Config memberConfig = Global.config.getConfig("member.account");
        String addressInfo = memberConfig.getString(address);
        on(Address_Msite_Page.class).inputAddressContent(addressInfo);
    }

    @And("^I click save address button")
    public void clickSaveBtn() throws Throwable {
        on(Address_Msite_Page.class).clickSaveBtn();
    }

    @When("^I go to edit address information")
    public void editAddressInformation() throws Throwable {
        String new_name = Global.config.getString("member.account.name_edit");
        String new_phone = Global.config.getString("member.phone_number_login");
        on(Address_Msite_Page.class).editAddressInformation(new_name,new_phone);
        Global.map.put("edit_address_name",new_name);
    }

    @Then("^I should see the new address name on Msite")
    public void hasNewAddressName() throws Throwable {
        String expectAddressName = (String) Global.map.get("edit_address_name");
        String actualAddressName = (on(Address_Msite_Page.class).hasNewAddressName());
        Assert.assertEquals(actualAddressName, expectAddressName, "Checking the current address name after should be same with address name edited");
    }

    @Then("^I should see the address on address page")
    public void existAddress() throws Throwable {
        Assert.assertTrue(on(Address_Msite_Page.class).hasAddress(), "Checking the address book should have at least address");
    }
}