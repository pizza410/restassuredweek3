package bdds3.testbase;

import bdds3.utilities.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest {
    public static PropertyReader propertyReader;
    @BeforeClass
    public static void inIT(){
        RestAssured.baseURI= propertyReader.getProperty("student.URL");
        RestAssured.port=Integer.parseInt(propertyReader.getProperty("student.PORT"));

    }
}
