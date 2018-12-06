package member.msite.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import helper.RandomHelper;
import member.msite.pages.account.Member_AccountSetting_Msite_Page;
import member.msite.pages.account.Member_ChangePass_Msite_Page;

public class MemberChangePassMsiteSteps extends BaseSteps {

    @And("^I click to change password button")
    public void clickChangePassBtn() throws Throwable {
        on(Member_AccountSetting_Msite_Page.class).changePassWord();
    }

    @And("^I input all information to change pass")
    public void changePassProcess() throws Throwable {
        String old_pass = Global.config.getString("member.account.pass");
        String changed_pass = RandomHelper.randomAlphaNumericString(6);
        on(Member_ChangePass_Msite_Page.class).setNewPassWord(old_pass,changed_pass);
        on(Member_ChangePass_Msite_Page.class).saveButton();
        on(Member_ChangePass_Msite_Page.class).gotItButton();
    }
}