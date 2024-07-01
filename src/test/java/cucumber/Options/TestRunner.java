package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",
		plugin={"pretty","json:target/json-reports/cucumber-reports.json"},
		monochrome=true,
		glue= {"stepDefinitions"})
public class TestRunner {

}
//"json:target/cucumber-reports/json-report.json"
//"html:target/cucumber-reports/report.html"
//tags= ("@Deleteplace")