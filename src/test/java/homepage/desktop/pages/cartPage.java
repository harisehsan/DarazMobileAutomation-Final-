package homepage.desktop.pages;

import base.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cartPage extends PageObject {
    @FindBy(xpath="//*[@id=\'rightContainer_CR\']/div[2]/div[2]/div/div[3]/button") private WebElement processCheckOutBtn;
    public void processCheckout(){
        waitUntilPageReady();
        processCheckOutBtn.click();
    }
}
