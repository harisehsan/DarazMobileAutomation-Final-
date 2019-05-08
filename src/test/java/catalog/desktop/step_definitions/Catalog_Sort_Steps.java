package catalog.desktop.step_definitions;

import base.BaseSteps;
import catalog.desktop.pages.Catalog_Sort_Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import java.io.IOException;
import java.util.List;

public class Catalog_Sort_Steps extends BaseSteps {
    @And("I apply price low to high filter")
    public void iApplyLowToHighPriceFilter() {
        on(Catalog_Sort_Page.class).applyPriceLowToHighFilter(); }

    @Then("I verify the sorted price catalog")
    public void iVerifyTheSortedPriceCatalog() throws IOException {
       List<Float> productPrices = on(Catalog_Sort_Page.class).getProductPrices();
       Assert.assertTrue(on(Catalog_Sort_Page.class).verifyProductPrices(productPrices),"Filter low to high price is not working correctly!");
    }
}