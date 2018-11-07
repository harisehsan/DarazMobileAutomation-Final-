package homepage.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class thankyouPage extends PageObject {

    @FindBy(xpath="//*[@id=\'container\']/div/div[1]/div[1]/div/div[1]") public WebElement thanksText;

    public void checkSuccessfull () {
        waitUntilVisible(thanksText);

    }
}
