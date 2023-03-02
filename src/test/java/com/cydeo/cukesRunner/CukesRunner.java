package com.cydeo.cukesRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {     // "pretty", //basically it just prints out additional information about the scenario that is being executed.
                        "html:target/cucumber-reports.html",
                        "rerun:target/rerun.txt",
                        "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions", // it goes to stepdefinition package and check anything related to the project
        dryRun = false,
        // if dryRun=true it will only check the  steps and checks the missing ones so you can get the snippets of the missing ones if you have any
        //if dryRun=false it checks the steps and runs it as usual.
        tags ="@smoke",
        //if I write @student infront of tag only that part of test will be executed
        publish = false /* will enable a functionality from cucumber to generate a public link for the report of our final execution of our code
                --> the link will be automatically generated and printed in the console
                --> it will be ready to share with anyone */



)
public class CukesRunner {


}
