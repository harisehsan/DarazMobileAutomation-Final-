package member.desktop.step_definitions.account;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Member_AccEdit_PC_Page;
import base.BaseSteps;

public class MemberEditnamePCSteps extends BaseSteps {

    @And("^I go to edit profile page and edit name info")
    public void accessEditName() throws Throwable{
        visit(Member_AccEdit_PC_Page.class);
        on(Member_AccEdit_PC_Page.class).setClearOldname();
        on(Member_AccEdit_PC_Page.class).setEditName("QA editing name by Auto");
    }

    @And("^I click on savechanges button")
    public void saveChanges() throws Throwable{
        on(Member_AccEdit_PC_Page.class).setSaveChangesbtn();
    }


    @Then("^I go back account page with new name")
    public void hasName() throws Throwable {
        visit(Account_Page.class);
        on(Account_Page.class).hasName("QA editing name by Auto");
    }

}
