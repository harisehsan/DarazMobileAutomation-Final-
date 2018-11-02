package member.desktop.step_definitions.address;

import cucumber.api.java.en.*;
import global.Global;
import member.desktop.pages.address.Member_AddressPC_Page;
import base.BaseSteps;

public class MemberAddressPCSteps extends BaseSteps {

    @And("^I open add new address page and input name info")
    public void inputName() throws Throwable{
        String name = Global.config.getString("member.account.name");
        visit(Member_AddressPC_Page.class);
        on(Member_AddressPC_Page.class).addNewAddress();
        on(Member_AddressPC_Page.class).inputName(name);

    }

    @And("^I input the mobile phone number")
    public void inputPhone() throws Throwable{
        String mobile = Global.config.getString("member.phone_number_login");
        on(Member_AddressPC_Page.class).inputPhone(mobile);

    }

    @And("^I select the location 1")
    public void selectLocation1() throws Throwable{
        on(Member_AddressPC_Page.class).setLocationTree1();
        on(Member_AddressPC_Page.class).selectTree();
    }

    @And("^I input the location 2")
    public void selectLocation2() throws Throwable{
        on(Member_AddressPC_Page.class).setLocationTree2();
        on(Member_AddressPC_Page.class).selectTree();

    }

    @And("^I input the location 3")
    public void selectLocation3() throws Throwable{
        on(Member_AddressPC_Page.class).setLocationTree3();
        on(Member_AddressPC_Page.class).selectTree();

    }

    @And("^I input address detail")
    public void inputAddress() throws Throwable{
        String addressdetail = Global.config.getString("member.account.address_detail");
        on(Member_AddressPC_Page.class).inputAddress(addressdetail);

    }

    @And("^I click on save button")
    public void clickSave() throws Throwable{
        on(Member_AddressPC_Page.class).clickSaveBtn();
    }

    @And("^I input floor/unit number address detail")
    public void inputfloor() throws Throwable{
        String address_detail = Global.config.getString("member.account.address_detail");
        on(Member_AddressPC_Page.class).setDetailAddress(address_detail);
    }

    @And("^I open add new address page and create new address")
    public void addNewAddressDaraz() throws Throwable {
        String mobile = Global.config.getString("member.phone_number_login");
        String name = Global.config.getString("member.account.name");
        String address_detail = Global.config.getString("member.account.address_detail");
        visit(Member_AddressPC_Page.class);
        on(Member_AddressPC_Page.class).addNewAddress();
        on(Member_AddressPC_Page.class).inputName(name);
        on(Member_AddressPC_Page.class).inputPhone(mobile);
        on(Member_AddressPC_Page.class).setLocationTree1();
        on(Member_AddressPC_Page.class).selectTree();
        on(Member_AddressPC_Page.class).setLocationTree2();
        on(Member_AddressPC_Page.class).selectTree();
        on(Member_AddressPC_Page.class).setLocationTree3();
        on(Member_AddressPC_Page.class).selectTree();
        on(Member_AddressPC_Page.class).inputAddress(address_detail);
        on(Member_AddressPC_Page.class).clickSaveBtn();
    }

    @And("^I click edit button on any address")
    public void editButton() throws Throwable {
        on(Member_AddressPC_Page.class).setEditaddress();
    }

    @And("^I edit name, phone number and click save button")
    public void editNamePhone() throws Throwable {
        String name_edit = Global.config.getString("member.account.name_edit");
        String mobile = Global.config.getString("member.phone_number_login");
        on(Member_AddressPC_Page.class).clearName();
        on(Member_AddressPC_Page.class).inputName(name_edit);
        Global.map.put("new_name_address",name_edit);
        on(Member_AddressPC_Page.class).clearPhone();
        on(Member_AddressPC_Page.class).inputPhone(mobile);
        on(Member_AddressPC_Page.class).clickSaveBtn();
    }


    @Then("^I should see the new editing name of address")
    public void hasNewName() throws Throwable {
        on(Member_AddressPC_Page.class).hasNewName((String) Global.map.get("new_name_address"));
    }

    @Then("^I should see the new address on account page")
    public void hasAddressName() throws Throwable{
        on(Member_AddressPC_Page.class).hasAddress();
    }
}
