package base;

import allure.AllureGenerator;
import browser.factory.BrowserFactory;
import cucumber.api.testng.TestNGCucumberRunner;
import global.Global;
import initializer.ConfigInit;
import initializer.PageHierarchy;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.HashMap;

public class CucumberRunner {

    protected static TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite
    public void initConfiguration(){
        Global.setConfig(ConfigInit.loadConfig(System.getProperty("env")));
        AllureGenerator.removeAllureResultFolder();
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
        Global.setMap(new HashMap<>());
        Global.setBrowser(BrowserFactory.createBrowser());
        Global.setPageHierarchy(new PageHierarchy());
    }

    @AfterMethod(alwaysRun = true)
    public void teardownBrowser(ITestResult result) throws Exception {
        Global.getBrowser().tearDown();
    }
}
