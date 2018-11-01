package step_definitions.desktop.account;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import global.Global;
import pages.desktop.account.Account_Page;
import pages.desktop.account.Member_AccEdit_PC_Page;
import step_definitions.BaseSteps;

public class MemberEditnamePCSteps extends BaseSteps {

    @And("^I go to edit profile page and edit name info")
    public void accessEditName() throws Throwable{
        String nameedit = Global.config.getString("member.account.nameedit");
        visit(Member_AccEdit_PC_Page.class);
        on(Member_AccEdit_PC_Page.class).clearOldName();
        on(Member_AccEdit_PC_Page.class).editName(nameedit);
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
