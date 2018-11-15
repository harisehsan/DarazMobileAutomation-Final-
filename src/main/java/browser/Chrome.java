package browser;

import browser.base.Browser;
import helper.OsHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.Collections;

public class Chrome extends Browser {

    public Chrome(String [] options){
        System.setProperty("webdriver.chrome.driver", properties.getProperty(OsHelper.getOperatingSystemType() +".chrome.driver.path"));
        ChromeOptions cOptions = new ChromeOptions();
        cOptions.addArguments(options);
        cOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(cOptions);
        logger.info(String.format("Initiate Browser: Chrome with Options: %s Successfully",Arrays.toString(options)));
    }
}
