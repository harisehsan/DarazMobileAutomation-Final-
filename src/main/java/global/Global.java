package global;

import browser.base.Browser;
import initializer.PageHierarchy;

import java.util.Map;
import com.typesafe.config.Config;

/**
 * Created by admin.son.ton on 1/23/18.
 */
public class Global {

    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<PageHierarchy> tlPageHierarchy = new ThreadLocal<>();
    private static ThreadLocal<Map<String,Object>> tlMap = new ThreadLocal<>();

    private static Config config;

    public static Browser getBrowser(){
        return tlBrowser.get();
    }

    public static void setBrowser(Browser browser){
        tlBrowser.set(browser);
    }

    public static PageHierarchy getPageHierachy(){
        return tlPageHierarchy.get();
    }

    public static void setPageHierarchy(PageHierarchy pageHierarchy){
        tlPageHierarchy.set(pageHierarchy);
    }

    public static Map<String,Object> getMap(){
        return tlMap.get();
    }

    public static void setMap(Map<String,Object> map){
        tlMap.set(map);
    }

    public static Config getConfig(){
        return config;
    }

    public static void setConfig(Config globalConfig){
        config = globalConfig;
    }
}
