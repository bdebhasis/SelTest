package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/Customer.feature"
        ,glue="stepDefinitions",
        dryRun=false,
        monochrome=true,
        plugin = {"pretty", "html:test-output"}
        )

public class testRunner {

	
	public testRunner() {
		// TODO Auto-generated constructor stub
		System.out.println("hi dd");
	}
}
