package utils;

import org.json.JSONObject;
import org.json.XML;

public class Convert {

    public static String toJSON(Object obj) {
        JSONObject jobj = new JSONObject(obj);
        return jobj.toString();
    }

    public static Object XMLToObject(String xml) {
        Object xmlObj = XML.toJSONObject(xml);
        return xmlObj;
    }

    public static String ObjectToXML(Object xmlObj) {
        JSONObject obj = new JSONObject(xmlObj);
        return obj.toString();
    }
}
