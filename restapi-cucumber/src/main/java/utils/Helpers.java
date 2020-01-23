package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Helpers {


    public static String getJsonPath(Response response, String key)
    {
        String resp=response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }
}
