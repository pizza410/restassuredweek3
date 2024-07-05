package methods;

import constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.StudentPojo;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Methods {

    public Response getallstudentinfo() {
        return given().when().get(EndPoints.GET_ALL_STUDENT);
    }

    public Response createstudent(String firstName, String lastName, String email, String programme, List<String> courselist){
        StudentPojo studentpojo=new StudentPojo();
        studentpojo.setFirstName(firstName);
        studentpojo.setCourses(courselist);
        studentpojo.setEmail(email);
        studentpojo.setLastName(lastName);
        studentpojo.setProgramme(programme);

        Response response=given().contentType(ContentType.JSON).body(studentpojo).when()
                .post(EndPoints.CREATE_DATA);
        return response;
    }

    public HashMap<String,Object> extractemail(String email){
       HashMap<String,Object> studentMap = given().when().get(EndPoints.GET_ALL_STUDENT)
               .then().extract()
                .path("findAll{it.email=='"+email+"'}.get(0)");
       return studentMap;
    }

    public Response updatedata(int studentID,String firstNAme,String lastName,String email,String programme,List<String> cources){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName(firstNAme);
        studentPojo.setLastName(lastName);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(cources);

        return given().log().all().contentType(ContentType.JSON).pathParams("id",studentID).body(studentPojo).when()
                .put(EndPoints.BY_ID);
    }



    public void deletedatabyid(int studentID){
        given().pathParams("id",studentID).when().delete(EndPoints.BY_ID)
                .then().statusCode(204);
    }

    public void getstudentbyid(int studentID){
        given().pathParams("id",studentID).when().get(EndPoints.BY_ID).then()
                .statusCode(404);
    }
}
