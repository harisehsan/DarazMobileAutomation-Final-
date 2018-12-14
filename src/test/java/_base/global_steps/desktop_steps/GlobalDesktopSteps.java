package _base.global_steps.desktop_steps;

import _base.api_helpers.buyer.BuyerSearchApi;
import base.BaseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Global;
import member.desktop.pages.account.Account_Page;
import member.desktop.pages.account.Member_Login_Page;
import pdp.desktop.pages.Pdp_Page;

public class GlobalDesktopSteps extends BaseSteps {

    @And("^I login by email on lazada/daraz")
    public void globalLoginByEmail()throws Throwable {
        visit(Member_Login_Page.class);
        String email = Global.config.getString("member.account.mail");
        String pass = Global.config.getString("member.account.pass");
        on(Member_Login_Page.class).loginEmailPass(email,pass);
    }

    @When("^I get the product title$")
    public void getProductTitle(){
        String currentProductTitle = on(Pdp_Page.class).getProductTitle();
        Global.map.put("currentProductTitle", currentProductTitle);
    }

    @When("^I go to a test pdp page$")
    public void goToTestCod(){
        BuyerSearchApi searchApi = new BuyerSearchApi();
        String url = searchApi.getRandomCodProductFromRandomSeller();
        Pdp_Page.setUrl(url);
        visit(Pdp_Page.class);
        on(Pdp_Page.class).closeShippingFromOverseaPopup();
        on(Pdp_Page.class).switchToEnglish();
    }

    @Given("^I go to a normal pdp page$")
    public void visitNormalPdpPage() {
        BuyerSearchApi searchApi = new BuyerSearchApi();
        String url = searchApi.getCodProductFromCatalog("test");
        Pdp_Page.setUrl(url);
        visit(Pdp_Page.class);
        on(Pdp_Page.class).closeShippingFromOverseaPopup();
        on(Pdp_Page.class).switchToEnglish();
    }

    @Given("^I go to a pdp page that ask_question feature enabled$")
    public void visitAskQuestionEnabledPdpPage() {
        String url = Global.config.getString("pdp.askQuestion_pdp_url");
        Pdp_Page.setUrl(url);
        visit(Pdp_Page.class);
        on(Pdp_Page.class).closeShippingFromOverseaPopup();
        on(Pdp_Page.class).switchToEnglish();
    }
}
