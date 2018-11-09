package digital_goods.mobileTopup.page_object;

import com.codeborne.selenide.SelenideElement;
import global.helpers.AbstractPage;
import global.helpers.NameOfElement;
import org.openqa.selenium.support.FindBy;

public class LoginMobilePage extends AbstractPage {

    @NameOfElement("Email")
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[1]/div/div[1]/input")
    public SelenideElement emailInput;

    @NameOfElement("Password")
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[1]/div/div[2]/input")
    public SelenideElement passwordInput;

    @NameOfElement("Login button")
    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/button")
    public SelenideElement loginButton;
}
