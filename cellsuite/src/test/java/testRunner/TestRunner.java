package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = {"stepDefinition"},
    // tags = "@usermanagement",
    // tags = "@CC-1080_Create_new_Reagent",
    // tags = "@CC-1103_Create_new_Reagent_with_new_Culture_Reagent",
    // tags = "@CC-1128_Edit_one_reagent_item",
    tags = "@CC-1130_Edit_multiple_reagent_item",
    monochrome = false,
    plugin = {"pretty", "html:target/htmlReport/reports.html",
                        "json:target/jsonReport/reports.json",
                        "junit:target/junitReport/reports.xml"}
)
class TestRunner {

}
