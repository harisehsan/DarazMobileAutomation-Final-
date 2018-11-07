package homepage.PC.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = "") public WebElement SupportPopUp;
    @FindBy(css=".anonLogin") private WebElement LoginBtn;

    public void clickToLoginPage() {
        LoginBtn.click();

    }
}
