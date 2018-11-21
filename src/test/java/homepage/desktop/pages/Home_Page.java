package homepage.desktop.pages;

import global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.*;

public class Home_Page extends PageObject {

    public static final String page_url = Global.config.getString("homepage.home_url");

    @FindBy(css = "") public WebElement SupportPopUp;
    @FindBy(css="#anonLogin") private WebElement LoginBtn;
    @FindBy(css="#myAccountTrigger") private WebElement userName;

    public void clickToLoginPage() {
        waitUntilVisible(LoginBtn);
        LoginBtn.click();
    }

    public void backToHomePage(){
        waitUntilVisible(userName);
    }
}
