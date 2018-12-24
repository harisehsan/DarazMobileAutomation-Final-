package _base.global_steps.desktop_steps;

import _base.api_helpers.buyer.BuyerSearchApi;
import base.BaseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import global.Global;
import helper.RandomHelper;
import member.desktop.pages.account.Member_Login_Page;
import member.desktop.pages.account.SignUp_Page;
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

    @Given("^I go to a normal pdp page$")
    public void visitNormalPdpPage() {
        BuyerSearchApi searchApi = new BuyerSearchApi();
        String url = searchApi.getPdpFromCatalog("mobile");
        Pdp_Page.setUrl(url);
        visit(Pdp_Page.class);
        on(Pdp_Page.class).closeShippingFromOverseaPopup();
        on(Pdp_Page.class).switchToEnglish();
    }

    @Given("^I go to a normal QnA pdp page$")
    public void visitNormalQnAPdpPage() {
        BuyerSearchApi searchApi = new BuyerSearchApi();
        String url = searchApi.getQnaPdpFromCatalog("mobile");
        Pdp_Page.setUrl(url);
        visit(Pdp_Page.class);
        on(Pdp_Page.class).closeShippingFromOverseaPopup();
        on(Pdp_Page.class).switchToEnglish();
    }

    @Given("^I go to a test COD pdp page$")
    public void visitTestCODPdpPage() {
        BuyerSearchApi searchApi = new BuyerSearchApi();
        String url = searchApi.getCodPdpOfTestSellers();
        Pdp_Page.setUrl(url);
        visit(Pdp_Page.class);
        on(Pdp_Page.class).closeShippingFromOverseaPopup();
        on(Pdp_Page.class).switchToEnglish();
    }

    @Given("^I go to a test QnA pdp page$")
    public void visitTestQnAPdpPage() {
        BuyerSearchApi searchApi = new BuyerSearchApi();
        String url = searchApi.getQnaPdpOfTestSellers();
        Pdp_Page.setUrl(url);
        visit(Pdp_Page.class);
        on(Pdp_Page.class).closeShippingFromOverseaPopup();
        on(Pdp_Page.class).switchToEnglish();
    }

    @Given("^I go to a normal COD pdp page$")
    public void visitCodPdpPage() {
        BuyerSearchApi searchApi = new BuyerSearchApi();
        String url = searchApi.getCodPdpFromCatalog("diaper");
        Pdp_Page.setUrl(url);
        visit(Pdp_Page.class);
        on(Pdp_Page.class).closeShippingFromOverseaPopup();
        on(Pdp_Page.class).switchToEnglish();
    }


    @Given("^I go to a test Chat Message pdp page from catalog$")
    public void visitIMPdpPage() {
        BuyerSearchApi searchApi = new BuyerSearchApi();
        String url = searchApi.getImPdpFromCatalog("mobile");
        Pdp_Page.setUrl(url);
        visit(Pdp_Page.class);
        on(Pdp_Page.class).closeShippingFromOverseaPopup();
        on(Pdp_Page.class).switchToEnglish();
    }

    @Given("^I go to a test Chat Message pdp page from test sellers$")
    public void visitTestIMPdpPage() {
        BuyerSearchApi searchApi = new BuyerSearchApi();
        String url = searchApi.getIMPdpOfTestSellers();
        Pdp_Page.setUrl(url);
        visit(Pdp_Page.class);
        on(Pdp_Page.class).closeShippingFromOverseaPopup();
        on(Pdp_Page.class).switchToEnglish();
    }

    @Given("I sign up by slider with email")
    public void signUpBySlider() {
        visit(SignUp_Page.class);
        Global.browser.refresh();
        on(SignUp_Page.class).signEmail();
        String randomEmail = RandomHelper.randomTestMail();
        Global.map.put("current_mail",randomEmail);
        String pass = Global.config.getString("member.account.pass");
        Global.map.put("current_pass",pass);
        String name = Global.config.getString("member.account.name");
        on(SignUp_Page.class).signUpByEmail(randomEmail,pass,name);
        on(SignUp_Page.class).setSliderbtn();
    }

}
