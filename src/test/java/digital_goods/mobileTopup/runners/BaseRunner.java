package digital_goods.mobileTopup.runners;

import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.sleep;

public class BaseRunner {

   public static TestNGCucumberRunner testNGCucumberRunner;


    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }

    /*@Parameters({ "browser", "environment", "platform" })
    @BeforeMethod(alwaysRun = true)
    public void setupBrowser(String browser, String environment) throws Exception {
        if(browser.equals("Chrome")){

        } else if(browser.equals("Firefox")){

        } else if(browser.equals("UC_Browser")){

        } else if(browser.equals("Safari")){

        }else{

        }
    }*/

    @AfterMethod(alwaysRun = true)
    public void teardownBrowser() throws Exception {
        sleep(300);
        close();
    }
}



