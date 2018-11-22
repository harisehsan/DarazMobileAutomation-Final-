package old_module.desktop.pages.desktop.topup;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;
import member.desktop.pages.account.Login_Page;

public class Topup_Page extends PageObject {

    private static final String page_url = "http://pdp.lazada.test/mobilerecharge.html";

    @FindBy(css = ".topup-phone-field__input-container input") private WebElement number_field;
    @FindBy(css = ".topup-operators__select") private WebElement operator_field;
    @FindBy(css = ".topup__submit-button") private  WebElement submit;
    @FindBy(css = ".topup-login-prompt__link") private WebElement login_button;

    public static void visit(String page_url){ Global.browser.goTo(page_url); }

    public Topup_Page(){ super();}

    public void enterNumber(String number)
    {
        this.number_field.sendKeys(number);
    }

    public void selectOperator(int id) {
        operator_field.click();
        By css = By.cssSelector(".next-menu-content li:nth-child("+ id +")");
        waitUntilPresentOfElementBy(css);
        findDynamicElement(css).click();

    }

    public void checkOperator(String operatorName) throws Exception{
        By css = By.cssSelector(".topup-operators__select-inner .topup-operators__menu-item__name");
        waitUntilPresentOfElementBy(css);
        WebElement web = findDynamicElement(css);
        String operatorValue = web.getText();
        if(!operatorValue.equals(operatorName)) {
            throw new Exception("auto-detection of the operator does not work correctly");
        }
        Global.browser.getWebDriver().getCurrentUrl();
    }

    public void selectProduct(String nameProduct) throws InterruptedException {
        By xpath = By.xpath("//span[contains(string(), '" + nameProduct + "')]");
        waitUntilPresentOfElementBy(xpath);
        WebElement web = findDynamicElement(xpath);
        waitUntilVisible(web);
        web.click();
    }

    public void selectTab(String nameTab){
        By xpath = By.xpath("//button[contains(string(), '" + nameTab + "')]");
        waitUntilClickable(xpath);
        WebElement web = findDynamicElement(xpath);
        web.click();
    }

    public void pushSubmit(){
        waitUntilVisible(submit);
        submit.click();
    }

    public void openLogIn(String login, String password){
        waitUntilVisible(login_button);
        login_button.click();
//        new Login_Page().login(login,password);
    }

    public void checkAfterLogIn() throws Exception{
//        String country = PageHelper.GetVenture();
//        By helloMessage = null;
//        if (country == "SG") {
//           helloMessage = By.xpath("//span[contains(string(), 'Hello')]");
//        }
//        else {
//           helloMessage = By.xpath("//span[contains(string(), 'topup')]");
//        }
//        waitUntilPresentOfElementBy(helloMessage);
//        findDynamicElement(helloMessage).click();
    }

    public void selectNumberFromList(int id) throws Exception{
        number_field.click();
        By css = By.cssSelector(".expandInDown li:nth-child("+ id +")");
        WebElement number = findDynamicElement(css);
        String listNumber = number.getText();
        number.click();
        String fieldNumber = number_field.getAttribute("value");
        if(!listNumber.equals(fieldNumber)) {
            throw new Exception("Numbers do not match");
        }
    }

    public void selectNumberFromList(String number) throws Exception{
        number_field.click();
        By css = By.xpath("//li[contains(string(), '" + number + "')]");
        WebElement numberWeb = findDynamicElement(css);
        String listNumber = numberWeb.getText();
        numberWeb.click();
        String fieldNumber = number_field.getAttribute("value");
        if(!listNumber.equals(fieldNumber)) {
            throw new Exception("Numbers do not match");
        }
    }
}
