package catalog.desktop.step_definitions;

import base.BaseSteps;
import catalog.desktop.pages.Cataloge_page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homepage.desktop.pages.Home_Page;
import pdp.desktop.pages.Pdp_Page;

public class Catalog_Step extends BaseSteps {

    @Given("^I visit the catalog page$")
    public void iVisitTheCatalogPage() {
        visit(Cataloge_page.class);
        on(Pdp_Page.class).switchToEnglish();
    }

    @When("^I apply the vertical \"([^\"]*)\" filter$")
    public void iApplyTheVerticalFilter(String arg0) {
        on(Cataloge_page.class).applyCatalogPageFilters(arg0);
    }

    @Then("^\"([^\"]*)\" Filter should be applied$")
    public void filterShouldBeApplied(String arg0) {
        on(Cataloge_page.class).assertFilteredResults(arg0);
    }

    @And("^I search \"([^\"]*)\" in header$")
    public void iSearchKeywordInHeader(String arg0) {
        on(Home_Page.class).searchKeyword(arg0);
    }

    @And("^I remove \"([^\"]*)\" filters$")
    public void iRemoveFilters(String arg0){
        on(Cataloge_page.class).clearFilters(arg0);
    }

    @Then("^\"([^\"]*)\" Filters should be removed$")
    public void filtersShouldBeRemoved(String arg0) {
        on(Cataloge_page.class).assertFilterRemoved(arg0);
    }

    @Then("^Filter should be applied$")
    public void filterShouldBeApplied() {
        on(Cataloge_page.class).applyCatalogPageFilters("");
    }
}