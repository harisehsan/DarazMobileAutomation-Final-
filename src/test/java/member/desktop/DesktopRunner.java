package member.desktop;

import _base.TestRunner;
import cucumber.api.CucumberOptions;
/**
 * Created by admin.son.ton on 1/17/18.
 *
 *
 */

@CucumberOptions(
        features = {"src/test/java/member/desktop/features"},
        tags = {"@17480501"},
        glue = {"member.desktop.step_definitions"})
public class DesktopRunner extends TestRunner {}
