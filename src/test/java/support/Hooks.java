package support;

import browser.Browser;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import global.Global;
import helper.PageHierarchy;
import helper.YamlHelper;

import java.util.HashMap;

public class Hooks {
    @Before
    public void initializeTest(){
        Global.config = YamlHelper.loadToMap("/config/wishlist-pre-config.yml");

        Global.map = new HashMap<>();

        Global.browser = new Browser("chrome");

        Global.pageHierarchy = new PageHierarchy();
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                // Code to capture and embed images in test reports (if scenario fails)
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Global.browser.tearDown();
    }
}
