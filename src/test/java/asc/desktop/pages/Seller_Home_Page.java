package asc.desktop.pages;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

public class Seller_Home_Page extends PageObject {

    private static final String page_url = Global.getConfig().getString("asc.home_url");

    @FindBy(css = ".la-header-nav-user-content .username") private WebElement displayed_user_nav;

    public String currentSellerName(){
        waitUntilPageReady();
        waitUntilVisible(displayed_user_nav);
        return displayed_user_nav.getText();
    }



}
