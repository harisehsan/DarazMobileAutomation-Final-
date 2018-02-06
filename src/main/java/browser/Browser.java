package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.*;

/**
 * Created by admin.son.ton on 1/23/18.
 */
public class Browser {

    private WebDriver driver;

    public Browser(String browserName){
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            driver = new ChromeDriver();
        }
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
}
