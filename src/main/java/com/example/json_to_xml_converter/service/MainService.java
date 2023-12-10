package com.example.json_to_xml_converter.service;

import com.example.json_to_xml_converter.utils.HTMLToXMLConverter;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    public String htmlToXml(String json){
        return HTMLToXMLConverter.convert(json);
    }
}
