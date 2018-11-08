package homepage.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(css="input[type=text][data-meta=Field]") private WebElement emailField;
    @FindBy(css="input[type=password][data-meta=Field]") private WebElement pwdField;
    @FindBy(css="button[type=submit]") private WebElement btnLogin;

    public void InputLogin(String userName, String pwd)
    {
        waitUntilVisible(emailField);
    emailField.sendKeys(userName);
    pwdField.sendKeys(pwd);


    }

    public void ClickToLogin ()
    {
        waitUntilVisible(btnLogin);
        btnLogin.click();
    }
}
