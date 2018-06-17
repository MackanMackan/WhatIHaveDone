package MimicServiceProject.MimicService;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty" ,
        "html:Reports",
"junit:Reports/JunitReport.xml",
"json:Reports/JsonReport.json"},
monochrome = true) 


public class TestRunner {
}

