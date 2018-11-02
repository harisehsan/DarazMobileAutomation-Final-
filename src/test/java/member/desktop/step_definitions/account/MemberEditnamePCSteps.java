package member.desktop.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.Global;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Member_AccEdit_PC_Page;

public class MemberEditnamePCSteps extends BaseSteps {

    @And("^I go to edit profile page and edit name info")
    public void accessEditName() throws Throwable{
        String name_edit = Global.config.getString("member.account.name_edit");
        visit(Member_AccEdit_PC_Page.class);
        on(Member_AccEdit_PC_Page.class).clearOldName();
        on(Member_AccEdit_PC_Page.class).editName(name_edit);
    }

    @And("^I click on savechanges button")
    public void saveChanges() throws Throwable{
        on(Member_AccEdit_PC_Page.class).saveChangesBtn();
    }


    @Then("^I go back account page with new name")
    public void hasName() throws Throwable {
        visit(Account_Page.class);
        on(Account_Page.class).hasName((String) Global.map.get("email_random"));
    }

}
