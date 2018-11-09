package digital_goods.mobileTopup.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features="src/test/java/digital_goods/mobileTopup/features",
        tags = "@TopupMobileSmokeSG",
        glue={"digital_goods.mobileTopup.steps", "global.steps", "member.msite.steps", "lazada.steps"},
        format = {"pretty", "html:target/cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"}
        )
public class Runner extends BaseRunner {

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

}
