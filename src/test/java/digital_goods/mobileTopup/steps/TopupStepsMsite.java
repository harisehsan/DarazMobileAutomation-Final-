package digital_goods.mobileTopup.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import digital_goods.mobileTopup.page_object.TopupMobilePage;
import global.helpers.Wait;


//import mpage_object.TopupMobilePage;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TopupStepsMsite {


    TopupMobilePage topupMobilePage = page(TopupMobilePage.class);
    Wait waiter = new Wait();

    @Given("^stop$")
    public void stop() throws Throwable {
        System.out.println("stop");
    }

    @Given("^open topup page on M-site$")
    public void openTopupPageOnMSite() throws Throwable {
        open("https://www.lazada.vn/mobilerecharge.html?");
    }

    @And("^select product with name \"([^\"]*)\"$")
    public void selectProductWithName(String nameOfProduct) throws Throwable {

        topupMobilePage.productList.shouldBe(CollectionCondition.sizeGreaterThan(1));
        ElementsCollection prodCollection = topupMobilePage.productList;
        SelenideElement product = prodCollection.find(Condition.text(nameOfProduct));
        product.click();
    }

    @And("^select product with number (\\d+)$")
    public void selectTextWithNumber(int id) throws Throwable {
        topupMobilePage.productList.shouldBe(CollectionCondition.sizeGreaterThan(1));
        topupMobilePage.productList.get(id-1).click();
    }

    @Then("^check sorts of products by price$")
    public void checkSortsOfProductsByPrice() throws Throwable {
        topupMobilePage.productList.shouldBe(CollectionCondition.sizeGreaterThan(1));
        ElementsCollection originCollection = topupMobilePage.productPriceList;
        List<Integer> priceList = new ArrayList();
        /*int size = originCollection.size();
        for (SelenideElement o: originCollection) {
            System.out.println("111");
        }
        for(int i = 0; i < size; i++){
            String priceStr = originCollection.get(i).text();
            int price = Integer.parseInt(priceStr.replaceAll("[^0-9]+", ""));
            priceList.add(price);
        }*/
        for(SelenideElement elem: originCollection) {
            String priceStr = elem.text();
            int price = Integer.parseInt(priceStr.replaceAll("[^0-9]+", ""));
            priceList.add(price);
        }
        List rightPristList = new ArrayList();
        rightPristList = priceList;
        Collections.sort(rightPristList);
        if(!rightPristList.equals(priceList))
            Assert.fail("products did not sorted");

    }

    @And("^select tab \"([^\"]*)\"$")
    public void selectTab(String nameTab) throws Throwable {
        ElementsCollection tabCollection = topupMobilePage.productTabs;
        SelenideElement product = tabCollection.find(Condition.text(nameTab));
        product.click();
    }

    @And("^select operator \"([^\"]*)\"$")
    public void selectOperator(String operatorTittle) throws Throwable {
        sleep(50);
        ElementsCollection operatorCollection = topupMobilePage.operatorList;
        SelenideElement operator = operatorCollection.find(Condition.text(operatorTittle));
        operator.click();
    }

    @Then("^check that operator \"([^\"]*)\" selected correct$")
    public void checkThatOperatorSelectedCorrect(String operatorName) throws Throwable {
        topupMobilePage.greyArea.shouldNotBe(visible);
        topupMobilePage.operatorBlock.shouldNotBe(visible);
        SelenideElement imgElem = topupMobilePage.iconOfSelectedOperator.shouldBe(Condition.attribute("src",operatorName.toLowerCase()));
        waiter.waitUntilSrcContent(imgElem,operatorName.toLowerCase());
    }

    @Then("^check correct of list with previous numbers$")
    public void checkCorrectOfListWithPreviousNumbers() throws Throwable {
        topupMobilePage.previousPhoneBlock.shouldBe(visible);
        String inputPhoneNumber = topupMobilePage.phoneInput.getValue().replaceAll("[^0-9]+","");
        String firstPhoneNumber = topupMobilePage.previousPhonelist.get(0).getText().replaceAll("[^0-9]+","");
        if(!firstPhoneNumber.equals(inputPhoneNumber))
            Assert.fail("list with previous numbers incorrect");

        if(topupMobilePage.previousPhonelist.size() > 3)
            Assert.fail("list with previous numbers have more then 3 last numbers");
    }


    @Then("^check that first product is auto selected$")
    public void checkThatFirstProductIsAutoSelected() throws Throwable {
        sleep(1000);
        String priceOfFirstProduct = topupMobilePage.productPriceList.get(0).text().replaceAll("[^0-9]+","");
        String selectedProduct = topupMobilePage.selectedProduct.getText().replaceAll("[^0-9]+","");
        if(!selectedProduct.contains(priceOfFirstProduct))
            Assert.fail("first product was not selected");

    }

    @Then("^check that product \"([^\"]*)\" was selected$")
    public void checkThatProductWasSelected(String originProduct) throws Throwable {
        sleep(1000);
        String currentProduct = topupMobilePage.selectedProduct.getText();
        if(!currentProduct.contains(originProduct))
            Assert.fail("current product wasn't selected");

    }

    @Then("^check that voucher \"([^\"]*)\" was applied$")
    public void checkThatVoucherWasApplied(String originVoucher) throws Throwable {
        sleep(1000);
        SelenideElement elem = topupMobilePage.voucherApplied;
        String currentVoucher = elem.getText();
        if (!currentVoucher.equals(originVoucher))
            Assert.fail("Current voucher is wrong");

    }

    @Then("^check that total price is \"([^\"]*)\"$")
    public void checkThatTotalPriceIs(String originTotal) throws Throwable {
        sleep(1000);
        SelenideElement elem = topupMobilePage.total;
        String total = elem.getText();
        if (!total.equals(originTotal))
            Assert.fail("total price is wrong");
    }
}
