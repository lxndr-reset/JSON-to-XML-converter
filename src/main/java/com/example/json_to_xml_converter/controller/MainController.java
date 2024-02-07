package com.example.json_to_xml_converter.controller;

import com.example.json_to_xml_converter.service.MainService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/json-to-xml")
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping
    public String convertFromBody(@RequestBody String json) {
        return mainService.htmlToXml(json);
    }

    @GetMapping("/{json}")
    public String getFromBody(@PathVariable String json) {
        return mainService.htmlToXml(json);
    }
}
