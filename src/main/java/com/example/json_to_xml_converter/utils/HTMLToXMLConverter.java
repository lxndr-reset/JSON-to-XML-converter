package com.example.json_to_xml_converter.utils;

import org.json.JSONObject;
import org.json.XML;

public class HTMLToXMLConverter {
    public static String convert(String json) {
        JSONObject object = new JSONObject(json);
        String string = XML.toString(object);
        return string;
    }
}
