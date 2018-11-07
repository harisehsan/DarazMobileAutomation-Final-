package member.msite.steps;

import cucumber.api.java.en.Given;
import global.Drivers;
import member.msite.page_object.LoginMobilePage;

import static com.codeborne.selenide.Selenide.page;

public class LoginSteps {

    public Drivers drvs = new Drivers();
    LoginMobilePage loginMobilePage = null;

    //initialize login mobile page need only after opening login page
    @Given("^initialize login mobile page$")
    public void initializeLoginMobilePage(){
        loginMobilePage = page(LoginMobilePage.class);
    }
}
