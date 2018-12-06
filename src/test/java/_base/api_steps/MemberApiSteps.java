package _base.api_steps;

import base.BaseSteps;
import cucumber.api.java.en.And;
import global.Global;
import helper.RandomeHelper;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Login_Page;
import member.desktop.pages.account.SignUp_Page;

public class MemberApiSteps extends BaseSteps {

    private static String commonEmail = Global.config.getString("member.account.mail");
    private static String commonPhone = Global.config.getString("member.phone_number_login");
    private static String commonPass = Global.config.getString("member.account.pass");


    @And("^I login by api with email$")
    public void loginApiByEmail(){
        visit(Login_Page.class);
        on(Login_Page.class).loginApi(commonEmail,commonPass);
        Global.browser.refresh();
    }

    @And("^I login by api with phone$")
    public void loginApiByPhone(){
        visit(Login_Page.class);
        on(Login_Page.class).loginApi(commonPhone,commonPass);
        Global.browser.refresh();
    }

    @And("^I sign up by api with email")
    public void signUpEmailByApi(){
        visit(SignUp_Page.class);
        String signupEmail = "LAZADATEST_1111_" + RandomeHelper.generateEmail()+ "@MAILINATOR.com";
        on(SignUp_Page.class).signUpApi(signupEmail,commonPass);
        Global.map.put("current_email",signupEmail);
        Global.browser.refresh();
    }

    @And("^I create a new member address by api")
    public void createAddressByApi(){
        visit(Account_Page.class);
        String addressPhone = Global.config.getString("member.phone_number_signup") + RandomeHelper.generatePhoneNumber();
        String addressName = Global.config.getString("member.account.name");
        on(Account_Page.class).createAddressByApi(Global.config.getConfig("member.address"),addressPhone,addressName);
        Global.browser.refresh();
    }
}