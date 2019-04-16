package member.msite.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import member.msite.pages.account.Member_Account_Msite_Page;
import member.msite.pages.account.Member_ChangeEmail_Msite_Page;
import org.testng.Assert;

public class MemberChangeEmailMsiteSteps extends BaseSteps {

    @When("^I go to account info page")
    public void goToAccountInfoPage() throws Throwable {
        on(Member_Account_Msite_Page.class).goToAccountInfo();
        on(Member_ChangeEmail_Msite_Page.class).allureReportCurrentMail((String)Global.getMap().get("current_mail"));
    }

    @And("^On Msite I change email by email verification code")
    public void sendCodetoBeforeChangingMail() throws Throwable {
        on(Member_ChangeEmail_Msite_Page.class).clickChangeEmail();
    }

    @Then("^I should see the new mail on account info page")
    public void isNewEmailOnAccountInfoPage() throws Throwable {
        Assert.assertTrue(on(Member_ChangeEmail_Msite_Page.class).hasNewEmail((String)Global.getMap().get("current_mail")), "Checking new email should be display on account information page");
        on(Member_ChangeEmail_Msite_Page.class).allureReportCurrentMail((String)Global.getMap().get("current_mail"));
    }
}