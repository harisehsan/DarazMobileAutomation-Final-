package homepage.desktop;

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
        features = {"src/test/java/homepage/desktop/features"},
        tags = {"@18174993"},
        glue = {"homepage.desktop.step_definitions"})
public class HomePageDesktopRunner extends _base.TestRunner { }
