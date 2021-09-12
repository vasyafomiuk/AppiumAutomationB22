package com.cybertek.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/cybertek/automation/step_definitions",
        dryRun = true,
        tags = "@search_results"
)
public class CukesRunner {
}
