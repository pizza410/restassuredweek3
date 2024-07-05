package bdds1.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import utilities.PropertyReader;

public class BaseTest {
    public static PropertyReader propertyReader;
    @BeforeClass
    public static void inIT(){
        propertyReader=PropertyReader.getInstance();
        RestAssured.baseURI=propertyReader.getProperty("local.URL");
        RestAssured.port=Integer.parseInt(propertyReader.getProperty("student.PORT"));
       /* RestAssured.basePath="/student";*/
    }
}
