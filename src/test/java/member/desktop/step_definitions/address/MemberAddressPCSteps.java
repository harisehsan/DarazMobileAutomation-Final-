package member.desktop.step_definitions.address;

import cucumber.api.java.en.*;
import global.Global;
import helper.RandomeHelper;
import member.desktop.pages.address.Member_AddressPC_Page;
import base.BaseSteps;
import org.testng.Assert;

public class MemberAddressPCSteps extends BaseSteps {

    @And("^I open add new address page input name info")
    public void inputName() throws Throwable {
        String name = Global.config.getString("member.account.name");
        visit(Member_AddressPC_Page.class);
        on(Member_AddressPC_Page.class).addNewAddress();
        on(Member_AddressPC_Page.class).inputName(name);
    }

    @And("^I input the mobile phone number")
    public void inputPhone() throws Throwable {
        String mobile = Global.config.getString("member.registered_phone");
        on(Member_AddressPC_Page.class).inputPhone(mobile);
    }

    @And("^I select the location 1")
    public void selectLocation1() throws Throwable {
        on(Member_AddressPC_Page.class).setLocationTree1();
        on(Member_AddressPC_Page.class).selectTree();
    }

    @And("^I input the location 2")
    public void selectLocation2() throws Throwable {
        on(Member_AddressPC_Page.class).setLocationTree2();
        on(Member_AddressPC_Page.class).selectTree();

    }

    @And("^I input the location 3")
    public void selectLocation3() throws Throwable {
        on(Member_AddressPC_Page.class).setLocationTree3();
        on(Member_AddressPC_Page.class).selectTree();
    }

    @And("^I input address detail")
    public void inputAddress() throws Throwable {
//        String address_detail = Global.config.getString("member.account.address_detail");
//        String address_detail = "123" + RandomeHelper.generateName();
//        Global.map.put("address_detail", address_detail);
        on(Member_AddressPC_Page.class).inputAddress((String)Global.map.get("address_detail"));
    }

    @And("^I create new address")
    public void createAddress() throws Throwable {
        String mobile = Global.config.getString("member.registered_phone");
//        String address_detail = Global.config.getString("member.account.address_detail");
        String address_detail = "123" + RandomeHelper.generateName();
        Global.map.put("address_detail", address_detail);
        on(Member_AddressPC_Page.class).createFastNewAddress(mobile,(String)Global.map.get("address_detail"));
    }

    @And("^I create an address to delete")
    public void createAddressDelete() throws Throwable {
        String mobile = Global.config.getString("member.registered_phone");
//        String address_delete = Global.config.getString("member.account.address_delete");
        String address_delete = "456" + RandomeHelper.generateName();
        Global.map.put("address_delete", address_delete);
        on(Member_AddressPC_Page.class).createFastNewAddress(mobile, address_delete);
        int beforeDeleting = on(Member_AddressPC_Page.class).getAddressListSize();
        Global.map.put("before_delete",beforeDeleting);
    }

    @And("^I go back the address book page")
    public void goToAddressPage(){
        visit(Member_AddressPC_Page.class);
        int afterDeleting = on(Member_AddressPC_Page.class).getAddressListSize();
        Global.map.put("after_delete",afterDeleting);
    }

    @And("^I access edit page on Daraz to delete address")
    public void accessDeleteAddressDrz() throws Throwable {
        on(Member_AddressPC_Page.class).accessDeleteAddressDrz();
    }

    @And("^I access edit page on Lazada to delete address")
    public void accessDeleteAddressLzd() throws Throwable {
        Global.browser.refresh();
        on(Member_AddressPC_Page.class).accessDeleteAddressLzd();
    }

    @And("^I click on save button")
    public void clickSave() throws Throwable {
        on(Member_AddressPC_Page.class).clickSaveBtn();
    }

    @And("^I input floor/unit number address detail")
    public void inputfloor() throws Throwable {
//        String address_detail = Global.config.getString("member.account.address_detail");
        on(Member_AddressPC_Page.class).setDetailAddress((String)Global.map.get("address_detail"));
    }


    @And("^I click first edit button on any address")
    public void editFiButton() throws Throwable {
        on(Member_AddressPC_Page.class).editAddDrz();
    }

    @And("^I click last edit button on any address")
    public void editButton() throws Throwable {
        on(Member_AddressPC_Page.class).editAddLzd();
    }

    @And("^I edit name, phone number information")
    public void editNamePhone() throws Throwable {
//        String reset_password_mail = Global.config.getString("member.account.name_edit");
        String name_edit = RandomeHelper.generateName();
        String mobile = Global.config.getString("member.registered_phone");
        on(Member_AddressPC_Page.class).clearName();
        on(Member_AddressPC_Page.class).inputName(name_edit);
        Global.map.put("new_name_address", name_edit);
        on(Member_AddressPC_Page.class).clearPhone();
        on(Member_AddressPC_Page.class).inputPhone(mobile);
        on(Member_AddressPC_Page.class).clickSaveBtn();
    }
    @And("^I click delete button")
    public void deleteAddress() throws Throwable {
        on(Member_AddressPC_Page.class).deleteBtn();
    }

    @And("^I create a new address for SG")
    public void createAddressSg() throws Throwable {
        String mobile = Global.config.getString("member.phone_number_login");
        String postCode = Global.config.getString("member.post_code");
//        String addressDetail = "123" + RandomeHelper.generateName();
//        String addressDetail = Global.config.getString("member.account.address_detail");
        on(Member_AddressPC_Page.class).createAddressSg(mobile, postCode, (String)Global.map.get("address_detail"));
    }

    @Then("^I should see on Daraz the new editing name of address")
    public void hasNewNameDrz() throws Throwable {
        String editingName = (String) Global.map.get("new_name_address");
        String nameOnAddress = on(Member_AddressPC_Page.class).hasNewNameDrz();
        Assert.assertEquals(editingName,nameOnAddress,"Checking the edited name of address should be updated after editing name");
    }

    @Then("^I should see on Lazada the new editing name of address")
    public void hasNewNameLzd() throws Throwable {
        String editingName = (String) Global.map.get("new_name_address");
        String nameOnAddress = on(Member_AddressPC_Page.class).hasNewNameLzd();
        Assert.assertEquals(editingName,nameOnAddress,"Checking the edited name of address should be updated after editing name");
    }

    @Then("^I should see the new address on account page")
    public void hasAddressName() throws Throwable {
        Assert.assertTrue(on(Member_AddressPC_Page.class).hasAddress(),"Checking user has no address on address book, after adding new address should be display on address book page");
    }

    @Then("^I should not see address has deleted on page")
    public void hasnoNameDelete() throws Throwable {
        int before = (int) Global.map.get("before_delete");
        int after = (int) Global.map.get("after_delete");
        Assert.assertEquals(before-after,1,"Checking user has 2 addresses on address book, after deleting an address, the address book should display only one address ");
    }

    @Then("^I should delete address successfully")
    public void hasNoAddressDeleted() throws Throwable {
//        Assert.assertTrue(on(Member_AddressPC_Page.class).hasNoAddressDeleted(), "Checking after deleted address the list address will be back 1 address on address book ");
    }
}