package bdds1.stepdefinations;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import methods.Methods;

public class stu1step {
    ValidatableResponse validatableResponse;
    Response response;
    Methods methods=new Methods();
    @When("^I send GET request$")
    public void iSendGETRequest() {
      response=methods.getallstudentinfo();

    }

    @Then("^I should receive full list$")
    public void iShouldReceiveFullList() {
       validatableResponse=response.then().log().all().statusCode(200);
    }
}
