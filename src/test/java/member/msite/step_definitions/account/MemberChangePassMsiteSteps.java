package member.msite.step_definitions.account;

import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import member.msite.pages.account.Member_AccountSetting_Msite_Page;
import member.msite.pages.account.Member_ChangePass_Msite_Page;

public class MemberChangePassMsiteSteps extends BaseSteps {

    @And("^I click to change password button")
    public void clickChangePassBtn() throws Throwable{
        on(Member_AccountSetting_Msite_Page.class).changePassWord();
    }

//    @And("^I go to change pass page on Msite")
//    public void accessChangePass() throws Throwable {
//        visit(Member_ChangePass_Msite_Page.class);
//    }

    @And("^I input all information to change pass")
    public void changePassProcess() throws Throwable {
        String old_pass = Global.config.getString("member.pass");
        String new_pass = Global.config.getString("member.account.new_pass");
        on(Member_ChangePass_Msite_Page.class).setNewPassWord(old_pass,new_pass);
        on(Member_ChangePass_Msite_Page.class).saveButton();
        on(Member_ChangePass_Msite_Page.class).gotItButton();
    }

//    @And("^I click save password button")
//    public void clickSaveBtn() throws Throwable {
//        on(Member_ChangePass_Msite_Page.class).saveButton();
//    }
//
//    @And("^I click got it button on popup")
//    public void gotItButton() throws Throwable {
//        on(Member_ChangePass_Msite_Page.class).gotItButton();
//    }
}