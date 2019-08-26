package test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber-report/cucumber.json"
                , "rerun:target/failure/rerun.txt"}
        ,features = "src/test/features",
        glue = {"test.steps"}
        )

public class RunCucumberIT { }