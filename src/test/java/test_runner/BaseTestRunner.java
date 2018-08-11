package test_runner;

import browser.Browser;
import cucumber.api.testng.TestNGCucumberRunner;
import global.Global;
import helper.ConfigHelper;
import helper.EnvHelper;
import helper.PageHierarchy;
import helper.YamlHelper;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.HashMap;

public class BaseTestRunner {

    static TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite
    public void initConfiguration(){
        Global.config = ConfigHelper.loadConfig(System.getProperty("env"));
        Global.map = new HashMap<>();
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }

    @BeforeMethod
    public void setupBrowser() throws Exception {
        Global.browser = new Browser("chrome");
        Global.pageHierarchy = new PageHierarchy();
    }

    @AfterMethod(alwaysRun = true)
    public void teardownBrowser(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            Global.browser.takeScreenShot();
            Global.browser.dumpDOMToFile();
        }

        Global.browser.tearDown();
    }
}
