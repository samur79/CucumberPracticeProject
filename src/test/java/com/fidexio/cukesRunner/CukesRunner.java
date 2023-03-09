package com.fidexio.cukesRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                        "html:target/cucumber-reports.html",
                        "rerun:target/rerun.txt",
                        "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"

        },
        features = "src/test/resources/features",
        glue = "com/fidexio/step_definitions",
        dryRun = false,
        tags ="@FIDEX10-350",
        publish = false



)
public class CukesRunner {


}
