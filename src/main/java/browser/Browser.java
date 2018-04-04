package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.*;
import java.nio.file.Paths;

/**
 * Created by admin.son.ton on 1/23/18.
 */
public class Browser {

    private WebDriver driver;

    public Browser(String browserName){
        String baseDir = System.getProperty("user.dir");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", baseDir + "/src/main/resources/data/linux/chromedriverlinux");
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

    public String getUrl() {return driver.getCurrentUrl(); }

}
