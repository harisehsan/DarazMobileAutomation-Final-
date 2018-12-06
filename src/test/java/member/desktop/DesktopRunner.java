package member.desktop;

import _base.TestRunner;
import cucumber.api.CucumberOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin.son.ton on 1/17/18.
 *
 *
 */

@CucumberOptions(
        features = {"src/test/java/member/desktop/features"},
        tags = {"@Address_PC"},
        glue = {"member.desktop.step_definitions"})
public class DesktopRunner extends TestRunner {}
