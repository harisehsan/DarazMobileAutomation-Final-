package _base.api_steps;

import base.BaseSteps;
import com.google.gson.JsonObject;
import cucumber.api.java.en.And;
import global.Global;
import helper.RandomeHelper;
import helper.XhrHelper;
import com.typesafe.config.Config;
import io.qameta.allure.Allure;

public class MemberApiSteps extends BaseSteps {

    @And("^I login by api with email and password$")
    public void loginByApi(){
        String csrfToken = Global.browser.getCookiesAsMap().get("_tb_token_");
        String email = Global.config.getString("member.account.mail_test");
        String pass = Global.config.getString("member.pass");
        String apiUrl = Global.config.getString("member.url")+"/user/api/login";
        String [] args = {apiUrl,email,pass,csrfToken};
        JsonObject response = XhrHelper.executeXhrRequest("member_login.js",args);
        if(!String.valueOf(response.get("success")).equalsIgnoreCase("true")){
            throw new RuntimeException(String.format("Login with credential %s/%s fail . Response from server: %s",email,pass,String.valueOf(response)));
        }
        Global.browser.refresh();
    }

    @And("^I login by api with mobile phone and password$")
    public void loginByMobilePhoneApi(){
        String csrfToken = Global.browser.getCookiesAsMap().get("_tb_token_");
        String mobilePhone = Global.config.getString("member.phone_number_login");
        String pass = Global.config.getString("member.pass");
        String apiUrl = Global.config.getString("member.url")+"/user/api/login";
        String [] args = {apiUrl,mobilePhone,pass,csrfToken};
        JsonObject response = XhrHelper.executeXhrRequest("member_login.js",args);
        Allure.addAttachment("Json Response", String.valueOf(response));
        if(!String.valueOf(response.get("success")).equalsIgnoreCase("true")){
            throw new RuntimeException(String.format("Login with credential %s/%s fail . Response from server: %s",mobilePhone,pass,String.valueOf(response)));
        }
        Global.browser.refresh();
    }

    @And("^I login by api with old email and (.*?)$")
    public void loginByApiNewPass(String pass){

        String csrfToken = Global.browser.getCookiesAsMap().get("_tb_token_");
        String emailLogin = (String) Global.map.get("email_random");
        Config memberConfig = Global.config.getConfig("member.account");
        String newPass = memberConfig.getString(pass);
        String apiUrl = Global.config.getString("member.url")+"/user/api/login";
        String [] args = {apiUrl,emailLogin,newPass,csrfToken};
        JsonObject response = XhrHelper.executeXhrRequest("member_login.js",args);
        if(!String.valueOf(response.get("success")).equalsIgnoreCase("true")){
            throw new RuntimeException(String.format("Login with credential %s/%s fail . Response from server: %s",emailLogin,newPass,String.valueOf(response)));
        }
        Global.browser.refresh();
    }

    @And("^I sign up by api")
    public void signUpByApi(){
        String csrfToken = Global.browser.getCookiesAsMap().get("_tb_token_");
        String randomEmail = "LAZADATEST_1111_" + RandomeHelper.generateEmail()+ "@hotmail.com";
        Global.map.put("email_random",randomEmail);
        String pass = Global.config.getString("member.account.pass");
        String name = Global.config.getString("member.account.name");
        String apiUrl = Global.config.getString("member.url")+"/user/api/register";
        String [] args = {apiUrl,randomEmail,pass,name,csrfToken};
        JsonObject response = XhrHelper.executeXhrRequest("member_signup.js",args);
        if(!String.valueOf(response.get("success")).equalsIgnoreCase("true")){
            throw new RuntimeException(String.format("Sign up with credential %s/%s fail . Response from server: %s",randomEmail,pass,String.valueOf(response)));
        }
        Global.browser.refresh();
    }

    @And("^I sign up sms by api")
    public void signUpByMobilePhoneApi(){
        String csrfToken = Global.browser.getCookiesAsMap().get("_tb_token_");
        String mobilePhone = Global.config.getString("member.phone_number_signup" + RandomeHelper.generatePhoneNumber());
        Global.map.put("phone_number",mobilePhone);
        String pass = Global.config.getString("member.account.pass");
        String name = Global.config.getString("member.account.name");
        String apiUrl = Global.config.getString("member.url")+"/user/api/register";
        String [] args = {apiUrl,mobilePhone,pass,name,csrfToken};
        JsonObject response = XhrHelper.executeXhrRequest("member_signup.js",args);
        Allure.addAttachment("Json Response", String.valueOf(response));
        if(!String.valueOf(response.get("success")).equalsIgnoreCase("true")){
            throw new RuntimeException(String.format("Sign up with credential %s/%s fail . Response from server: %s",mobilePhone,pass,String.valueOf(response)));
        }
        Global.browser.refresh();
    }

    @And("^I create a new member address by api")
    public void createAddressByApi(){
        String apiUrl = Global.config.getString("member.url")+"/address/api/createAddress";
        String name=Global.config.getString("member.account.name");
        String phone=Global.config.getString("member.account.phone_number_login");
        String locationTreeAddressArray=Global.config.getString("member.address.locationTreeAddressArray");
        String locationTreeAddressId=Global.config.getString("member.address.locationTreeAddressId");
        String locationTreeAddressName=Global.config.getString("member.address.locationTreeAddressName");
        String csrfToken = Global.browser.getCookiesAsMap().get("_tb_token_");
        String [] args = {apiUrl,name,phone,locationTreeAddressArray,locationTreeAddressId,locationTreeAddressName,csrfToken};
        JsonObject response = XhrHelper.executeXhrRequest("member_create_address.js",args);
        if(!String.valueOf(response.get("success")).equalsIgnoreCase("true")){
            throw new RuntimeException(String.format("Create address fail . Response from server: %s",String.valueOf(response)));
        }
        Global.browser.refresh();
    }

}