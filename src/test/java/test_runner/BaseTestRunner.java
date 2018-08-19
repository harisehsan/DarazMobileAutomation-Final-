package test_runner;

import allure.AllureGenerator;
import browser.factory.BrowserFactory;
import cucumber.api.testng.TestNGCucumberRunner;
import global.Global;
import initializer.ConfigInit;
import initializer.PageHierarchy;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.HashMap;

public class BaseTestRunner {

    static TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite
    public void initConfiguration(){
        AllureGenerator.removeAllureResultFolder();
        Global.config = ConfigInit.loadConfig(System.getProperty("env"));
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
        Global.browser = BrowserFactory.createBrowser();
        Global.pageHierarchy = new PageHierarchy();
    }

    @AfterMethod(alwaysRun = true)
    public void teardownBrowser(ITestResult result) throws Exception {
        Global.browser.tearDown();
    }
}
