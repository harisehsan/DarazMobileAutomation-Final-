package checkout.desktop;

import _base.TestRunner;
import cucumber.api.CucumberOptions;

/**
 * Created by admin.son.ton on 1/17/18.
 *
 *
 */

@CucumberOptions(
        features = {"src/test/java/checkout/desktop/features"},
        tags = {"@17958367"},
        glue = {"checkout.desktop.step_definitions"})
public class DesktopRunner extends TestRunner{}
