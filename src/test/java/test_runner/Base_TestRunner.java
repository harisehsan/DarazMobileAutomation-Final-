package test_runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.*;
import browser.Browser;
import global.Global;

import java.util.HashMap;

public class Base_TestRunner {

    protected static TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite
    public void initConfiguration(){
        //do some configuration
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }

    @BeforeTest(alwaysRun = true)
    public void setUp(){
        Global.browser = new Browser("chrome");
        Global.map = new HashMap<String, Object>();
    }

    @AfterTest
    public void tearDown(){
        Global.browser.tearDown();
    }
}
