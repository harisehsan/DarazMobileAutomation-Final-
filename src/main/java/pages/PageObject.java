package pages;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by admin.son.ton on 1/23/18.
 */
public abstract class PageObject {

    private WebDriver driver;

    protected PageObject() {
        driver = Global.browser.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    protected void waitUntilVisible(WebElement ele) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(ele));
    }

    protected void waitUntilNotVisible(WebElement ele) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(ele));
    }

    protected String currentUrl() {
        return driver.getCurrentUrl();
    }

    protected WebElement findDynamicElement(By by) {
        return driver.findElement(by);
    }

    protected void waitUntilPresentOfElementBy(By by) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void waitUntilELementClickable(By by) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by));
    }

}
