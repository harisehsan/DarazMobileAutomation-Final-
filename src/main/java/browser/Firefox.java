package browser;

import browser.base.Browser;
import helper.OsHelper;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.Arrays;

public class Firefox extends Browser {

    public Firefox(String [] options){
        System.setProperty("webdriver.gecko.driver", properties.getProperty(OsHelper.getOperatingSystemType() +"firefox.driver.path"));
        FirefoxOptions fOptions = new FirefoxOptions();
        fOptions.addArguments(options);
        driver = new FirefoxDriver(fOptions);
        logger.info(String.format("Initiate Browser: Firefox with Options: %s Successfully", Arrays.toString(options)));
    }
}
