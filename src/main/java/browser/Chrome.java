package browser;

import browser.base.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome extends Browser {

    Chrome(String [] options){
        System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver.path"));
        ChromeOptions cOptions = new ChromeOptions();
        cOptions.addArguments(options);
        driver = new ChromeDriver(cOptions);
    }
}
