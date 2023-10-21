package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)	
@CucumberOptions(features = "src/test/resources/Features/Post.feature", 
glue = { "tests" }, 
publish = true,
dryRun = false,
plugin = { "pretty", "json:target/cucumber.json" },
monochrome = true
//publish = true
//tags = "@valid"

)

public class TestRunner {
}

