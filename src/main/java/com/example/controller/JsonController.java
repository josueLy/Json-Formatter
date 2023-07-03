package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.JsonFormatService;
import com.example.service.JsonTextFileService;

@RestController

@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:4200" })
public class JsonController {
    @Autowired
    private JsonFormatService jsonFormatService;

    @Autowired
    private JsonTextFileService jsonTextFileService;

    /*
     * @GetMapping("/json")
     * public String getMapString() {
     * return "Hola mundo";
     * }
     */

    @PostMapping("/json")
    public String jsonFormat(@RequestBody String texto) {
        String jsoString = jsonFormatService.getNewFormatJsonString(texto);
       //jsonTextFileService.createJsonFile(jsoString);
       return jsoString;
    }


    @PostMapping("/json_file")
    public void getJsonFile(@RequestBody String texto) {
        String jsoString = jsonFormatService.getNewFormatJsonString(texto);
       jsonTextFileService.createJsonFile(jsoString);
       //return jsoString;
    }

    

}
