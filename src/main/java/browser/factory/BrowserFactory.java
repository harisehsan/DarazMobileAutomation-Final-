package browser.factory;

import browser.base.Browser;
import helper.PropHelper;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class BrowserFactory {


    private static final String BROWSER_SETTING_PROP_PATH = "src/test/resources/browser.properties";
    private static final String BROWSER_PACKAGE = "browser.";
    private Properties browserInitializeInfo;

    private BrowserFactory() {
        browserInitializeInfo = PropHelper.loadPropertiesByFilePath(BROWSER_SETTING_PROP_PATH);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Browser> T createBrowser() {
        BrowserFactory bf = new BrowserFactory();
        String browserName = bf.getBrowserNameFromConfig().toLowerCase();
        String [] browserOptions = bf.getBrowserOptionsFromComfig(browserName);
        try {
            Class<?> cls = Class.forName(BROWSER_PACKAGE + StringUtils.capitalize(browserName) );
            return (T) cls.getConstructor(browserOptions.getClass()).newInstance(new Object[]{browserOptions});
        } catch (InstantiationException | ClassNotFoundException |InvocationTargetException|NoSuchMethodException| IllegalAccessException e) {
            throw new RuntimeException(String.format("Can not create browser: %s, With options: %s, ERROR: %s", browserName, Arrays.toString(browserOptions), e.getMessage()));
        }
    }

    private String getBrowserNameFromConfig() {
        String browserNameKey = "browser";
        if (System.getProperty(browserNameKey) == null) {
            return browserInitializeInfo.getProperty(browserNameKey);
        }
        return System.getProperty(browserNameKey);
    }

    private String[] getBrowserOptionsFromComfig(String browserName){
        String browserTheme = System.getProperty("theme");
        String browserOptionsKey = browserTheme+"."+browserName+".browser.options";
        String optionStringFromConfig = browserInitializeInfo.getProperty(browserOptionsKey);
        String optionStringFromSystem = System.getProperty("browser.options");
        if(optionStringFromConfig==null && optionStringFromSystem==null) return new String[0];
        optionStringFromSystem = optionStringFromSystem == null ? "" : optionStringFromSystem;
        String optionString = String.format("%s,%s",optionStringFromConfig,optionStringFromSystem);
        return optionString.split(",");
    }
}