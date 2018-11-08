package lazada.steps;

import com.codeborne.selenide.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import global.Drivers;
import global.helpers.AbstractPage;
import global.helpers.Wait;
import lazada.page_object.AllMobilePages;
import member.msite.page_object.LoginMobilePage;
import digital_goods.mobileTopup.page_object.TopupMobilePage;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

public class GlobalSteps {

    public Drivers drvs = new Drivers();

    AllMobilePages allMobilePages = null;
    LoginMobilePage loginMobilePage = null;
    TopupMobilePage topupMobilePage = null;
    AbstractPage currentPage = null;
    Wait waiter = new Wait();
    SelenideElement elem = null;
    ElementsCollection elemGroup = null;

    private AbstractPage getCurrentPage (String pageName){
        if ("topup mobile".equals(pageName)){
            return currentPage = topupMobilePage;
        }
        else if ("login mobile".equals(pageName)){
            return currentPage = loginMobilePage;
        }
        else{
            return currentPage;
        }
    }

    @Given("^open Chrome mobile browser$")
    public void openChromeMobileBrowser()  {
        WebDriverRunner.setWebDriver(drvs.getChromeDriverMobile());
        allMobilePages = page(AllMobilePages.class);
        loginMobilePage = page(LoginMobilePage.class);
        topupMobilePage = page(TopupMobilePage.class);
    }


    @And("^click element \"([^\"]*)\" on \"([^\"]*)\" page$")
    public void clickElement(String element, String page)  {
        elem = getCurrentPage(page).get(element).shouldBe(Condition.visible);
        waiter.waitUntilClickable(elem);
        elem.click();
    }

    @And("^type to input with name \"([^\"]*)\" text: \"([^\"]*)\" on \"([^\"]*)\" page$")
    public void typeToInputWithNameText(String inputName, String val, String page)  {
        //allMobilePages.greyArea.shouldNotBe(Condition.visible);
        elem = getCurrentPage(page).get(inputName).shouldBe(Condition.visible);
        waiter.waitUntilClickable(elem);
        Boolean valueIsEmpty = true;
        while(valueIsEmpty){
            elem.clear();
            elem.sendKeys(val);
            val.length();
            String value = elem.getValue();
            sleep(50);
            if (value.replaceAll("[^0-9]+","").length() != val.replaceAll("[^0-9]+","").length()){
                valueIsEmpty = true;
            } else {
                valueIsEmpty = false;
            }
        }
        //elem.clear();
        //elem.sendKeys(val);
    }

    @And("^press enter to \"([^\"]*)\" on \"([^\"]*)\" page$")
    public void pressEnterTo(String element, String page) {
        elem = getCurrentPage(page).get(element);
        waiter.waitUntilClickable(elem);
        elem.pressEnter();
    }

    @Then("^check value in input \"([^\"]*)\" should be \"([^\"]*)\" on \"([^\"]*)\" page$")
    public void checkNumberMustBe(String inputName, String val, String page)  {
        elem = getCurrentPage(page).get(inputName).shouldBe(visible);
        waiter.waitUntilClickable(elem);
        waiter.waitUntilValueNotEmpty(elem);
        String currentValue;
        currentValue = elem.getValue();
        if(!currentValue.equals(val)){
            Assert.fail("mask or value not correct");
        }
    }

    @Then("^check that element \"([^\"]*)\" is on \"([^\"]*)\" page$")
    public void checkElementOnPage(String element, String page) {
        elem = getCurrentPage(page).get(element).shouldBe(visible);
        elem.shouldBe(visible);
    }


    @Then("^check that element \"([^\"]*)\" is not on \"([^\"]*)\" page$")
    public void checkThatElementIsNotOnPage(String element, String page) {
        getCurrentPage(page).get(element).shouldNotBe(visible);
    }

    @And("^select \"([^\"]*)\" row from \"([^\"]*)\" on \"([^\"]*)\" page$")
    public void selectRowFromOnPage(String row, String list, String page) {
        elemGroup = getCurrentPage(page).getCollection(list).shouldBe(CollectionCondition.sizeGreaterThanOrEqual(1));
        elem = elemGroup.find(Condition.text(row.toLowerCase()));
        elem.click();
    }
}
