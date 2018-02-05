package test_runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import global.Global;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import step_definitions.topup.TopupSteps;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"step_definitions"},
        tags = {"@TopupFull, @TopupPDP"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun-reports/rerun.txt"
        })



public class TopupTestRunner extends Base_TestRunner {

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
        Global.browser.tearDown();
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
}
