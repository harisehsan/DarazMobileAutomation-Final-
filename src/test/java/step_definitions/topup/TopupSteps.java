package step_definitions.topup;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import global.Global;
import model.ProductDetailInfo;
import pages.topup.Topup_Page;

public class TopupSteps {
    @Given("^I go to topup daily page")
    public void goToDailyTopupPage() throws Throwable {
        Topup_Page.visit("http://pdp.lazada.test/mobilerecharge.html");
    }

    @Given("^I go to topup pre-live page")
    public void goToPreLiveTopupPage() throws Throwable {
        Topup_Page.visit("http://pdpdesc-m.lazada.sg/mobilerecharge.html");
    }

    @Given("^I go to topup live page")
    public void goToLiveTopupPage() throws Throwable {
        Topup_Page.visit("http://pdp.lazada.sg/mobilerecharge.html");
    }

    @And("^I Enter number \"([^\"]*)\"")
    public void enterNumber(String number) throws Throwable {
        new Topup_Page().enterNumber(number);
    }

    @And("^I Select operator")
    public void selectOperator() throws Throwable {
        new Topup_Page().selectOperator(1);
    }

    @And("^I Select product tab \"([^\"]*)\"")
    public void selectProdTab (String nameTab){
        new Topup_Page().selectTab(nameTab);
    }

    @And("^I Select product \"([^\"]*)\"")
    public void selectProduct(String nameProduct) throws Throwable {
        //new Topup_Page().selectProduct("dewei_test_topup_vi");
        new Topup_Page().selectProduct(nameProduct);
    }

    @And("^I Push top-up now")
    public void pushSubmit() throws Throwable {
        new Topup_Page().pushSubmit();
    }

    @And("^I Log in from TopUp page, account: \"([^\"]*)\", password: \"([^\"]*)\"")
    public void logIn(String user, String pass) throws Throwable {
        new Topup_Page().openLogIn(user, pass);
    }

    @And("^I check after login")
    public void checkLogIn() throws Throwable {
        new Topup_Page().checkAfterLogIn();
    }

    @And("^I select phone number from list")
    public void selectPhoneNumber() throws Throwable {
        new Topup_Page().selectNumberFromList(1);
    }

    @And("^I select phone number from list by number: \"([^\"]*)\"")
    public void selectPhoneNumber(String number) throws Throwable {
        new Topup_Page().enterNumber(number);
    }

}
