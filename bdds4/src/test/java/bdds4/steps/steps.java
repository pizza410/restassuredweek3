package bdds4.steps;

import bdds4.methods.Methods;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class steps {
    Methods methods=new Methods();
    Response response;
    Response response1;
    int idNUmber;
    @When("^I send GET list request I receive full list$")
    public void iSendGETListRequestIReceiveFullList() {
       methods.getfulllist().then().statusCode(200);

    }

    @And("^I try to acces data by ID$")
    public void iTryToAccesDataByID() {
        methods.getdataBYID(25).then().log().all().statusCode(200);
    }

    @And("^I create new data by following details$")
    public void iCreateNewDataByFollowingDetails(DataTable datatable){
        List<Map<String,String>> rows=datatable.asMaps(String.class,String.class);
        for(Map<String,String> columns:rows){
            response=methods.createnewData(columns.get("firstName"),columns.get("lastName"),columns.get("email"),columns.get("programme"),columns.get("cources"));
        }
        response.then().log().all().statusCode(201);
    }

    @And("^I fetch id number$")
    public void iFetchIdNumber() {
       HashMap<String, Object> data= methods.fetchidnumber();
       idNUmber=(int)data.get("id");
        System.out.println(idNUmber);
    }

    @And("^I update that id numbers data as below$")
    public void iUpdateThatIdNumbersDataAsBelow(DataTable datatable) {
        List<Map<String,String>> rows=datatable.asMaps(String.class,String.class);
        for (Map<String ,String> columns:rows){
           response1= methods.updatedata(idNUmber,columns.get("firstName"),columns.get("lastName"),columns.get("email"),columns.get("programme"),columns.get("cources"));

        }
       response1.then().log().all().statusCode(200)
;    }
}
