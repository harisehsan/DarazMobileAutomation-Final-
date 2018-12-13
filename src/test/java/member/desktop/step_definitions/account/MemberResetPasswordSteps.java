package member.desktop.step_definitions.account;

import allure.AllureAttachment;
import base.BaseSteps;
import cucumber.api.java.en.*;
import global.Global;
import helper.RandomHelper;
import member.desktop.pages.account.*;

public class MemberResetPasswordSteps extends BaseSteps {

    @And("^I click reset password on login page")
    public void clickResetPass() throws Throwable {
        on(Member_Login_Page.class).clickResetPassBtn();
    }

    @And("^I go to forgot password page")
    public void accessResetPass() throws Throwable {
        visit(Member_Forget_Pass_PC_Page.class);
    }

    @And("^I submit email to reset password process")
    public void submitEmail() throws Throwable {
        String emailReset = Global.config.getString("member.reset_password_mail");
        Global.map.put("current_mail",emailReset);
        on(Member_Forget_Pass_PC_Page.class).inputEmail(emailReset);
    }

    @And("^I reset password by email verification code")
    public void sendSmsCodeToEmail()throws Throwable {
        on(Member_Forget_Pass_PC_Page.class).clickVerifyEmailBtn();
        on(Member_VerifyEmail_PC_Page.class).processVerifyEmailBtn();
    }

    @And("^I process reset password on reset password page")
    public void processResetPass() throws Throwable {
        String randomPassword = RandomHelper.randomAlphabetString(5) + RandomHelper.randomNumber(5);
        Global.map.put("current_pass",randomPassword);
        on(Member_Reset_PassWord_Page.class).resetPassword(randomPassword);
        AllureAttachment.attachComment("reset_password", randomPassword);
    }
}