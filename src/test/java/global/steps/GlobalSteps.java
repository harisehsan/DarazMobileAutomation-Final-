package global.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import global.helpers.Wait;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class GlobalSteps {

    Wait waiter = new Wait();

    @Then("^verify that page with url which contains \"([^\"]*)\" is opened$")
    public void verifyThatPageWithUrlWhichContainsIsOpened(String verifyUrl)
    {
        waiter.waitUntilUrlContant(verifyUrl);
        String currentUrl = url();
        if(!currentUrl.contains(verifyUrl))
        {
            Assert.fail("login page didn't opened");
        }
    }

    @Then("^verify that page with url which \"([^\"]*)\" is opened$")
    public void verifyThatPageWithUrlIsOpened(String verifyUrl)
    {
        waiter.waitUntilUrlContant(verifyUrl);
        String currentUrl = url();
        if(!currentUrl.equals(verifyUrl))
        {
            Assert.fail("login page didn't opened");
        }
    }

    @Parameters({  "args" })
    @Given("^open page \"([^\"]*)\"$")
    public void openTopupPageOnMSite(String url) throws Throwable {
        open(url);
    }
}
