package browser;

import browser.base.Browser;
import helper.OsHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class Firefox extends Browser {

    public Firefox(String [] options){
        System.setProperty("webdriver.gecko.driver", properties.getProperty(OsHelper.getOperatingSystemType() +".firefox.driver.path"));
        driver = new FirefoxDriver(parseOptions(options));
        logger.info(String.format("Initiate Browser: Firefox with Options: %s Successfully", Arrays.toString(options)));
    }

    private FirefoxOptions parseOptions(String [] options){
        FirefoxOptions fOptions = new FirefoxOptions();
        fOptions.setAcceptInsecureCerts(true);
        Optional<String> userAgent = Arrays.stream(options).filter(t-> t.startsWith(USER_AGENT_OPTS_PREFIX)).findAny();
        if(userAgent.isPresent()){
            FirefoxProfile fProfile = new FirefoxProfile();
            fProfile.setPreference("general.useragent.override", userAgent.get().replace(USER_AGENT_OPTS_PREFIX, ""));
            fOptions.setProfile(fProfile);
            options = ArrayUtils.removeElement(options,userAgent.get());
        }
        fOptions.addArguments(options);
        return fOptions;
    }
}
