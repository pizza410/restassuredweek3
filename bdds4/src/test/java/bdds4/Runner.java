package bdds4;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/featurefiles"
                    ,glue="bdds4.steps")
public class Runner {

}
