package member.desktop.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Global;
import helper.RandomHelper;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Member_AccEdit_PC_Page;
import org.testng.Assert;


public class MemberChangeAccountInfoSteps extends BaseSteps {
    @When("^I go to personal profile page to edit profile info")
    public void goToPersonalProfilePagetoeditinfo() throws Throwable {
        visit(Member_AccEdit_PC_Page.class);
    }

    @And("^I change date of birth$")
    public void iChangeDateOfBirth() throws InterruptedException {
       String current_month = on(Member_AccEdit_PC_Page.class).changeMonth();
       String current_day = on(Member_AccEdit_PC_Page.class).changeDay();
       String current_year = on(Member_AccEdit_PC_Page.class).changeYear();
       Global.map.put("current_date_of_birth",current_year+"-"+current_month+"-"+current_day);

    }

    @And("^I change the gender$")
    public void iChangeTheGender() throws InterruptedException {
        String current_gender = on(Member_AccEdit_PC_Page.class).changeGender();
        Global.map.put("current_gender",current_gender);
    }

    @And("^I change the tax code$")
    public void  iChangeTheTaxCode() {
         on(Member_AccEdit_PC_Page.class).clearOldTaxId();
         String edittaxnumber = on(Member_AccEdit_PC_Page.class).changeTaxCode(RandomHelper.randomAlphaNumericString(6));
         Global.map.put("edit_tax_number",edittaxnumber);
    }

    @And("^I change the branch id$")
    public void iChangeTheBranchId() {
        on(Member_AccEdit_PC_Page.class).clearBranchId();
        String editbranchid = on(Member_AccEdit_PC_Page.class).changeBranchId(RandomHelper.randomAlphaNumericString(6));
        Global.map.put("edit_branch_id",editbranchid);
    }

    @Then("^I should see new info on personal profile page$")
    public void iShouldSeeNewInfoOnPersonalProfilePage() {
        String currentGender = on(Account_Page.class).hasGender();
        String currentDateOfBirth = on(Account_Page.class).hasDateOfBirth();
        String currentTaxCode = on(Account_Page.class).hasTaxCode();
        String currentBranchId = on(Account_Page.class).hasBranchId();
        String expectDateOfBirth = (String) Global.map.get("current_date_of_birth");
        String expectGender = (String) Global.map.get("current_gender");
        String expectTaxCode  = (String) Global.map.get("edit_tax_number");
        String expectBranchId = (String) Global.map.get("edit_branch_id");
        Assert.assertEquals(currentDateOfBirth,expectDateOfBirth,"Checking the date of birth should be updated after changing the user info");
        Assert.assertEquals(currentGender,expectGender,"Checking the gender should be updated after changing the user info");
        Assert.assertEquals(currentTaxCode,expectTaxCode,"Checking the tax code should be updated after changing the user info");
        Assert.assertEquals(currentBranchId,expectBranchId,"Checking the branch ID should be updated after changing the user info");
    }
}
