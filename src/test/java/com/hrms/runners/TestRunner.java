package com.hrms.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)


@CucumberOptions(features = "src/test/resources/features",//need to give a path for our feature files and
                        glue = "com/hrms/stepdefinitions",// we need to glue our step definitions - implementation
                        dryRun = false,   //when set is true and you have unimplemented steps , will run over the feature steps and reveal unimplemented steps in console
                                          //if dryRun=true and the is no unimplemented method it will not run at all, if its false will skipp dryRun
                                          //-->to run multiple tags  tags = {"@smoke","@whatever"}
                        tags="@validCredentials",   //adding tag to run specific scenario
                        strict =false ,   // when strict is true when you run and it will find at least 1 unimplemented step it will fail,if its false will skipp strict
                        plugin={"pretty", //will print steps inside console
                                "html:target/cucumber-default-reports", //html: and then pass folder you want to have report in
                                "rerun:target/FailedTests.txt", //creating file for only failed scenarios with .txt extensions
                                "json:target/cucumber.json"} //generates JavaScript Object Notation,is a way to store information in an organized, easy-to-access manner.
)
public class TestRunner {

}
