package global;

import browser.Browser;
import helper.PageHierarchy;

import java.util.Map;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Created by admin.son.ton on 1/23/18.
 */
public class Global {

    public static Browser browser;

    public static Map<String,Object> map;

    public static Config config;

    public static PageHierarchy pageHierarchy;
}
