package _base.global_steps.msite_steps;

import base.BaseSteps;
import cucumber.api.java.en.Given;
import global.Global;
import helper.RandomHelper;
import member.msite.pages.account.Member_Signupemail_Msite_Page;

public class GlobalMsiteSteps extends BaseSteps {

    @Given("On Msite I sign up by slider with email")
    public void signUpBySliderOnMsite() {
        visit(Member_Signupemail_Msite_Page.class);
        Global.browser.refresh();
        on(Member_Signupemail_Msite_Page.class).signUpEmail();
        String name = Global.config.getString("member.account.name");
        Global.map.put("name_of_account",name);
        String randomEmail = RandomHelper.randomTestMail();
        Global.map.put("current_mail",randomEmail);
        String passWord = Global.config.getString("member.account.pass");
        Global.map.put("current_pass", passWord);
        on(Member_Signupemail_Msite_Page.class).signUpByEmail(name,randomEmail,passWord);
        on(Member_Signupemail_Msite_Page.class).clickAndHoldSlider();
    }

}
