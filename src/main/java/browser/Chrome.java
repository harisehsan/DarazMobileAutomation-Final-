package browser;

import browser.base.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Arrays;

public class Chrome extends Browser {

    public Chrome(String [] options){
        System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver.path"));
        ChromeOptions cOptions = new ChromeOptions();
        cOptions.addArguments(options);
        driver = new ChromeDriver(cOptions);
        logger.info(String.format("Initiate Browser: Chrome with Options: %s Successfully",Arrays.toString(options)));
    }
}
