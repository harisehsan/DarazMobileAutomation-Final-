package pages;

import global.Global;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin.son.ton on 1/23/18.
 */
public class PageObject {

    private WebDriver driver;
    private static final int DEFAULT_TIMEOUT = 30;

    protected PageObject() {
        driver = Global.browser.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    protected void waitUntilPageReady(){
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    protected void waitUntilJqueryReady(){
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return jQuery.active == 0").equals(true));
    }

    protected void scrollToView(WebElement ele){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
    }

    protected void hover(WebElement ele){
        Actions action = new Actions(driver);
        action.moveToElement(ele).build().perform();
    }

    protected void waitUntilVisible(WebElement ele) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(ele));
    }

    protected void waitUntilNotVisible(WebElement ele) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.invisibilityOf(ele));
    }

    protected String currentUrl() {
        return driver.getCurrentUrl();
    }

    protected WebElement findDynamicElement(By by) {
        return driver.findElement(by);
    }

    protected void waitUntilPresentOfElementBy(By by) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void waitUntilClickable(By by) {
        waitUntilClickable(by,DEFAULT_TIMEOUT);
    }
    
    protected void waitUntilClickable(By by, int timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void waitUntilVisibility(By by) {
        waitUntilVisibility(by,DEFAULT_TIMEOUT);
    }

    protected void waitUntilVisibility(By by, int timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitUntilLocated(By by) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitUntilInvisibilityOf(By by) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected void waitLongUntilInvisibilityOf(By by, int time) {
        new WebDriverWait(driver, time)
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


}
