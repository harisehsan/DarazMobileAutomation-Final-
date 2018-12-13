package browser.base;

import helper.PropHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.lang.*;
import java.util.*;

/**
 * Created by admin.son.ton on 1/23/18.
 */
public class Browser {

    protected WebDriver driver;
    protected Properties properties;
    protected Logger logger = Logger.getLogger(Browser.class);

    protected static final String USER_AGENT_OPTS_PREFIX = "user-agent=";

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


    public void switchToTab(String windowHandleId){
        driver.switchTo().window(windowHandleId);
    }

    public String currentWindowHandleId(){
        return driver.getWindowHandle();
    }

    public Map<String,String> getCookiesAsMap(){
        Map<String,String> cookiesMap = new HashMap<>();
        Set<Cookie> cks = driver.manage().getCookies();
        for (Cookie cookie : cks) {
            cookiesMap.put(cookie.getName(), cookie.getValue());
        }
        return cookiesMap;
    }

    public JavascriptExecutor getJsExecutor(){
        return ((JavascriptExecutor) driver);
    }

    public void addCookie(String name, String value) {
        Cookie ck = new Cookie(name, value);
        driver.manage().deleteCookieNamed(name);
        driver.manage().addCookie(ck);
    }
}
