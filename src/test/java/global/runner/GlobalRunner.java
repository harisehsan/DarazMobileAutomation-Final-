package global.runner;


import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import global.Drivers;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

// mvn test -Dcucumber.options="src/test/java/lazada/topup/features --tags @SelectOperatorBlockManual --glue lazada.topup.steps --glue global.steps --glue lazada.login.steps --glue lazada.global.steps" -Dbrowser=chrome -Ddevice=mobile -Durl=https://my-p.lazada.co.th/mobilerecharge?wh_weex=true
// mvn test -Dbrowser=chrome -Ddevice=mobile -Durl=https://my-m.lazada.co.th/mobilerecharge

@CucumberOptions(
        //features="src/test/java/lazada/topup/features",
        //tags = {"@SelectOperatorBlockManual"},
        //tags = {"@Debug"},
        //glue={"lazada.topup.steps", "global.steps", "lazada.login.steps", "lazada.global.steps"},
        format = {"pretty"}
)
public class GlobalRunner {

    public static TestNGCucumberRunner testNGCucumberRunner;
    public Drivers drvs = new Drivers();

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass(){
        testNGCucumberRunner.finish();
    }


    //String browser = "chrome";
    //String device = "mobile";
    //String url = "https://my-m.lazada.co.th/mobilerecharge";

    @Parameters({ "browser", "device", "url" })
    @BeforeMethod(alwaysRun = true)
    public void setupBrowser(String browser, String device, String url){

        String brow = browser.toLowerCase();
        String dev = device.toLowerCase();

        if(brow.equals("chrome")){
            if(device.equals("mobile")) {
                WebDriverRunner.setWebDriver(drvs.getChromeDriverMobile());
            }
            else if(device.equals("desktop")) {
                WebDriverRunner.setWebDriver(drvs.getChromeDriver());
            }else {
                Assert.fail("Device parameter='" + device + "' is invalid");
            }
        }else if(brow.equals("firefox")){

        }else if(brow.equals("uc_browser")){

        }else if(brow.equals("safari")){

        }else if(brow.equals("null")){
            return;
        }else{
            Assert.fail("Browser parameter='" + browser + "' is invalid");
        }

        if(url.toLowerCase().equals("null")) {
            return;
        }else if(url.length() != 0 ){
            open(url);
        }else{
            Assert.fail("Browser url is empty");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void teardownBrowser(){
        sleep(300);
        close();
    }




}

