package member.desktop.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import helper.RandomeHelper;
import member.desktop.pages.account.*;
import org.testng.Assert;

public class MemberEditnamePCSteps extends BaseSteps {

    @And("^I go to edit profile page and edit name info")
    public void accessEditName() throws Throwable{
        String editNameOfUser = RandomeHelper.generateName();
        Global.map.put("edit_name_of_user",editNameOfUser);
        visit(Member_AccEdit_PC_Page.class);
        on(Member_AccEdit_PC_Page.class).clearOldName();
        on(Member_AccEdit_PC_Page.class).editName((String) Global.map.put("edit_name_of_user",editNameOfUser));
    }

    @And("^I click on save changes button")
    public void saveChanges() throws Throwable{
        on(Member_AccEdit_PC_Page.class).saveChangesBtn();
    }

    @Then("^I go back account page with new name")
    public void hasName() throws Throwable {
        visit(Account_Page.class);
        String currentName = on(Account_Page.class).hasName();
        String expectName = (String) Global.map.get("edit_name_of_user");
        Assert.assertEquals(currentName,expectName,"Checking the edited name should be updated after editing name");
        on(Account_Page.class).allureNameAfterChanging(Global.config.getString("member.account.name"),currentName);
    }
}