package methods;

import URLS.Endpoints;
import Utilities.utilities;
import classes.Datum;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Methods {

    public Response getallinfobyid(){
        return given().when().get(Endpoints.FULL_INFO);
    }

    public Response createnewData(Object name,Object type,Object price,Object shipping,Object upc,Object description,Object manufacturer,Object model,Object url,Object image ){
        String Name=name+ utilities.getRandomValue();
        String Type=(String) type;
        float Price= Float.parseFloat(price+ utilities.getRandomValue());
        int Shipping=Integer.parseInt(String.valueOf(shipping));
        String Upc=(String) upc;
        String Description=(String) description;
        String Manufacturer=(String) manufacturer;
        String Model=(String)model;
        String Url=url+utilities.getRandomValue();
        String Image=(String) image;


        Datum datum=new Datum();
        datum.setName(Name);
        datum.setType(Type);
        datum.setPrice((float) Price);
        datum.setShipping((int) Shipping);
        datum.setUpc(Upc);
        datum.setDescription(Description);
        datum.setManufacturer(Manufacturer);
        datum.setModel(Model);
        datum.setUrl(Url);
        datum.setImage(Image);

        return given().contentType(ContentType.JSON).body(datum).post(Endpoints.FULL_INFO);
    }
    public Response getbyid(int id){
        return given().pathParams("id",id).when().get(Endpoints.GET_BY_ID);
    }

    public Response updatebyid(int id,Object name,Object type,Object price,Object shipping,Object upc,Object description,Object manufacturer,Object model,Object url,Object image ){
        String Name=name+ utilities.getRandomValue();
        String Type=(String) type;
        float Price= Float.parseFloat(String.valueOf(price));
        int Shipping=Integer.parseInt(String.valueOf(shipping));
        String Upc=(String) upc;
        String Description=(String) description;
        String Manufacturer=(String) manufacturer;
        String Model=(String)model;
        String Url=url+utilities.getRandomValue();
        String Image=(String) image;


        Datum datum=new Datum();
        datum.setName(Name);
        datum.setType(Type);
        datum.setPrice(Price);
        datum.setShipping(Shipping);
        datum.setUpc(Upc);
        datum.setDescription(Description);
        datum.setManufacturer(Manufacturer);
        datum.setModel(Model);
        datum.setUrl(Url);
        datum.setImage(Image);

        return given().contentType(ContentType.JSON).pathParams("id",id)
                .body(datum).when().patch(Endpoints.GET_BY_ID);
    }

    public Response deletebyID(int id){
       return given().pathParams("id",id).when().delete(Endpoints.GET_BY_ID);
    }
}
