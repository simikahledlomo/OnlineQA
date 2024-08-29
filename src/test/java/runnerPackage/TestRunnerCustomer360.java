package runnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags 		= "", 
				features 	={"src\\test\\resources\\Feature\\Customer360.feature"},
				glue 		= {"steps"},
				dryRun 		= false,
				monochrome 	= true,
				plugin = {"pretty", "html:target/Customer360TestReport.html"})
public class TestRunnerCustomer360 extends AbstractTestNGCucumberTests{

}
