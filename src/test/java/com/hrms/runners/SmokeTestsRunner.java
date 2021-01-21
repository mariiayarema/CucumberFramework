package com.hrms.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/hrms/stepdefinitions",
        tags = "@smoke",
        plugin = {"pretty",
                "html:target/cucumber-default-reports",
                "rerun:target/SmokeTests.txt",
                "json:target/smoke.json"
        }
)


public class SmokeTestsRunner {

}
