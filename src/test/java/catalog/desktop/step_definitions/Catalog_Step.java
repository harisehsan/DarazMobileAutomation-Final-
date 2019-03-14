package catalog.desktop.step_definitions;

import base.BaseSteps;
import catalog.desktop.pages.Catalog_page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homepage.desktop.pages.Home_Page;
import pdp.desktop.pages.Pdp_Page;

public class Catalog_Step extends BaseSteps {

    @Given("^I visit the catalog page$")
    public void iVisitTheCatalogPage() {
        visit(Catalog_page.class);
        on(Pdp_Page.class).switchToEnglish();
    }

    @And("^I search \"([^\"]*)\" in header$")
    public void iSearchKeywordInHeader(String arg0) {
        on(Home_Page.class).searchKeyword(arg0);
    }

    @When("^I apply the vertical brand filter$")
    public void iApplyTheVerticalBrandFilter() {
        on(Catalog_page.class).applyVerticalBrandFilter();
    }

    @When("^I apply the vertical size filter$")
    public void iApplyTheVerticalSizeFilter() {
        on(Catalog_page.class).applyVerticalSizeFilter();
    }

    @When("^I apply the vertical Color Family filter$")
    public void iApplyTheVerticalColorFamilyFilter() {
        on(Catalog_page.class).applyVerticalColorFilter();
    }

    @When("^I apply the vertical Price Range filter$")
    public void iApplyTheVerticalPriceRangeFilter() {
        on(Catalog_page.class).applyVerticalPriceFilter();
    }

    @Then("^\".*?\" Filter should be applied$")
    public void filterShouldBeApplied() {
        on(Catalog_page.class).assertFilterShouldBeApplied();
    }

    @And("^I remove \"([^\"]*)\" filters$")
    public void iRemoveFilters(String arg0){
        on(Catalog_page.class).clearFilters(arg0);
    }

    @Then("^\"([^\"]*)\" Filters should be removed$")
    public void filtersShouldBeRemoved(String arg0) {
        on(Catalog_page.class).assertFilterRemoved(arg0);
    }
}