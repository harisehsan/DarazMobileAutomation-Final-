package member.msite.step_definitions.address;

import base.BaseSteps;
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

    @And("^I input address information")
    public void addNewAddress() throws Throwable {
        String name = Global.config.getString("member.account.name");
        String phone = Global.config.getString("member.phone_number_login");
        String address_detail = Global.config.getString("member.account.address_detail");
        visit(Address_Msite_Page.class);
        on(Address_Msite_Page.class).clickNewAddress();
        on(Address_Msite_Page.class).inputAddressDetail(name,phone,address_detail);
    }

    @And("^I click save address button")
    public void clickSaveBtn() throws Throwable {
        on(Address_Msite_Page.class).clickSaveBtn();
    }

    @Then("^I should see the address on address page")
    public void existAddress() throws Throwable {
        Assert.assertFalse(on(Address_Msite_Page.class).hasAddress(), "Checking the address book should have at least address");
    }
}