package bdds2;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/featurefile"
                    ,glue="bdds2.steps")
public class Runnerfile {
}
