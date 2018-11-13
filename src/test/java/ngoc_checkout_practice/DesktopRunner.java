package ngoc_checkout_practice;

import _base.TestRunner;
import cucumber.api.CucumberOptions;

/**
 * Created by admin.son.ton on 1/17/18.
 *
 *
 */

@CucumberOptions(
        features = {"src/test/java/ngoc_checkout_practice/desktop/features"},
        tags = {"@17757740"},
        glue = {"ngoc_checkout_practice.desktop.step_definitions"})
public class DesktopRunner extends TestRunner{}

