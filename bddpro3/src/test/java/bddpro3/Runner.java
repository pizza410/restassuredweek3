package bddpro3;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/bddpro3/resources"
                 ,glue="bddpro3.steps")
public class Runner {
}
