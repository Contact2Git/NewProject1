package stepefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Feature"
		,glue={"stepefinitions"},
		plugin = {"pretty",
				  "junit:target/JUnitReport/report.xml",
				  "json:target/JSONReport/report.json",
				  "html:target/HTMLReport/report.html"}
		)
public class TestRunner {
	

}
