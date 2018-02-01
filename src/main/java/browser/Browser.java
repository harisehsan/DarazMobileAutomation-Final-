package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Base_Page;

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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public String currentUrl(){
        return driver.getCurrentUrl();
    }

    public WebElement findDynamicElement(By by){
        return driver.findElement(by);
    }

    public void waitUntilPresentOfElementBy(By by){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public void wait(By by){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

//    public void waitUntilElementNotVisibleByXpath(String xpath){
//        WebElement explicitWait = (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
//    }
//    public void waitUntilElementNotVisibleByXCss(String css){
//        WebElement explicitWait = (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
//    }




}
