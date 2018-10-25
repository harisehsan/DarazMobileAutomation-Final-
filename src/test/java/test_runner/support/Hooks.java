package test_runner.support;

import allure.AllureGenerator;
import browser.factory.BrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import global.Global;
import initializer.ConfigInit;
import initializer.PageHierarchy;

import java.util.HashMap;

public class Hooks {
    @Before
    public void initializeTest(){

        AllureGenerator.removeAllureResultFolder();

        Global.config = ConfigInit.loadConfig(System.getProperty("env"));

        Global.map = new HashMap<>();

        Global.browser = BrowserFactory.createBrowser();

//        Global.browser = new ChromeBrowser();

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
