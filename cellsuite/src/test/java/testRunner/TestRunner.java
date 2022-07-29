package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = {"stepDefinition"},
    tags = "@usermanagement",
    //tags = "@reagentFeature",
    monochrome = false,
    plugin = {"pretty", "html:target/htmlReport/reports.html",
                        "json:target/jsonReport/reports.json",
                        "junit:target/junitReport/reports.xml"}
)
class TestRunner {
    
}
