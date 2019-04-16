package digital_goods.mobileTopup.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features="@target/rerun.txt",
        tags = "@TopupMobileSmokeSG",
        glue={"lazada.topup.steps", "global.steps", "lazada.login.steps", "lazada.steps"},
        plugin = {"pretty", "html:target/site/cucumber-pretty",
                "json:target/cucumber.json"}
)

public class RestartFaildScenarios extends BaseRunner {

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

}
