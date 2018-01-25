package support;

import browser.Browser;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import global.Global;

import java.util.HashMap;

public class Hooks {
    @Before
    public void initializeTest(){
        // Code to setup initial configurations
        Global.browser = new Browser("chrome");
        Global.map = new HashMap<String, Object>();
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        Global.browser.tearDown();
        if (scenario.isFailed()) {
            try {
                // Code to capture and embed images in test reports (if scenario fails)
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
