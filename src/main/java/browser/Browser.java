package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Base_Page;
import java.lang.*;

/**
 * Created by admin.son.ton on 1/23/18.
 */
public class Browser {

    private WebDriver driver;

    public Browser(String browserName){
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "/usr/local/Cellar/chromedriver/2.34/bin/chromedriver");
            driver = new ChromeDriver();
        }
    }

    private void highLight(WebElement ele){
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", ele);
    }

    public void tearDown(){
        driver.quit();
    }

    public WebDriver getWebDriver(){
        return driver;
    }

    public void goTo(String url){
        driver.get(url);
    }

    public void waitUntilVisible(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public String currentUrl(){
        return driver.getCurrentUrl();
    }

    public WebElement findDynamicElement(By by){
        return driver.findElement(by);
    }

    public void waitUntilPresentOfElementBy(By by){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilClickable(By by){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilLocated(By by) {
        new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilInvisibilityOf(By by) {
        new WebDriverWait(driver,30)
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitLongUntilInvisibilityOf(By by, int time) {
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

}
