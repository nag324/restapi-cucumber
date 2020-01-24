package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Helpers {


    public static String getJsonPath(Response response, String key)
    {
        String resp=response.asString();
        System.out.println(resp);
        JsonPath js = new JsonPath(resp);
      //  System.out.println(js);
        return js.get(key).toString();
    }
}
