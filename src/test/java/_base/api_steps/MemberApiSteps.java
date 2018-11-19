package _base.api_steps;

import base.BaseSteps;
import com.google.gson.JsonObject;
import cucumber.api.java.en.And;
import global.Global;
import helper.XhrHelper;

public class MemberApiSteps extends BaseSteps {

    @And("^I login by api with email and password$")
    public void loginByApi(){
        String csrfToken = Global.browser.getCookiesAsMap().get("_tb_token_");
        String email = Global.config.getString("member.account.mail");
        String pass = Global.config.getString("member.account.pass");
        String apiUrl = Global.config.getString("member.url")+"/user/api/login";
        String [] args = {apiUrl,email,pass,csrfToken};
        JsonObject response = XhrHelper.executeXhrRequest("member_login.js",args);
        if(!String.valueOf(response.get("success")).equalsIgnoreCase("true")){
            throw new RuntimeException(String.format("Login with credential %s/%s fail . Response from server: %s",email,pass,String.valueOf(response)));
        }
        Global.browser.refresh();
    }

}