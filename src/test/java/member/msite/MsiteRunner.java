package member.msite;

import base.CucumberRunner;
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
        features = {"src/test/java/member/msite/features"},
        tags = {"@Member_Msite"},
        glue = {"member.msite.step_definitions"})
public class MsiteRunner extends CucumberRunner {}
