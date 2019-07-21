package Runner;

import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/java/Feature"
        ,glue= "bindings",
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true
)

public class testrunner {
   // @AfterClass
   //public static void writeExtentReport() { Reporter.loadXMLConfig(new File("config/report.xml"));

   // }
}