package methods;

import constants.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Studentpojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Methods {
    String firstName;

    public Response getfullinfo(){
        return given().when().get(Endpoints.GET_FULL);
    }
     public void validategetfulldatainfo(Response response){
        response.then().statusCode(200);
    }

    public Response getdatabyID(int ID){
        return given().log().all().pathParams("id",ID).when().get(Endpoints.GET_BY_ID);
    }
    public void verifygetbyidresponse(Response response){
        response.then().log().all().statusCode(200);
    }

    public Response createdata(String _firstName,String _lastName,String _email,String _programme,String _course){
        firstName=_firstName+bdds2.utilities.Utilities.getRandomValue();
        String lastName=_lastName+bdds2.utilities.Utilities.getRandomValue();
        String email=bdds2.utilities.Utilities.getRandomValue()+_email;
        List<String> courselist=new ArrayList<>();
        courselist.add(_course);

        Studentpojo studentpojo=new Studentpojo();
        studentpojo.setFirstName(firstName);
        studentpojo.setLastName(lastName);
        studentpojo.setEmail(email);
        studentpojo.setCourses(courselist);
        studentpojo.setProgramme(_programme);
        return given().contentType(ContentType.JSON).body(studentpojo).when().post(Endpoints.CREATE_DATA);
    }

    public Response updatebyID(int studentID,String _firstName,String _lastName,String _email,String _programme,String _course){
       String firstName=_firstName+bdds2.utilities.Utilities.getRandomValue();
        String lastName=_lastName+bdds2.utilities.Utilities.getRandomValue();
        String email=bdds2.utilities.Utilities.getRandomValue()+_email;
        List<String> courselist=new ArrayList<>();
        courselist.add(_course);

        Studentpojo studentpojo=new Studentpojo();
        studentpojo.setFirstName(firstName);
        studentpojo.setLastName(lastName);
        studentpojo.setEmail(email);
        studentpojo.setCourses(courselist);
        studentpojo.setProgramme(_programme);

        return given().contentType(ContentType.JSON).pathParams("id",studentID).body(studentpojo)
                .when()
                .put(Endpoints.GET_BY_ID);
    }

    public HashMap<String,Object> extractid(){
        return given().when().get(Endpoints.GET_FULL).then().extract()
                .path("findAll{it.firstName=='"+firstName+"'}[-1]");
    }

    public Response deletebyID(int studentID){
       return given().pathParams("id",studentID).when().delete(Endpoints.GET_BY_ID);

    }
}
