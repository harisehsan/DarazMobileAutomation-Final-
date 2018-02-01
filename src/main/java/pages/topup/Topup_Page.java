package pages.topup;

import global.Global;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Base_Page;
import pages.account.Login_Page;

public class Topup_Page extends Base_Page {

    private static final String page_url = "http://pdp-p.lazada.sg/mobilerecharge.html";

    @FindBy(css = ".topup-phone-field__input-container input") private WebElement number_field;
    @FindBy(css = ".topup-operators__select") private WebElement operator_field;
    @FindBy(xpath = "//span[contains(string(), 'dewei_test_topup_vi')]") private WebElement product;
    @FindBy(css = ".topup__submit-button") private  WebElement submit;
    @FindBy(css = ".topup-login-prompt__link") private WebElement login_button;

    private String hello_message = "//span[starts-with(string(), 'Hello,')]";


    public static void visit(){
        Global.browser.goTo(page_url);
    }

    public Topup_Page(){ super();}

    public void enterNumber(String number)
    {
        this.number_field.sendKeys(number);
    }

    public void selectOperator(int id) {
        operator_field.click();
        String css = ".next-menu-content li:nth-child("+ id +")";
        browser.waitUntilElementNotVisibleByXCss(css);
        browser.getWebDriver().findElement(By.cssSelector(css)).click();
    }

    public void selectProduct(String nameProduct) throws InterruptedException {
        String xpath = "//span[contains(string(), '" + nameProduct + "')]";
        browser.waitUntilElementNotVisibleByXpath(xpath);
        WebElement web = browser.findDynamicElement(By.xpath(xpath));
        browser.waitUntilVisible(web);
        web.click();
    }

    public void pushSubmit(){
        browser.waitUntilVisible(submit);
        submit.click();
    }

    public void openLogIn(String login, String password){
        browser.waitUntilVisible(login_button);
        login_button.click();
        new Login_Page().login(login,password);
    }

    public void checkAfterLogIn(){
        browser.waitUntilElementNotVisibleByXpath(hello_message);
        browser.getWebDriver().findElement(By.xpath(hello_message));
    }

    public void selectNumberFromList(int id) throws Exception{
        number_field.click();
        String css = ".expandInDown li:nth-child("+ id +")";
        WebElement number = browser.getWebDriver().findElement(By.cssSelector(css));
        String listNumber = number.getText();
        number.click();
        String fieldNumber = number_field.getText();
        if(!listNumber.equals(fieldNumber)) {
            throw new Exception("Numbers do not match");
        }
    }
}
