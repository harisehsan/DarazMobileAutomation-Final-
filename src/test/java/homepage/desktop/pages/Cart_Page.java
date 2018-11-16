package homepage.desktop.pages;

import base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cartPage extends PageObject {
    @FindBy(xpath="//*[@id='rightContainer_CR']/div[2]/div[2]/div/div[3]/button") private WebElement processCheckOutBtn;
    @FindBy(xpath="//*[@id='listHeader_H']/span[1]/label/input") private WebElement selectAllBtn ;

    public void processCheckout(){
        waitUntilPageReady();

        processCheckOutBtn.click();
        waitUntilInvisibilityOf(By.id("_x38_0x80-loading-logo"));
    }

    public void SelectAllItems(){
        waitUntilPageReady();
        if (!selectAllBtn.isSelected()){
            selectAllBtn.click();
            waitUntilInvisibilityOf(By.id("_x38_0x80-loading-logo"));
        }
    }
}
