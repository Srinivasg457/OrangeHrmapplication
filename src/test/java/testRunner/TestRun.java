package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/java/Features/OrangeHRMapplication.feature",
        glue = {"stepDefinations", "hooks"},
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html", // HTML Report
                "json:target/cucumber-reports/cucumber.json", // JSON Report
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // Extent Reports
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",  // <-- updated plugin name
        },
        monochrome = true

)
public class TestRun {
}
