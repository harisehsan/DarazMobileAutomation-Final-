package step_definitions.desktop.address;

import cucumber.api.java.en.*;
import global.Global;
import pages.desktop.address.Member_AddressPC_Page;
import step_definitions.BaseSteps;

public class MemberAddressPCSteps extends BaseSteps {

    @And("^I open add new address page and input name info")
    public void inputName() throws Throwable{
        visit(Member_AddressPC_Page.class);
        on(Member_AddressPC_Page.class).setAddNewAddress();
        on(Member_AddressPC_Page.class).setInputName("QA testing adding new address");

    }

    @And("^I input the mobile phone number")
    public void inputPhone() throws Throwable{
        String mobile = Global.config.getString("member.phonenumberlogin");
        on(Member_AddressPC_Page.class).setInputPhone(mobile);

    }

    @And("^I select the location 1")
    public void selectLocation1() throws Throwable{
    }

    @And("^I input the location 2")
    public void selectLocation2() throws Throwable{

    }

    @And("^I input the location 3")
    public void selectLocation3() throws Throwable{

    }

    @And("^I click on save button")
    public void clickSave() throws Throwable{

    }

    @Then("^I should see the new address on account page")
    public void inputAddress() throws Throwable{

    }
}
