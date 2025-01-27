package asc.desktop;

import _base.TestRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by admin.son.ton on 1/17/18.
 *
 *
 */

@CucumberOptions(
        features = {"src/test/java/member/features"},
        tags = {"@addaddresspclzd"},
        glue = {"member.step_definitions"})
public class DesktopRunner extends TestRunner {}
