package browser.base;

import helper.PropHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.lang.*;
import java.util.Properties;
import java.util.Set;

/**
 * Created by admin.son.ton on 1/23/18.
 */
public class Browser {

    protected WebDriver driver;
    protected Properties properties;
    protected Logger logger = Logger.getLogger(Browser.class);

    protected Browser(){
        properties = PropHelper.loadPropertiesByFilePath("src/test/resources/browser.properties");
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

    public String getUrl() {return driver.getCurrentUrl(); }

    public byte[] takeScreenShot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    public String getHtml(){
        return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.getElementsByTagName('body')[0].innerHTML"));
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public void openNewTab(String url){
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", url);
        Set<String> winHandles = driver.getWindowHandles();
        String[] windHandlesArray = winHandles.toArray(new String[0]);
        driver.switchTo().window(windHandlesArray[windHandlesArray.length-1]);
    }
}
