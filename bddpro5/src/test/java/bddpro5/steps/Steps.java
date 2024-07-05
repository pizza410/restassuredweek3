package bddpro5.steps;

import bddpro5.classes.Datum;
import bddpro5.methods.Methods;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class Steps {
    Response response;
    Methods methods=new Methods();
    Response response1;
    Response response2;
    int IDnumber;
    @When("^I send get request i receive full info$")
    public void iSendGetRequestIReceiveFullInfo() {
        methods.getfullinfo().then().log().all().statusCode(200);

    }

    @And("^I create a new Data using data below$")
    public void iCreateANewDataUsingDataBelow(DataTable datatable) {
        List<Map<String,Object>> rows=datatable.asMaps(String.class,Object.class);
        for(Map<String,Object> columns:rows){
            response= methods.createnewData(columns.get("name"),columns.get("type"),columns.get("price"),columns.get("shipping"),columns.get("upc"),columns.get("description"),columns.get("manufacturer"),columns.get("model"),columns.get("url"),columns.get("image"));
        }
        Datum datum1=response.getBody().as(Datum.class);
        IDnumber=datum1.getId();
        System.out.println(datum1.getId());


    }

    @And("^I fetch the information by id to verify$")
    public void iFetchTheInformationByIdToVerify() {
        methods.getbyid(IDnumber).then().log().all().statusCode(200);
    }

    @And("^I update thet by id and following data$")
    public void iUpdateThetByIdAndFollowingData(DataTable datatable) {
        List<Map<String,Object>> rows=datatable.asMaps(String.class,Object.class);
        for(Map<String,Object> columns:rows){
            response1= methods.updatebyid(IDnumber,columns.get("name"),columns.get("type"),columns.get("price"),columns.get("shipping"),columns.get("upc"),columns.get("description"),columns.get("manufacturer"),columns.get("model"),columns.get("url"),columns.get("image"));
        }
        response1.then().log().all().statusCode(200);
    }

    @And("^I print firstname using id$")
    public void iPrintFirstnameUsingId() {
        Datum datum= methods.getbyid(IDnumber).getBody().as(Datum.class);
        System.out.println(datum.getName());
    }

    @And("^I delete that data using ID$")
    public void iDeleteThatDataUsingID() {
        response2= methods.deletebyID(IDnumber);
    }

    @Then("^I verify Status code$")
    public void iVerifyStatusCode() {
        response2.then().log().all().statusCode(200);
    }
}
