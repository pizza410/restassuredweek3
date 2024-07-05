package bdds2.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import methods.Methods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class crudsteps {
    Methods methods=new Methods();
    Response respons;
    int studentID;
    Response response1;


    @When("^I send Get request I received full data$")
    public void iSendGetRequestIReceivedFullData() {
        Response response=methods.getfullinfo();
        methods.validategetfulldatainfo(response);
    }

    @And("^I fetchdata by providing specific ID$")
    public void iFetchdataByProvidingSpecificID() {
        Response response=methods.getdatabyID(25);
        methods.verifygetbyidresponse(response);
    }

    @And("^I create Data by passing followingdata$")
    public void iCreateDataByPassingFollowingdata(DataTable datable) {

        List<Map<String,String>> rows=datable.asMaps(String.class,String.class);
        for(Map<String,String> columns:rows){
            respons=methods.createdata(columns.get("firstName"),columns.get("lastName"),columns.get("email"),columns.get("programme"),columns.get("courses"));

        }
        respons.then().log().all().statusCode(201);

    }

    @And("^I verify Data has been created successfully$")
    public void iVerifyDataHasBeenCreatedSuccessfully() {
      /*  Studentpojo studentpojo=new Studentpojo();
        int StudendID=(int) studentpojo.getId();
        System.out.println(StudendID);*/
    }

    @And("^I extract that data using id and update that data using following data$")
    public void iExtractThatDataUsingIdAndUpdateThatDataUsingFollowingData(DataTable datatable) {

        List<Map<String,String>> rows=datatable.asMaps(String.class,String.class);
        for(Map<String,String> columns:rows){
            response1=methods.updatebyID(studentID,columns.get("firstName"),columns.get("lastName"),columns.get("email"),columns.get("programme"),columns.get("courses"));
        }
        response1.then().log().all().statusCode(200);

    }

    @And("^I extract student ID$")
    public void iExtractStudentID() {
        HashMap<String,Object> newstudentdata=methods.extractid();
        studentID=(int) newstudentdata.get("id");
        System.out.println(studentID);

    }

    @And("^I delete the data of same ID$")
    public void iDeleteTheDataOfSameID() {
       Response response= methods.deletebyID(studentID);
       response.then().log().all().statusCode(204);

    }

    @Then("^I try to fetch the same data$")
    public void iTryToFetchTheSameData() {
        Response response=methods.getdatabyID(studentID);
        response.then().statusCode(404);

    }
}
