package step_definitions.desktop.address;

import cucumber.api.java.en.*;
import cucumber.api.java.en_lol.AN;
import global.Global;
import pages.desktop.account.Account_Page;
import pages.desktop.account.Member_AccEdit_PC_Page;
import pages.desktop.address.Member_AddressPC_Page;
import step_definitions.BaseSteps;

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
        String mobile = Global.config.getString("member.phonenumberlogin");
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
        String addressdetail = Global.config.getString("member.account.addressdetail");
        on(Member_AddressPC_Page.class).inputAddress(addressdetail);

    }

    @And("^I click on save button")
    public void clickSave() throws Throwable{
        on(Member_AddressPC_Page.class).clickSaveBtn();
    }


    @Then("^I should see the new address on account page")
    public void hasAddressName() throws Throwable{
        on(Member_AddressPC_Page.class).hasAddress();
    }
}
