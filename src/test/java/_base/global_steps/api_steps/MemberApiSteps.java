package _base.global_steps.api_steps;

import base.BaseSteps;
import cucumber.api.java.en.And;
import global.Global;
import helper.RandomHelper;
import member.desktop.pages.account.*;

public class MemberApiSteps extends BaseSteps {

    private static String commonEmail = Global.getConfig().getString("member.account.mail");
    private static String commonPhone = Global.getConfig().getString("member.registered_phone");
    private static String commonPass = Global.getConfig().getString("member.account.pass");
    private static String checkoutEmail = Global.getConfig().getString("checkout.checkoutAccount.mail");
    private static String checkoutPass = Global.getConfig().getString("checkout.checkoutAccount.pass");

    @And("^I login by api with email$")
    public void loginApiByEmail(){
        visit(Login_Page.class);
        on(Login_Page.class).loginApi(commonEmail,commonPass);
        Global.getMap().put("current_mail",commonEmail);
        Global.getMap().put("current_pass",commonPass);
        Global.getBrowser().refresh();
    }

    @And ("^I login by api with email for checkout$")
    public void loginApiByEmailForCheckout(){
        visit(Login_Page.class);
        on(Login_Page.class).loginApi(checkoutEmail,checkoutPass);
        Global.getMap().put("current_mail",checkoutEmail);
        Global.getMap().put("current_pass",checkoutPass);
        Global.getBrowser().refresh();
    }

    @And("^I login by api with phone$")
    public void loginApiByPhone(){
        visit(Login_Page.class);
        on(Login_Page.class).loginApi(commonPhone,commonPass);
        Global.getBrowser().refresh();
    }

    @And("^I sign up by api with email")
    public void signUpEmailByApi(){
        visit(SignUp_Page.class);
        String signupEmail = RandomHelper.randomTestMail();
        on(SignUp_Page.class).signUpApi(signupEmail,commonPass);
        Global.getMap().put("current_mail",signupEmail);
        Global.getMap().put("current_pass",commonPass);
        Global.getBrowser().refresh();
    }

    @And("^I create a new member address by api")
    public void createAddressByApi(){
        visit(Account_Page.class);
        String mobilephoneTemplate = Global.getConfig().getString("member.phone_number_template");
        String addressPhone = RandomHelper.randomPhoneNumber(mobilephoneTemplate);
        String addressName = Global.getConfig().getString("member.account.name");
        on(Account_Page.class).createAddressByApi(Global.getConfig().getConfig("member.address"),addressPhone,addressName);
        Global.getBrowser().refresh();
    }

    @And("^I delete address by api")
    public void deleteAddressByApi() {
        String addressId = on(Account_Page.class).getSecondAddressID();
        on(Account_Page.class).deleteAddressByApi(addressId);
    }
}