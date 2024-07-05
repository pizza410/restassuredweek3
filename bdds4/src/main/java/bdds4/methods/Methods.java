package bdds4.methods;

import bdds4.constants.EndPoints;
import bdds4.pojo.StudentPojo;
import bdds4.utilities.Utilities;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.rest.RestRequests.given;

public class Methods {
    String firstName;

    public Response getfulllist(){
       return given().when().get(EndPoints.GET_FULL);
    }

    public Response getdataBYID(int ID){
       return given().pathParams("id",ID).when().get(EndPoints.GET_BY_ID);
    }

    public Response createnewData(String _firstName,String _lastName,String _email,String _programme,String _course){
       firstName=_firstName+ Utilities.getRandomValue();
        String lastName=_lastName+Utilities.getRandomValue();
        String email=Utilities.getRandomValue()+_email;
        List<String> cources=new ArrayList<>();
        cources.add(_course);

        StudentPojo studentpojo=new StudentPojo();
        studentpojo.setCourses(cources);
        studentpojo.setEmail(email);
        studentpojo.setFirstName(firstName);
        studentpojo.setLastName(lastName);
        studentpojo.setProgramme(_programme);

        return given().contentType(ContentType.JSON).body(studentpojo).when()
                .post(EndPoints.CREATE_DATA);

    }
    public HashMap<String,Object> fetchidnumber(){
       HashMap<String,Object> data= given().when().get(EndPoints.GET_FULL).then()
                .extract().path("findAll{it.firstName=='"+firstName+"'}[-1]");
       return data;
    }

    public Response updatedata(int ID,String _firstName,String _lastName,String _email,String _programme,String _course){
        String firstName=_firstName+ Utilities.getRandomValue();
        String lastName=_lastName+Utilities.getRandomValue();
        String email=Utilities.getRandomValue()+_email;
        List<String> cources=new ArrayList<>();
        cources.add(_course);

        StudentPojo studentpojo=new StudentPojo();
        studentpojo.setCourses(cources);
        studentpojo.setEmail(email);
        studentpojo.setFirstName(firstName);
        studentpojo.setLastName(lastName);
        studentpojo.setProgramme(_programme);

       return given().contentType(ContentType.JSON).pathParams("id",ID).body(studentpojo)
                .when().put(EndPoints.GET_BY_ID);

    }
}
