package bddpro5.methods;

import bddpro5.Utilities.utilities;
import bddpro5.classes.Datum;
import bddpro5.constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Methods {

    public Response getfullinfo() {
        return given().when().get(EndPoints.GET_FULLINFO);
    }

    public Response createnewData(Object name, Object type, Object price, Object shipping, Object upc, Object description, Object manufacturer, Object model, Object url, Object image) {
        String Name = name + utilities.getRandomValue();
        String Type = (String) type;
        float Price = Float.parseFloat(price + utilities.getRandomValue());
        int Shipping = Integer.parseInt(String.valueOf(shipping));
        String Upc = (String) upc;
        String Description = (String) description;
        String Manufacturer = (String) manufacturer;
        String Model = (String) model;
        String Url = url + utilities.getRandomValue();
        String Image = (String) image;


        Datum datum = new Datum();
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

        return given().contentType(ContentType.JSON).body(datum).post(EndPoints.GET_FULLINFO);
    }

    public Response getbyid(int id){
        return given().pathParams("id",id).when().get(EndPoints.GET_BYID);
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
                .body(datum).when().patch(EndPoints.GET_BYID);
    }
    public Response deletebyID(int id){
        return given().pathParams("id",id).when().delete(EndPoints.GET_BYID);
    }
}
