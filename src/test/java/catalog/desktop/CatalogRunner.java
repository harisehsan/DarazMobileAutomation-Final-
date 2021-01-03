package catalog.desktop;


import _base.TestRunner;
import cucumber.api.CucumberOptions;

/**
 * Created by Shahbaz.Gull on 1/02/19.
 *
 *
 */

@CucumberOptions(
        features = {"src/test/java/catalog/desktop/features"},
        tags = {"@20128963"},
        glue = {"catalog.desktop.step_definitions"})

public class CatalogRunner extends TestRunner {
}
