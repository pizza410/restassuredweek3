package bdds2.basetest;

import bdds2.utilities.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class Testbase {
    public static PropertyReader propertyReader;
    @BeforeClass
    public static void inIT(){
        propertyReader=PropertyReader.getInstance();
        RestAssured.baseURI=propertyReader.getProperty("student.URL");
        RestAssured.port=Integer.parseInt(propertyReader.getProperty("student.PORT"));
    }
}
