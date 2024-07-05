package bdds1.stepdefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import methods.Methods;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class crudsteps {
    Methods methods=new Methods();
    ValidatableResponse validatableResponse;
    String email;
    int studentID;
    ValidatableResponse validatableResponse1;
    @When("^I create a new student by providing the information firstName \"([^\"]*)\"lastName\"([^\"]*)\"email\"([^\"]*)\"programme\"([^\"]*)\"courses\"([^\"]*)\"$")
    public void iCreateANewStudentByProvidingTheInformationFirstNameLastNameEmailProgrammeCourses(String _firstName, String _lastName, String _email, String _programme, String _courses) {
        String firstName=_firstName+ Utilities.getRandomValue();
        String lasName=_lastName+Utilities.getRandomValue();
        email= Utilities.getRandomValue()+_email;
        List<String> courses=new ArrayList<>();
        courses.add(_courses);

        validatableResponse=methods.createstudent(firstName,lasName,email,_programme,courses).then();

    }

    @Then("^I verify with \"([^\"]*)\" is created$")
    public void iVerifyWithIsCreated(String _email)  {
        HashMap<String, Object> studentMap = methods.extractemail(email);
        studentID=(int) studentMap.get("id");
        System.out.println(studentID);
    }

    @When("^I update data with firstName\"([^\"]*)\" lastName\"([^\"]*)\"email\"([^\"]*)\" programme \"([^\"]*)\"course\"([^\"]*)\"$")
    public void iUpdateDataWithFirstNameLastNameEmailProgrammeCourse(String _firstName, String _lastName, String _email, String _programme, String _course){
        String firstName=_firstName+Utilities.getRandomValue();
        String lastName=_lastName+Utilities.getRandomValue();
        String email=Utilities.getRandomValue()+_email;
        List<String> courses=new ArrayList<>();
        courses.add(_course);
        courses.add("English");

        validatableResponse1= methods.updatedata(studentID,firstName,lastName,email,_programme,courses)
                .then();

    }


    @And("^I verify the status code$")
    public void iVerifyTheStatusCode() {
        System.out.println(validatableResponse1.extract().statusCode());
    }

    @And("^I Delete that data$")
    public void iDeleteThatData() {
        methods.deletedatabyid(studentID);
    }

    @And("^I verify using get request$")
    public void iVerifyUsingGetRequest() {
        methods.getstudentbyid(studentID);
    }


}
