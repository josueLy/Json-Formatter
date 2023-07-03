package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class JsonFormatService {

    public String getNewFormatJsonString(String text) {
        String json = null;

        if (text.contains("\\r\\n")) {
            json = text.replace("\\n", "").replace("\\r", "").replace("\\", "");
        } else {
            json = text.replace("\\n", "").replace("\\", "");
        }

        return json;
    }

}
