package member.desktop;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import _base.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * Created by admin.son.ton on 1/17/18.
 *
 *
 */

@CucumberOptions(
        features = {"src/test/java/member/desktop/features"},
        tags = {"@Loginbyemail"},
        glue = {"member.desktop.step_definitions"})
public class DesktopRunner extends TestRunner {

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }
}
