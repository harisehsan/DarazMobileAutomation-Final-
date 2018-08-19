package browser;

import browser.base.Browser;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox extends Browser {

    Firefox(String [] options){
        System.setProperty("webdriver.gecko.driver", properties.getProperty("firefox.driver.path"));
        FirefoxOptions fOptions = new FirefoxOptions();
        fOptions.addArguments(options);
        driver = new FirefoxDriver(fOptions);
    }
}
