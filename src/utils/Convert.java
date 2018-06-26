package utils;


import org.json.JSONObject;

public class Convert {

    public static String toJSON(Object obj) {
        JSONObject jobj = new JSONObject(obj);
        return jobj.toString();
    }
}
