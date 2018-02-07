package test_runner;

import browser.Browser;
import cucumber.api.testng.TestNGCucumberRunner;
import global.Global;
import helper.PageHierarchy;
import helper.YamlHelper;
import org.testng.annotations.*;

import java.util.HashMap;

public class BaseTestRunner {

    static TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite
    public void initConfiguration(){
        Global.config = YamlHelper.loadToMap("/config/wishlist-pre-config.yml");
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

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() throws Exception {
        Global.browser = new Browser("chrome");
        Global.pageHierarchy = new PageHierarchy();
    }
    @AfterMethod(alwaysRun = true)
    public void teardownBrowser() throws Exception {
        Global.browser.tearDown();
    }
}
