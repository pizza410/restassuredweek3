package bdds4.testbase;

import bdds4.utilities.PropertyReader;
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
