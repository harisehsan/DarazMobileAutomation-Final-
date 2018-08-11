package browser;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin.son.ton on 1/23/18.
 */
public class Browser {

    private WebDriver driver;

    public Browser(String browserName){
        String baseDir = System.getProperty("user.dir");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", baseDir + "/src/main/resources/data/chromedriver");
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

    public void takeScreenShot(){
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        String DateToStr = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss").format(new Date());
        File DestFile=new File(currentDir+"/failed_screenshot/"+DateToStr+".png");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dumpDOMToFile(){
        String currentDir = System.getProperty("user.dir");
        String DateToStr = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss").format(new Date());
        File htmlFile=new File(currentDir+"/failed_screenshot/"+DateToStr+".html");
        String dom = String.valueOf(((JavascriptExecutor) driver).executeScript("return document.getElementsByTagName('body')[0].innerHTML"));
        try (PrintWriter out = new PrintWriter(htmlFile)) {
            out.println(dom);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



}
